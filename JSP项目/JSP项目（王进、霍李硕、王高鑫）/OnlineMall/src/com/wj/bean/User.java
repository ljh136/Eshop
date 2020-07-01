package com.wj.bean;
//用户实体类
public class User {
	private int uid;
	private String ulogo;
	private String uname;
	private String utel;
	private String upassword;
	private String uemail;
	private String address;
	private String uquestion;
	private String uanswer;
	private String uregtime;
	private String ustel;
	
	public User(){
		
	}
	public User(int uid, String ulogo, String uname, String utel,
			String upassword, String uemail, String address, String uquestion,
			String uanswer, String uregtime, String ustel) {
		super();
		this.uid = uid;
		this.ulogo = ulogo;
		this.uname = uname;
		this.utel = utel;
		this.upassword = upassword;
		this.uemail = uemail;
		this.address = address;
		this.uquestion = uquestion;
		this.uanswer = uanswer;
		this.uregtime = uregtime;
		this.ustel = ustel;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUlogo() {
		return ulogo;
	}
	public void setUlogo(String ulogo) {
		this.ulogo = ulogo;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUquestion() {
		return uquestion;
	}
	public void setUquestion(String uquestion) {
		this.uquestion = uquestion;
	}
	public String getUanswer() {
		return uanswer;
	}
	public void setUanswer(String uanswer) {
		this.uanswer = uanswer;
	}
	public String getUregtime() {
		return uregtime;
	}
	public void setUregtime(String uregtime) {
		this.uregtime = uregtime;
	}
	public String getUstel() {
		return ustel;
	}
	public void setUstel(String ustel) {
		this.ustel = ustel;
	}
}
