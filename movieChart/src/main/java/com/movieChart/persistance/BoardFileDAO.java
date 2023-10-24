package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.BoardFileDTO;

public interface BoardFileDAO {
	public int insertBoardFiles(BoardFileDTO bfdto) throws Exception;
	
	public List<BoardFileDTO> selectBoardFiles(int board_id) throws Exception;
}
