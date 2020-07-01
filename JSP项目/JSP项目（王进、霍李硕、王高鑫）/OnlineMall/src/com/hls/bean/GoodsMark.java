package com.hls.bean;

public class GoodsMark {

	private int mid;
	private int gid;
	private int uid;
	private String gmark;
	private String gdate;
	private int uname;
	
	public GoodsMark(){
		
	}
	public GoodsMark(int mid, int gid, int uid, String gmark, String gdate) {
		super();
		this.mid = mid;
		this.gid = gid;
		this.uid = uid;
		this.gmark = gmark;
		this.gdate = gdate;
	}
	public GoodsMark(int uname, int mid ,int gid, int uid, String gmark, String gdate) {
		super();
		this.uname = uname;
		this.mid = mid;
		this.gid = gid;
		this.uid = uid;
		this.gmark = gmark;
		this.gdate = gdate;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getGmark() {
		return gmark;
	}
	public void setGmark(String gmark) {
		this.gmark = gmark;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
}
