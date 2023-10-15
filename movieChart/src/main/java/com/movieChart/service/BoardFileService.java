package com.movieChart.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public void uploadFile(List<MultipartFile> fileList) throws Exception;
}
