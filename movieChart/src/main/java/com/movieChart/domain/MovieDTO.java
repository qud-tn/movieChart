package com.movieChart.domain;

public class MovieDTO {
    private Integer listCount;
    private Integer startCount;
    private String collection;
    private String query;
    private String detail;
    private String sort;
    private String releaseDts;
    private String title;
    
    public MovieDTO() {
    	this.startCount=1;
    	this.query="";
    	this.detail="Y";
    	this.sort="";
    }
    
	public String getReleaseDts() {
		return releaseDts;
	}
	public void setReleaseDts(String releaseDts) {
		this.releaseDts = releaseDts;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getListCount() {
		return listCount;
	}
	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}
	public Integer getStartCount() {
		return startCount;
	}
	public void setStartCount(Integer startCount) {
		this.startCount = startCount;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "MovieDTO [listCount=" + listCount + ", startCount=" + startCount + ", collection=" + collection
				+ ", query=" + query + ", detail=" + detail + ", sort=" + sort + ", releaseDts=" + releaseDts
				+ ", title=" + title + "]";
	}
	
}
