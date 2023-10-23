package com.movieChart.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.AuthoritiesDTO;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {

	@Inject
	private SqlSession sqlsession;
	
	private final String NAMESPACE = "com.movieChart.mapper.AuthoritiesMapper";
	
	@Override
	public void insertAuth(AuthoritiesDTO authDTO) throws Exception {
		sqlsession.insert(NAMESPACE+".insertAuth",authDTO);
		
	}

	@Override
	public int updateAuth(AuthoritiesDTO audto) throws Exception {
		return sqlsession.update(NAMESPACE+".updateAuth",audto);
	}

}
