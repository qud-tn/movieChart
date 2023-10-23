package com.movieChart.service;


import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UserDTO;

public interface UserService {
	public void joinMember(UserDTO userdto,AuthoritiesDTO authDTO) throws Exception;

	public boolean findUsername(UserDTO udto) throws Exception;

	public boolean findNickname(String nickname) throws Exception;

	public boolean findEmail(String email) throws Exception;

	public boolean CheckPassword(UserDTO udto) throws Exception;

	public int modifyUserInfo(UserDTO udto) throws Exception;

	public String CheckEmail(String email) throws Exception;

	public boolean modifyPassword(UserDTO udto) throws Exception;

	public boolean checkingIDForPassword(UserDTO udto) throws Exception;
	
}
