package com.CMSBACK.models;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import static org.springframework.ldap.query.LdapQueryBuilder.query;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Component
public class LdapAuthenticationProvider implements AuthenticationProvider
{
    private Environment environment;

    public LdapAuthenticationProvider(Environment environment) {
        this.environment = environment;
    }

    private LdapContextSource contextSource;
    private LdapTemplate ldapTemplate;

    private void initContext()
    {   contextSource = new LdapContextSource();
        contextSource.setUrl(environment.getProperty("ldap.server.url"));
        contextSource.setAnonymousReadOnly(true);
        contextSource.setUserDn("uid={0},ou=people");
        //contextSource.setBase("ou=groups");
        contextSource.afterPropertiesSet();
        ldapTemplate = new LdapTemplate(contextSource);
    }
    public List<String> getLdapmail(String username) {
    LdapQuery  query=query()
            .base("")
            .attributes("mail", "uid")
            .where("objectclass").is("person")
            .and("uid").is(username);
    return ldapTemplate.search(query,
            new AttributesMapper<String>() {
               public String mapFromAttributes(Attributes attrs)
                  throws NamingException {

                  return (String) attrs.get("mail").get();}});}
    
						
    		            
    

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        initContext();
        Filter filter = new EqualsFilter("uid", authentication.getName());
        Boolean authenticate = ldapTemplate.authenticate(LdapUtils.emptyLdapName(), filter.encode(), authentication.getCredentials().toString());
        if (authenticate)
        {

            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        	
            UserDetails userDetails = new User(authentication.getName(), authentication.getCredentials().toString()
                    , list);
            
         
                
            
            
            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,
                    authentication.getCredentials().toString(),list);
            return auth;
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}