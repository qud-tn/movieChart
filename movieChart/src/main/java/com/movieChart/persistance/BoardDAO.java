package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.BoardDTO;

public interface BoardDAO {
	public void insertBoard(BoardDTO bdto) throws Exception;

	public List<BoardDTO> selectBoardList() throws Exception;

	public BoardDTO selectBoard(Integer board_id);
}
