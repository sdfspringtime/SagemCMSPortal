package com.CMSBACK.security.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

import com.CMSBACK.security.services.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter implements EnvironmentAware {
	@Autowired
	private JwtUtils jwtUtils;
	private static Environment env;

	public static String getProperty(String key) {
	    return env.getProperty(key);
	}

	@Override
	public void setEnvironment(Environment env) {
	    this.env = env;
	}
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
	private Environment environment;
	 private LdapContextSource contextSource;
	    private LdapTemplate ldapTemplate;
	  
	public AuthTokenFilter() {
			super();
		}
	public AuthTokenFilter(Environment environment) {
			super();
			this.environment = env;
		}
	 private void initContext()
	    {   contextSource = new LdapContextSource();
	        contextSource.setUrl(env.getProperty("ldap.server.url"));
	        contextSource.setAnonymousReadOnly(true);
	        contextSource.setUserDn("uid={0},ou=people");
	        //contextSource.setBase("ou=groups");
	        contextSource.afterPropertiesSet();
	        ldapTemplate = new LdapTemplate(contextSource);
	    }
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			initContext();
			
			 String jwt = parseJwt(request);
			 if  ((jwt != null) && jwtUtils.validateJwtToken(jwt)) {
				 String username = jwtUtils.getUserNameFromJwtToken(jwt);
				 LdapQuery  query=query()
			            .base("")
			            .attributes("mail", "uid")
			            .where("objectclass").is("person")
			            .and("uid").is(username);
				 List<String> aaa= ldapTemplate.search(query,
			            new AttributesMapper<String>() {
			               public String mapFromAttributes(Attributes attrs)
			                  throws NamingException {

			            	   return (String) attrs.get("mail").get();} 
			               });
				 List<String> bbb= ldapTemplate.search(query,
				            new AttributesMapper<String>() {
				               public String mapFromAttributes(Attributes attrs)
				                  throws NamingException {

				            	   return (String) attrs.get("mail").get();} 
				               });
					
					Boolean aa= (aaa.isEmpty());
					if (!aa) {
						 List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

				            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                     UserDetails usrdets= new User(username,bbb.get(0).toString(),list);
                     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
     						usrdets, bbb.get(0), usrdets.getAuthorities());
                     authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

     				SecurityContextHolder.getContext().setAuthentication(authentication);
						System.out.println(aaa);
						System.out.println("LDAP user Connected");}
					else {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, userDetails.getPassword(), userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request)
	  throws ServletException {
	    String path = request.getRequestURI();
	    return "/auth-server/**".equals(path);
	}
	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
