package com.movieChart.domain;

public class AuthoritiesDTO {
	private String username;
	private String authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authorities) {
		this.authority = authorities;
	}
	@Override
	public String toString() {
		return "AuthoritesDTO [username=" + username + ", authorities=" + authority + "]";
	}
	
	
}
