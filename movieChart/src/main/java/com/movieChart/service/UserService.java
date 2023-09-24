package com.movieChart.service;

import javax.servlet.http.HttpSession;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UserDTO;

public interface UserService {
	public void joinMember(UserDTO userdto,AuthoritiesDTO authDTO);

	public String login(UserDTO userdto);
}
