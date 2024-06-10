package com.kh.forest.product.model.vo;

import java.io.Serializable;

public class E_PageInfo implements Serializable {
	private int currentPage;

	private int listCount;
	private int limit;

	private int endPage;
	
	private int maxPage;
	private int startPage;
	
	public E_PageInfo() {
		
	}


	public E_PageInfo(int currentPage, int listCount, int limit, int endPage, int maxPage, int startPage) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.startPage = startPage;
	}






	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "E_PageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", startPage=" + startPage + ", maxPage=" + maxPage + ", endPage=" + endPage + "]";
	}
	
	
	
}
