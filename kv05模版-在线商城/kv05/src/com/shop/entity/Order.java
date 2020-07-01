package com.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.shop.util.NumberUtil;


public class Order implements Serializable{

	private static final long serialVersionUID = -9120227898369604858L;
	private int id;
	private String num;// 
	private String name;// 
	private String phone;// 
	private String address;// 
	private double price;// 
	private int uid;//
	private String type;//
	private Date createDate;// 
	private Set<OrderItem> items = new HashSet<OrderItem>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Set<OrderItem> getItems() {
		return items;
	}
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	public double getPrice() {
		return NumberUtil.format(price);
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
