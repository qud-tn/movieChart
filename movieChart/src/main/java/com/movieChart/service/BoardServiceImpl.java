package com.movieChart.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;
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
	public List<BoardDTO> getBoardList(PageDTO pdto) throws Exception {
		return bdao.selectBoardList(pdto);
	}

	@Override
	public HashMap<String, Object> readBoardContent(Integer board_id) throws Exception {
		HashMap<String, Object> boardMap = bdao.selectBoard(board_id).toHashMap();
		List<BoardDTO> SurroundingList = bdao.selectSurroundingBoard(board_id);
		boardMap.put("SurroundingList", SurroundingList);
		
		return boardMap;
	}

	@Override
	public void modifyBoard(BoardDTO bdto) throws Exception {
		bdao.updateBoard(bdto);
	}

	@Override
	public Integer softDeleteBoard(Integer board_id) throws Exception {
		return bdao.softDeleteBoard(board_id);
	}
	
	@Override
	public void upViewcnt(Integer board_id) throws Exception {
		bdao.updateViewcntOne(board_id);
	}

	@Override
	public int countBoard_id() throws Exception {
		return bdao.selectCountBoard_id();
	}

}
