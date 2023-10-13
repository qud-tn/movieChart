package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.UserDTO;

public interface UserDAO {

	public void insertUser(UserDTO userdto)throws Exception;

	public List<Integer> selectUserIdAll() throws Exception;

	public String selectUsername(UserDTO udto) throws Exception;

	public String selectNickname(String nickname) throws Exception;

	public String selectEmail(String email) throws Exception;

}
