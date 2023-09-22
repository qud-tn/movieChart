package com.movieChart.domain;

import java.util.List;

public class UsersDTO {
	private String username;
	private String password;
	private boolean enabled;
	private String nickname;
	private int userCode;
	private String email;
	private String regDate;
	private List<AuthoritiesDTO> authList;
	
	public List<AuthoritiesDTO> getAuthList() {
		return authList;
	}
	public void setAuthList(List<AuthoritiesDTO> authList) {
		this.authList = authList;
	}
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
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UsersDTO [username=" + username + ", password=" + password + ", enabled=" + enabled + ", nickname="
				+ nickname + ", userCode=" + userCode + ", email=" + email + ", regDate=" + regDate + "]";
	}
	
	
	
}
