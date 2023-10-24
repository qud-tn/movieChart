package com.movieChart.persistance;

import java.util.List;

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
	public int insertBoardFiles(BoardFileDTO bfdto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertBoardFiles",bfdto);
	}

	@Override
	public List<BoardFileDTO> selectBoardFiles(int board_id) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectBoardFiles",board_id);
	}
	
	
}
