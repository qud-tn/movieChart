package com.movieChart.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlsession;
	
	private final String NAMESPACE = "com.movieChart.mapper.BoardMapper";
	
	public void insertBoard(BoardDTO bdto) throws Exception {
		sqlsession.insert(NAMESPACE+".insertBoard", bdto);
	}
}
