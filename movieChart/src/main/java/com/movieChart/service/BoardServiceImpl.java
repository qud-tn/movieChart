package com.movieChart.service;

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

}
