/*package com.CMSBACK.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.CMSBACK.models.LdapAuthenticationProvider;
import com.CMSBACK.security.jwt.JwtTokenProvider;
@Order(2)
@Configuration
@EnableWebSecurity
public class LDAPConfiguration extends WebSecurityConfigurerAdapter{


	
	  private Environment env;
	    public LDAPConfiguration(Environment env){
	        this.env = env;
	    }
	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception
	    {
	        auth.authenticationProvider(new LdapAuthenticationProvider(env)).eraseCredentials(false); 
	    }
	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception 
	    {
	        httpSecurity
	                .authorizeRequests()
	                .antMatchers("/auth-server/**").permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .csrf()
	                .disable()
	                .httpBasic();
	    }
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	   @Bean
	    public JwtTokenProvider provider(){
	        return new JwtTokenProvider();
	    }
	}

*/