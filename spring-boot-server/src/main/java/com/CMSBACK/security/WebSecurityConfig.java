package com.CMSBACK.security;

import org.apache.logging.slf4j.SLF4JProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.CMSBACK.models.LdapAuthenticationProvider;
import com.CMSBACK.security.jwt.AuthEntryPointJwt;
import com.CMSBACK.security.jwt.AuthTokenFilter;
import com.CMSBACK.security.jwt.JwtTokenProvider;
import com.CMSBACK.security.services.UserDetailsServiceImpl;
public class WebSecurityConfig  {
	 @Configuration
	 @Order(1)
	    public static class JwtWebSecurityConfig extends WebSecurityConfigurerAdapter{
		   

		 public JwtWebSecurityConfig() {
			 super();
		        
		    }
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	private Environment env;
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter(Environment env) {
		return new AuthTokenFilter(this.env);
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
           .requestMatchers().antMatchers("/api/auth/**")
           .requestMatchers().antMatchers("/api/test/**")
			
			.and()
	         ;
		http.addFilterBefore(authenticationJwtTokenFilter(env), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	 }
@Configuration

public static class LDAPTokenSecurityConfig extends WebSecurityConfigurerAdapter{
	private Environment env;
	 @Bean
	    public JwtTokenProvider provider(){
	        return new JwtTokenProvider();
	    }
	 public LDAPTokenSecurityConfig(Environment env) {
		 this.env=env;
	 }
		@Override
		public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
			authenticationManagerBuilder.authenticationProvider(new LdapAuthenticationProvider(env)).eraseCredentials(false); 

		}
	 @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception 
	    {
	        httpSecurity
           .requestMatchers().antMatchers("/auth-server")

	                .and().
	                cors().and()
	                .csrf()
	                .disable()
	                .httpBasic();
	    }}}
	/*public LDAPTokenSecurityConfig() {
		
       super();
   }
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		 http
		 
		 .authorizeRequests()
        .antMatchers("/admin/**").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .csrf()
        .disable()
        .httpBasic();
   ;}
	  @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	          .url("ldap://localhost:8389/dc=springframework,dc=org")
	          .and()
	        .passwordCompare()
	          .passwordEncoder(new BCryptPasswordEncoder())
	          .passwordAttribute("userPassword");
	  }
	/*@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}*/

  /* @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
           .antMatcher("/**") //this is default
           .authorizeRequests()
           .antMatchers("/admin/login").permitAll()
           .and()
           .authorizeRequests()
           .anyRequest()
           .authenticated()
           ;
   }*/