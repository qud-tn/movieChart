package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.UserDTO;

public interface UserDAO {

	public void insertUser(UserDTO userdto)throws Exception;

	public List<Integer> selectUserIdAll() throws Exception;

	public String selectUsername(UserDTO udto) throws Exception;

	public String selectNickname(String nickname) throws Exception;

	public String selectEmail(String email) throws Exception;

	public String selectPassword(UserDTO udto) throws Exception;

	public int updateUserInfo(UserDTO udto) throws Exception;

	public String checkEmail(String email) throws Exception;

	public int updatePassword(UserDTO udto) throws Exception;

	public String checkingForPassword(UserDTO udto) throws Exception;

}
