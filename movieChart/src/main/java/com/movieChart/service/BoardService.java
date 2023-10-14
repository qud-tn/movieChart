package com.movieChart.service;

import java.util.HashMap;
import java.util.List;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;

public interface BoardService {
	public void writeBoard(BoardDTO bdto) throws Exception;

	public List<BoardDTO> getBoardList(PageDTO pdto) throws Exception;

	public HashMap<String, Object> readBoardContent(Integer board_id)throws Exception;

	public void modifyBoard(BoardDTO bdto) throws Exception;
	
	public Integer softDeleteBoard(Integer board_id) throws Exception;
	
	public void upViewcnt(Integer board_id) throws Exception;
	
	public int countBoard_id() throws Exception;
}
