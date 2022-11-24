package com.CMSBACK.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LDAPUserDTO {
	private String username;
	@JsonIgnore
    private String password;
	private String mail;
	private String roles;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return mail;
	}
	public void setEmail(String mail) {
		this.mail = mail;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public LDAPUserDTO(String username, String password, String mail, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.roles = roles;
	}
	public LDAPUserDTO(String username, String password, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

}
