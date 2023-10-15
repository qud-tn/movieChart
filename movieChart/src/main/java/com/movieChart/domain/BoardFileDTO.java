package com.movieChart.domain;

public class BoardFileDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private int board_id;
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
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	@Override
	public String toString() {
		return "BoardFileDTO [uuid=" + uuid + ", uploadPath=" + uploadPath + ", fileName=" + fileName + ", board_id="
				+ board_id + "]";
	}
	
}