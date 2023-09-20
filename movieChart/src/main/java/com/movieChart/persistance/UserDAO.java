package com.movieChart.persistance;

import com.movieChart.domain.UsersDTO;

public interface UserDAO {

	public void insertUser(UsersDTO userdto);

	public String selectUsername(UsersDTO userdto);

}
