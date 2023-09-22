package com.movieChart.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.movieChart.domain.UsersDTO;

@Mapper
public interface UsersMapper {
	public UsersDTO read(String username);
}
