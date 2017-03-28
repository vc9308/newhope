package com.codingvictor.newhope.common;

public class Page {
	protected short currPage;
	protected short totalPage;
	protected int rowCount;
	protected byte pageSize;

	public short getCurrPage() {
		return currPage;
	}
	
	public void setCurrPage(short currPage) {
		this.currPage = currPage;
	}
	
	public void setTotalPage(short totalPage) {
		this.totalPage = totalPage;
	}
	
	public short getTotalPage() {
		return totalPage;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	
	public void setRowCount(int rowCount) {
		totalPage = (short) (rowCount / pageSize + 1);
		this.rowCount = rowCount;
	}
	
	public void setPageSize(byte pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}

}
