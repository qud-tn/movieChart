package com.movieChart.persistance;

import java.util.List;

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

	@Override
	public List<BoardDTO> selectBoardList() throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectBoardList");
	}

	@Override
	public BoardDTO selectBoard(Integer board_id) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectBoard",board_id);
	}
	@Override
	public List<BoardDTO> selectBoardAround(Integer board_id) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectBoardAround",board_id);
	}
}
