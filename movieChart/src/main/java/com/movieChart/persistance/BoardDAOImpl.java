package com.movieChart.persistance;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.domain.PageMaker;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlsession;
	
	private final String NAMESPACE = "com.movieChart.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardDTO bdto) throws Exception {
		sqlsession.insert(NAMESPACE+".insertBoard", bdto);
	}

	@Override
	public List<BoardDTO> selectBoardList(Map<String, Object> paramMap) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectBoardList",paramMap);
	}

	@Override
	public BoardDTO selectBoard(Integer board_id) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectBoard",board_id);
	}
	
	@Override
	public List<BoardDTO> selectSurroundingBoard(Integer board_id) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectSurroundingBoard",board_id);
	}

	@Override
	public void updateBoard(BoardDTO bdto) throws Exception {
		sqlsession.update(NAMESPACE+".updateBoard", bdto);
	}

	@Override
	public Integer softDeleteBoard(Integer board_id) throws Exception {
		return sqlsession.update(NAMESPACE+".softDeleteBoard", board_id);
	}

	@Override
	public void updateViewcntOne(Integer board_id) throws Exception {
		sqlsession.update(NAMESPACE+".updateViewcntOne",board_id);
	}

	@Override
	public int selectCountBoard_id() throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectCountBoard_id");
	}

	@Override
	public List<BoardDTO> selectDeletedBoards(PageDTO pdto) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectDeletedBoards",pdto);
	}
}
