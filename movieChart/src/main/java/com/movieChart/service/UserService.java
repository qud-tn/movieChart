package com.movieChart.service;


import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UserDTO;

public interface UserService {
	public void joinMember(UserDTO userdto,AuthoritiesDTO authDTO) throws Exception;

	public boolean checkUsername(String username) throws Exception;
}
