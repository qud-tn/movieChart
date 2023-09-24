package com.movieChart.domain;

import java.util.List;

public class UserDTO {
	private String username;
	private String password;
	private boolean enabled;
	private String nickname;
	private int user_id;
	private String email;
	private String reg_date;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "UsersDTO [username=" + username + ", password=" + password + ", enabled=" + enabled + ", nickname="
				+ nickname + ", user_id=" + user_id + ", email=" + email + ", reg_date=" + reg_date + "]";
	}
	
	
	
}
