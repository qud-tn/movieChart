package com.movieChart.domain;

public class MovieListDTO {
	private String curPage;
	private String itemPerPage;
	private String movieNm;
	private String directorNm;
	private String openStartDt;
	private String repNationCd;
	private String movieTypeCd;
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public String getItemPerPage() {
		return itemPerPage;
	}
	public void setItemPerPage(String itemPerPage) {
		this.itemPerPage = itemPerPage;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getDirectorNm() {
		return directorNm;
	}
	public void setDirectorNm(String directorNm) {
		this.directorNm = directorNm;
	}
	public String getOpenStartDt() {
		return openStartDt;
	}
	public void setOpenStartDt(String openStartDt) {
		this.openStartDt = openStartDt;
	}
	public String getRepNationCd() {
		return repNationCd;
	}
	public void setRepNationCd(String repNationCd) {
		this.repNationCd = repNationCd;
	}
	public String getMovieTypeCd() {
		return movieTypeCd;
	}
	public void setMovieTypeCd(String movieTypeCd) {
		this.movieTypeCd = movieTypeCd;
	}
	@Override
	public String toString() {
		return "MovieListDTO [curPage=" + curPage + ", itemPerPage=" + itemPerPage + ", movieNm=" + movieNm
				+ ", directorNm=" + directorNm + ", openStartDt=" + openStartDt + ", repNationCd=" + repNationCd
				+ ", movieTypeCd=" + movieTypeCd + "]";
	}
	
	
}
