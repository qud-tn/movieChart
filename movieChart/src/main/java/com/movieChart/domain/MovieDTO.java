package com.movieChart.domain;

public class MovieDTO {
	private int code_no;
	private String title;
	private String image;
	private String synopsis;
	
	public int getCode_no() {
		return code_no;
	}
	public void setCode_no(int code_no) {
		this.code_no = code_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	@Override
	public String toString() {
		return "MovieInfoDTO [code_no=" + code_no + ", title=" + title + ", image=" + image + ", synopsis=" + synopsis
				+ "]";
	}
	
	
}
