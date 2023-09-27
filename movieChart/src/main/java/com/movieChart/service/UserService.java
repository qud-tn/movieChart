package com.movieChart.service;


import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UserDTO;

public interface UserService {
	public void joinMember(UserDTO userdto,AuthoritiesDTO authDTO) throws Exception;

	public boolean checkUsername(UserDTO udto) throws Exception;

	public boolean checkNickname(String nickname) throws Exception;
}
