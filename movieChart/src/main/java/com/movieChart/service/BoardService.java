package com.movieChart.service;

import java.util.List;

import com.movieChart.domain.BoardDTO;

public interface BoardService {
	public void writeBoard(BoardDTO bdto) throws Exception;

	public List<BoardDTO> getBoardList() throws Exception;

	public BoardDTO readBoardContent(Integer board_id);
}
