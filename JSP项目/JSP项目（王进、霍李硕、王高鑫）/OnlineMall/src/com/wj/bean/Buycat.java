package com.wj.bean;
//购物车实体类
public class Buycat {
	private int bid;
	private int uid;
	private int gid;
	private int bnum;
	private String bdate;
	
	public Buycat(){
		
	}
	public Buycat(int bid, int uid, int gid, int bnum, String bdate) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.gid = gid;
		this.bnum = bnum;
		this.bdate = bdate;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
}
