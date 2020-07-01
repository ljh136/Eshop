package com.hls.bean;

public class Page {

	private int pagenow=1;//当前页
	private int pagesize=20;//当前页的数据条数
	private int pagenum;//总页数
	private int pagecount;//总条数
	public int getPagenow() {
		return pagenow;
	}
	public void setPagenow(int pagenow) {
		this.pagenow = pagenow;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	
	
}
