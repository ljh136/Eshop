package com.wgx.bean;
public class goods {
private int gid;
private String gname;
private String gprice;
private String gpic;
private String gintroduce;
private int gtypeid;
private int gnum;
private String gdate;
private int gsales;

public goods(int gid, String gname, String gpic, String gprice, int gnum, int gtypeid,String gintroduce,
		String gdate, int gsales) {
	super();
	this.gid = gid;
	this.gname = gname;
	this.gpic = gpic;
	this.gprice = gprice;
	this.gnum = gnum;
	this.gtypeid = gtypeid;
	this.gintroduce = gintroduce;
	this.gdate = gdate;
	this.gsales = gsales;
}
public goods(int gid, String gname, String gpic, String gprice, int gnum, int gtypeid,String gintroduce,
		String gdate) {
	super();
	this.gid = gid;
	this.gname = gname;
	this.gpic = gpic;
	this.gprice = gprice;
	this.gnum = gnum;
	this.gtypeid = gtypeid;
	this.gintroduce = gintroduce;
	this.gdate = gdate;
	
}

public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public String getGprice() {
	return gprice;
}
public void setGprice(String gprice) {
	this.gprice = gprice;
}
public String getGpic() {
	return gpic;
}
public void setGpic(String gpic) {
	this.gpic = gpic;
}
public String getGintroduce() {
	return gintroduce;
}
public void setGintroduce(String gintroduce) {
	this.gintroduce = gintroduce;
}
public int getGtypeid() {
	return gtypeid;
}
public void setGtypeid(int gtypeid) {
	this.gtypeid = gtypeid;
}
public int getGnum() {
	return gnum;
}
public void setGnum(int gnum) {
	this.gnum = gnum;
}
public String getGdate() {
	return gdate;
}
public void setGdate(String gdate) {
	this.gdate = gdate;
}
public int getGsales() {
	return gid;
}
public void setGsales(int gsales) {
	this.gsales = gsales;
}

}
