package com.movieChart.domain;

import java.time.LocalDate;

public class BoxOfficeDTO {
	private String targetDt; // 조회하고자 하는 날짜
	private String itemPerPage; // 결과 ROW 의 개수(최대 10개)
	private String multiMovieYn; // Y: 다양성 영화, N: 상업영화, Default: 전체
	private String repNationCd;

	public BoxOfficeDTO() {
		this.multiMovieYn = "";
		this.repNationCd = "";
	}

	public String getTargetDt() {
		return targetDt;
	}

	public void setTargetDt(String targetDt) {
		if (targetDt.equals("") || targetDt == null) {
			this.targetDt = LocalDate.now().minusDays(1).toString();
		} else {
			this.targetDt = targetDt;
		}
	}

	public String getItemPerPage() {
		return itemPerPage;
	}

	public void setItemPerPage(String itemPerPage) {
		this.itemPerPage = itemPerPage;
	}

	public String getMultiMovieYn() {
		return multiMovieYn;
	}

	public void setMultiMovieYn(String multiMovieYn) {
		this.multiMovieYn = multiMovieYn;
	}

	public String getRepNationCd() {
		return repNationCd;
	}

	public void setRepNationCd(String repNationCd) {
		this.repNationCd = repNationCd;
	}

	@Override
	public String toString() {
		return "BoxOfficeDTO [targetDt=" + targetDt + ", itemPerPage=" + itemPerPage + ", multiMovieYn=" + multiMovieYn
				+ ", repNationCd=" + repNationCd + "]";
	}
}
