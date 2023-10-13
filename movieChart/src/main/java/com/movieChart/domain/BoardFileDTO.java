package com.movieChart.domain;

public class BoardFileDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private int bno;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return "BoardFileDTO [uuid=" + uuid + ", uploadPath=" + uploadPath + ", fileName=" + fileName + ", bno=" + bno
				+ "]";
	}
	
}
