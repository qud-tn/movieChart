package com.movieChart.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.UsersDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	final String NAMESPACE = "com.movieChart.mapper.UsersMapper";
	
	@Override
	public void insertUser(UsersDTO userdto) {
		sqlsession.insert(NAMESPACE+".insertUser",userdto);
	}

	@Override
	public String selectUsername(UsersDTO userdto) {
		return sqlsession.selectOne(NAMESPACE+".selectUsername",userdto);
	}

}
