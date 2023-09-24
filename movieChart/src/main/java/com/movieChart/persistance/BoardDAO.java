package com.movieChart.persistance;

import com.movieChart.domain.BoardDTO;

public interface BoardDAO {
	public void insertBoard(BoardDTO bdto) throws Exception;
}
