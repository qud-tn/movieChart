package com.movieChart.persistance;

import com.movieChart.domain.BoardFileDTO;

public interface BoardFileDAO {
	public int insertBoardFile(BoardFileDTO bfdto) throws Exception;
}
