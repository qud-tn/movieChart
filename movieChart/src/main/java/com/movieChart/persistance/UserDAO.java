package com.movieChart.persistance;

import com.movieChart.domain.UserDTO;

public interface UserDAO {

	public void insertUser(UserDTO userdto);

	public String selectUsername(UserDTO userdto);

}
