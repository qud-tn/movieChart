package com.movieChart.domain;

public class ReviewDTO {
	private String nickname;
	private String username;
	private String review;
	private Integer score;
	private Integer review_id;
	private String review_dt;
	private String code_no;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	public String getReview_dt() {
		return review_dt;
	}
	public void setReview_dt(String review_dt) {
		this.review_dt = review_dt;
	}
	public String getCode_no() {
		return code_no;
	}
	public void setCode_no(String code_no) {
		this.code_no = code_no;
	}
	
	@Override
	public String toString() {
		return "ReviewDTO [nickname=" + nickname + ", username=" + username + ", review=" + review + ", score=" + score
				+ ", review_id=" + review_id + ", review_dt=" + review_dt + ", code_no=" + code_no + "]";
	}
	
}
