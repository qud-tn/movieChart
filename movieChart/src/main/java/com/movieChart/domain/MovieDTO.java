package com.movieChart.domain;

public class MovieDTO {
	private String code_no;
	private String title;
	private String image;
	private String synopsis;
	private String genre;
	private String director;
	private String update_dt;
	private int prod_year;
	
	
	public int getProd_year() {
		return prod_year;
	}
	public void setProd_year(int prod_year) {
		this.prod_year = prod_year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public String getCode_no() {
		return code_no;
	}
	public void setCode_no(String code_no) {
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
		return "MovieDTO [code_no=" + code_no + ", title=" + title + ", image=" + image + ", synopsis=" + synopsis
				+ ", genre=" + genre + ", director=" + director + ", update_dt=" + update_dt + ", prod_year="
				+ prod_year + "]";
	}
}
