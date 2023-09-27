package com.movieChart.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	final String NAMESPACE = "com.movieChart.mapper.UserMapper";
	
	@Override
	public void insertUser(UserDTO userdto) throws Exception{
		sqlsession.insert(NAMESPACE+".insertUser",userdto);
	}

	@Override
	public String selectUsername(UserDTO udto) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectUsername",udto);
	}

	@Override
	public String selectNickname(String nickname) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectNickname", nickname);
	}
	
	@Override
	public List<Integer> selectUserIdAll() throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectUserIdAll");
	}
	
	

}
