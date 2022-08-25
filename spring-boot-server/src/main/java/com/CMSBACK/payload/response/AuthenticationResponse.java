package com.CMSBACK.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse
{
    private String accessToken;
    private String Username;
    private String mail;
	public AuthenticationResponse(String accessToken, String username, String mail, String roles) {
		super();
		this.accessToken = accessToken;
		Username = username;
		this.mail = mail;
		this.roles = roles;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public AuthenticationResponse(String accessToken,String roles) {
		super();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
public String getRoles() {
		return roles;
	}

	public void setRole(String roles) {
		this.roles = roles;
	}
private String roles="ROLE_ADMIN";
}