package com.movieChart.persistance;

import com.movieChart.domain.BoardFileDTO;

public interface BoardFileDAO {
	public void insertBoardFile(BoardFileDTO bfdto) throws Exception;
}
