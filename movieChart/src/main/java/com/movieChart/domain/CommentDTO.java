package com.movieChart.domain;

public class CommentDTO {
	private String nickname;
	private String comment;
	private int score;
	private String datetime;
	private int movieCode;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}
	@Override
	public String toString() {
		return "CommentDTO [nickname=" + nickname + ", comment=" + comment + ", score=" + score + ", datetime="
				+ datetime + ", movieCode=" + movieCode + "]";
	}
}
