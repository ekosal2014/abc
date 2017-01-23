package com.product.sale.utils;

import java.io.Serializable;

public class Pagination implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;
	private int perPage;
	private Long totalCount;
	private int totalPage;
	public Pagination() {
		this(1,15,0L,0);
	}

	public Pagination(int currentPage, int perPage, Long totalCount, int totalPage) {
		this.currentPage = currentPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {		
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {		
		this.totalPage = totalPage;
	}

	public int TotalPage(){
		totalPage = (int) Math.ceil((double)this.totalCount/perPage);
		return totalPage;
	}
	
	public int nextPage(){
		return this.currentPage+1;
	}
	
	public int previousPage(){
		return this.currentPage-1;
	}
	
	public Boolean hasNextPage(){
		return this.nextPage() <= this.totalPage ? true : false;
	}
	
	public Boolean hasPreviousPage(){
		return this.previousPage() >= 1 ? true : false; 
	}
	

}
