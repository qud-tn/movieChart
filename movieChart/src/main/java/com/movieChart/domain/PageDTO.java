package com.movieChart.domain;

public class PageDTO {
	private int page;
	private int pageSize;

	public PageDTO() {
		this.page = 1;
		this.pageSize = 10;		
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize >100) {
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public int getStartPage() {
		return (this.page - 1) * this.pageSize;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", pageSize=" + pageSize + "]";
	}
}
