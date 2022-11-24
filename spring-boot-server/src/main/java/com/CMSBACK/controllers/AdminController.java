package com.CMSBACK.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBACK.models.LdapAuthenticationProvider;
import com.CMSBACK.payload.request.LoginRequest;
import com.CMSBACK.payload.response.AuthenticationResponse;
import com.CMSBACK.security.jwt.JwtTokenProvider;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/auth-server")
public class AdminController
{
    private static final String USER_DISABLED = "USER DISABLED";
    private static final String INVALID_CREDENTIALS = "INVALID CREDENTIALS";

    @Autowired
    private LdapAuthenticationProvider authenticationProvider;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<?> authenticateRequest(@RequestHeader Map<String, String> headers) throws Exception{
    	headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });
		SecurityContextHolder.getContext().setAuthentication(authenticate(SecurityContextHolder.getContext().getAuthentication()));
    
    	System.out.println(authenticate(SecurityContextHolder.getContext().getAuthentication()));
        final String token = JwtTokenProvider.generateToken(SecurityContextHolder.getContext().getAuthentication().getName());
        
        return ResponseEntity.ok(new AuthenticationResponse(token,SecurityContextHolder.getContext().getAuthentication().getName(),authenticationProvider.getLdapmail(SecurityContextHolder.getContext().getAuthentication().getName()).get(0),"ROLE_ADMIN"));
    }

    private Authentication authenticate(Authentication auth) throws Exception {
        try {
            return authenticationProvider.authenticate(auth);
        } catch (DisabledException e) {
            throw new Exception(USER_DISABLED, e);
        } catch (BadCredentialsException e) {
            throw new Exception(INVALID_CREDENTIALS, e);
        }
    }}
