package com.movieChart.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public void uploadFile(String UPLOADPATH, MultipartFile[] files) throws Exception;
	
	public List<String> buildFilePath(String UPLOADPATH,int board_id) throws Exception;
}
