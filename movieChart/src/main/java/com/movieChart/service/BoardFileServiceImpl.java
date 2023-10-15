package com.movieChart.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
	public void uploadFile(MultipartFile[] files) throws Exception {
		BoardFileDTO bfdto=new BoardFileDTO();
		final String UPLOADPATH = "D:\\upload";
		
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
	        bdao.insertBoardFile(bfdto);
	        try {
	        	files[i].transferTo(saveFile);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
