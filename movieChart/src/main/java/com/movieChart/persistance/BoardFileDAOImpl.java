package com.movieChart.persistance;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.BoardFileDTO;

@Repository
public class BoardFileDAOImpl implements BoardFileDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.movieChart.mapper.BoardFileMapper";

	@Override
	public int insertBoardFile(BoardFileDTO bfdto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertBoardFile",bfdto);
	}
	
	
}
