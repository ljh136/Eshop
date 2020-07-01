package com.wgx.bean;

public class Order {
	private int oid;
	private int uid;
	private int gid;
	private int otype;
	private int bnum;
	private String bdate;
	
	public Order(){
		
	}
	
	public Order(int oid, int uid, int gid, int otype, int bnum, String bdate) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.gid = gid;
		this.otype = otype;
		this.bnum = bnum;
		this.bdate = bdate;
	}
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
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
	public int getOtype() {
		return otype;
	}
	public void setOtype(int otype) {
		this.otype = otype;
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
