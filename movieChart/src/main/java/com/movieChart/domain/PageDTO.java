package com.movieChart.domain;

public class PageDTO {
	private int page;
	private int pageSize;
	
	private int pageBlock = 10;  	//페이지 블럭의 수
	
	private int totalCount;  // 전체 글의 개수
	private int startPage;  // 페이지 시작번호
	private int endPage;	// 페이지 끝번호
	private boolean prev;   // 이전
	private boolean next;	// 다음
	
	private PageDTO pageDTO;
	
	public void setPageDTO(PageDTO pageDTO) {
		this.pageDTO = pageDTO;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calculatePage();
	}
	
	public void calculatePage() {
		endPage 
		 	= (int)(Math.ceil(pageDTO.getPage()/(double)pageBlock) * pageBlock);
		
		startPage
		  = (endPage - pageBlock) + 1;
		
		int tmpEndPage 
		= (int)(Math.ceil(totalCount / (double)pageDTO.getPageSize()));
		
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		//prev = (startPage == 1)? false : true;
		prev = startPage != 1;
		
		next = (endPage * pageDTO.getPageSize() >= totalCount)? false : true;
	}
	
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

	public int getTotalCount() {
		return totalCount;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public PageDTO getPageDTO() {
		return pageDTO;
	}

	@Override
	public String toString() {
		return "PageDTO [page=" + page + ", pageSize=" + pageSize + ", pageBlock=" + pageBlock + ", totalCount="
				+ totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", pageDTO=" + pageDTO + "]";
	}

}
