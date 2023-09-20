package com.movieChart.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsersDTO udto;
	
	public UsersDTO getUdto() {
		return udto;
	}

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(UsersDTO dto) {
		super(dto.getUsername(),dto.getPassword(),dto.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
					.collect(Collectors.toList()));
		
		this.udto=dto;
	}


}
