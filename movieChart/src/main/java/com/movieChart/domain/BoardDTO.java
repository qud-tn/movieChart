package com.movieChart.domain;

import java.util.HashMap;

public class BoardDTO {
	private Integer board_id;
	private String title;
	private String content;
	private String category;
	private String user_id;
	private String nickname;
	private String write_date;
	private Integer view_cnt;
	
	   public HashMap<String, Object> toHashMap() {
	        HashMap<String, Object> BoardMap = new HashMap<>();
	        BoardMap.put("board_id", this.getBoard_id());
	        BoardMap.put("title", this.getTitle());
	        BoardMap.put("content", this.getContent());
	        BoardMap.put("category", this.getCategory());
	        BoardMap.put("user_id", this.getUser_id());
	        BoardMap.put("nickname", this.getNickname());
	        BoardMap.put("write_date", this.getWrite_date());
	        BoardMap.put("view_cnt", this.getView_cnt());
	        return BoardMap;
	    }
	
	public Integer getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(Integer view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [board_id=" + board_id + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", user_id=" + user_id + ", nickname=" + nickname + "]";
	}
	
	
}
