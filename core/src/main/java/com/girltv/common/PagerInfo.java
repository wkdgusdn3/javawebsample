/*
 * @(#)PagerInfo.java $version 2014. 7. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.girltv.common;

/**
 * @author JOHN KIM
 */
public class PagerInfo {
	/**
	 * 전체 데이터 수.
	 */
	private int totalRows = -1;

	/**
	 * 한 페이지에 보여질 데이터 수.
	 */
	private int pageSize = 0;

	/**
	 * 페이지 이동을 위한 색인 수.
	 */
	private int indexSize = 0;

	/**
	 * 현재 페이지 번호.
	 */
	private int page = 1;

	private int prevPage;

	private int nextPage;

	private int firstPage;

	private int lastPage;

	private int totalPages;

	public void init(int page, int totalRows, int indexSize, int pageSize) {
		this.page = page;
		this.totalRows = totalRows;
		this.indexSize = indexSize;
		this.pageSize = pageSize;

		int lastPage = getLastPage();
		if (this.page > lastPage) {
			this.page = lastPage;
		}
	}

	/**
	 * 현재 page번호
	 * @param page 현재 페이지 번호
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 전체 데이터 수를 반환한다.
	 * 
	 * @return the total rows
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * 전체 데이터 수를 설정한다.
	 * 
	 * @param totalRows the total rows
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	/**
	 * 페이지 이동을 위한 색인 수를 반환한다.
	 * 
	 * @return the index size
	 */
	public int getIndexSize() {
		return indexSize;
	}

	/**
	 * 페이지 이동을 위한 색인 수를 설정한다.
	 * 
	 * @param indexSize the index size
	 */
	public void setIndexSize(int indexSize) {
		this.indexSize = indexSize;
	}

	/**
	 * 한 페이지에 보일 데이터 수를 반환한다.
	 * 
	 * @return the page size
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 한 페이지에 보일 데이터 수를 설정한다.
	 * 
	 * @param pageSize the page size
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 전체 페이지 수를 반환한다.
	 * 
	 * @return the total pages
	 */
	public int getTotalPages() {
		return (totalRows - 1) / pageSize + 1;
	}

	/**
	 * 현재 페이지를 반환한다.
	 * 마지막 LastPage번호보다 Page번호가 클 경우 LastPage번호를 반환한다.
	 * @return the page
	 */
	public int getPage() {
		int lastPage = getLastPage();
		if (page > lastPage) {
			return lastPage;
		}

		return page;
	}

	/**
	 * 첫 페이지 색인을 반환한다.
	 * 
	 * @return the first page
	 */
	public int getFirstPage() {
		return ((page - 1) / indexSize) * indexSize + 1;
	}

	/**
	 * 마지막 페이지 색인을 반환한다.
	 * 
	 * @return the last page
	 */
	public int getLastPage() {
		return Math.min(getFirstPage() + indexSize - 1, getTotalPages());
	}

	/**
	 * 이전 페이지 색인을 반환한다.
	 * 
	 * @return the prev page
	 */
	public int getPrevPage() {
		return (page > 1 ? page - 1 : 0);
	}

	/**
	 * 다음 페이지 색인을 반환한다.
	 * 
	 * @return the next page
	 */
	public int getNextPage() {
		return (page < getTotalPages() ? page + 1 : 0);
	}

	/**
	 * 현재 페이지의 offset을 계산한다
	 * 
	 * @return the offset rownum
	 */
	public int getOffsetRow() {
		return pageSize * (page - 1);
	}

	/**
	 * 이전 버튼이 있는지 확인
	 * @return
	 */
	public boolean hasPrevButton() {
		return (getPrevPage() == 0 ? false : true);
	}

	/**
	 * 다음 버튼이 있는지 확인
	 * @return
	 */
	public boolean hasNextButton() {
		return (getNextPage() == 0 ? false : true);
	}

}
