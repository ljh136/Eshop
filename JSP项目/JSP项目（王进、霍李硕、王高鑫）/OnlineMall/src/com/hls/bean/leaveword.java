package com.hls.bean;

public class leaveword {

	private int gid;
	private String gname;
	private String gprice;
	private String gpic;
	private String gintroduce;
	private int gtypeid;
	private int gnum;
	private String gdate;
	private int gsales;
	int oid;
	String uname;
	int otype;
	String address;
	String ustel;
	
	
	public leaveword(int gid, String gname, String gpic, String gprice, int gnum, int gtypeid,String gintroduce,
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
	public leaveword(int gid, String gname, String gpic, String gprice, int gnum, int gtypeid,String gintroduce,
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
	public leaveword(int oid,String uname,int gid,
			int otype,int gnum,String address,String ustel) {
		super();
		this.oid = oid;
		this.uname = uname;
		this.gid = gid;
		this.otype = otype;
		this.gnum = gnum;
		this.address = address;
		this.ustel = ustel;
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
		return gsales;
	}
	public void setGsales(int gsales) {
		this.gsales = gsales;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getOtype() {
		return otype;
	}
	public void setOtype(int otype) {
		this.otype = otype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUstel() {
		return ustel;
	}
	public void setUstel(String ustel) {
		this.ustel = ustel;
	}
	
}
