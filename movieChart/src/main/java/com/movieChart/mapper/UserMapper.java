package com.movieChart.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.movieChart.domain.UserDTO;

@Mapper
public interface UserMapper {
	public UserDTO read(String username);
}
