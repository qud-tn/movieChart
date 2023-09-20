package com.movieChart.service;

import javax.servlet.http.HttpSession;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UsersDTO;

public interface UserService {
	public void joinMember(UsersDTO userdto,AuthoritiesDTO authDTO);

	public String login(UsersDTO userdto);
}
