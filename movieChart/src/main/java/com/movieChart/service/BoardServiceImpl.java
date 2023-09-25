package com.movieChart.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.movieChart.domain.BoardDTO;
import com.movieChart.persistance.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void writeBoard(BoardDTO bdto) throws Exception {
		bdao.insertBoard(bdto);
	}

	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		return bdao.selectBoardList();
	}

	@Override
	public BoardDTO readBoardContent(Integer board_id) {
		return bdao.selectBoard(board_id);
	}

}
