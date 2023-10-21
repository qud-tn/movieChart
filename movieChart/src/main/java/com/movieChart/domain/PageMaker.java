package com.movieChart.domain;

public class PageMaker {
	private int totalCount;  // 전체 글의 개수
	private int startPage;  // 페이지 시작번호
	private int endPage;	// 페이지 끝번호
	private boolean prev;   // 이전
	private boolean next;	// 다음
	
	private int pageBlock = 10;  	//페이지 블럭의 수
	
	private PageDTO pageDTO;
	
	public void setPageDTO(PageDTO pageDTO) {
		this.pageDTO = pageDTO;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcMyPage();
	}
	
	public void calcMyPage() {
		
		endPage 
		 	= (int)(Math.ceil(pageDTO.getPage()/(double)pageBlock) * pageBlock);
		
		startPage
		  = (endPage - pageBlock) + 1;
		
		int tmpEndPage 
		= (int)(Math.ceil(totalCount / (double)pageDTO.getPageSize()));
		
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		prev = startPage != 1;
		
		next = (endPage * pageDTO.getPageSize() >= totalCount)? false : true;
		
	}
	
	
		
	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public PageDTO getPageDTO() {
		return pageDTO;
	}

	

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", pageBlock=" + pageBlock + ", pageDTO=" + pageDTO + "]";
	}
}
