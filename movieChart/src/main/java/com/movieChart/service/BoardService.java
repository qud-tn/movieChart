package com.movieChart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.domain.PageMaker;

public interface BoardService {
	public void writeBoard(BoardDTO bdto) throws Exception;

	public List<BoardDTO> getBoardList(Map<String, Object> paramMap) throws Exception;

	public Map<String, Object> readBoardContent(Integer board_id)throws Exception;

	public void modifyBoard(BoardDTO bdto) throws Exception;
	
	public Integer softDeleteBoard(Integer board_id) throws Exception;
	
	public void upViewcnt(Integer board_id) throws Exception;
	
	public int countBoard_id() throws Exception;

	public List<BoardDTO> getDeletedBoardList(PageDTO pdto) throws Exception;
	
	public int countDeletedBoards() throws Exception;
}
