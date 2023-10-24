package com.movieChart.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movieChart.domain.BoardFileDTO;
import com.movieChart.persistance.BoardFileDAO;

@Service
public class BoardFileServiceImpl implements BoardFileService {
	private static final Logger logger = LoggerFactory.getLogger(BoardFileServiceImpl.class);
	
	@Autowired
	private BoardFileDAO bdao;
	
	@Override
	public void uploadFile(String UPLOADPATH, MultipartFile[] files) throws Exception {
		BoardFileDTO bfdto=new BoardFileDTO();
		
		bfdto.setUploadPath(UPLOADPATH);
		
		for(int i = 0; i < files.length; i++) {
	        String originalFileName = files[i].getOriginalFilename();
	        String uuid = UUID.randomUUID().toString();
	        String savedFileName = uuid + "_" + originalFileName;
	        
	        bfdto.setFileName(originalFileName);
	        bfdto.setUuid(uuid);
	        
	        logger.info("파일명: " + savedFileName);
	        long size = files[i].getSize();
	        logger.info("사이즈: " + size);

	        File saveFile = new File(UPLOADPATH + "\\" + savedFileName);
	        bdao.insertBoardFiles(bfdto);
	        try {
	        	files[i].transferTo(saveFile);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public List<String> buildFilePath(String UPLOADPATH, int board_id) throws Exception {
		List<BoardFileDTO> boardFileList= bdao.selectBoardFiles(board_id);
		List<String> boardFileStringList=new ArrayList<String>();
		
		for(int i=0;i<boardFileList.size();i++) {
			String uuid= boardFileList.get(i).getUuid();
			String filename=boardFileList.get(i).getFileName();
			
			String filePath= UPLOADPATH + "\\" +uuid + "_" + filename;
			boardFileStringList.add(filePath);
		}
		
		return boardFileStringList;
	}
}
