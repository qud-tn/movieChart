package com.movieChart.security;

import javax.inject.Inject;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.movieChart.domain.CustomUser;
import com.movieChart.domain.UsersDTO;
import com.movieChart.mapper.UsersMapper;


@MapperScan("com.movieChart.mapper")
public class CustomUserDetailsService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Inject
	private UsersMapper usersmapper;
	
	
	
	public void setUsersmapper(UsersMapper usersmapper) {
		this.usersmapper = usersmapper;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersDTO dto= usersmapper.read(username);
		return dto== null? null:new CustomUser(dto);
	}

}
