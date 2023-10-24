package com.movieChart.persistance;

import java.util.List;
import java.util.Map;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;

public interface BoardDAO {
	public void insertBoard(BoardDTO bdto) throws Exception;

	public List<BoardDTO> selectBoardList(Map<String, Object> paramMap) throws Exception;

	public BoardDTO selectBoard(Integer board_id) throws Exception;

	public List<BoardDTO> selectSurroundingBoard(Integer board_id) throws Exception;

	public void updateBoard(BoardDTO bdto) throws Exception;
	
	public Integer softDeleteBoard(Integer board_id) throws Exception;

	public void updateViewcntOne(Integer board_id) throws Exception;
	
	public int selectCountBoard_id() throws Exception;

	public List<BoardDTO> selectDeletedBoards(PageDTO pdto) throws Exception;
	
	public int selectCountDeletedBoards() throws Exception;
}
