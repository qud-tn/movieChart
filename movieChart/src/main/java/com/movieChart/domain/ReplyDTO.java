package com.movieChart.domain;

public class ReplyDTO {
	private int board_id;
	private int reply_id;
	private String reply;
	private String username;
	private String reply_dt;
	private String deleted_dt;
	private String nickname;
	
	
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDeleted_dt() {
		return deleted_dt;
	}
	public void setDeleted_dt(String deleted_dt) {
		this.deleted_dt = deleted_dt;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReply_dt() {
		return reply_dt;
	}
	public void setReply_dt(String reply_dt) {
		this.reply_dt = reply_dt;
	}
	
	@Override
	public String toString() {
		return "ReplyDTO [board_id=" + board_id + ", reply_id=" + reply_id + ", reply=" + reply + ", username="
				+ username + ", reply_dt=" + reply_dt + ", deleted_dt=" + deleted_dt + ", nickname=" + nickname + "]";
	}
	
}
