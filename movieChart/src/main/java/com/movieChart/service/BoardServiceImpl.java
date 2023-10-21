package com.movieChart.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.movieChart.controller.BoardRestController;
import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.BoardFileDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.domain.PageMaker;
import com.movieChart.persistance.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
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
	public Map<String, Object> readBoardContent(Integer board_id) throws Exception {
		Map<String, Object> boardMap = bdao.selectBoard(board_id).toHashMap();
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

	@Override
	public List<BoardDTO> getDeletedBoardList(PageDTO pdto) throws Exception {
		return bdao.selectDeletedBoards(pdto);
	}

}
