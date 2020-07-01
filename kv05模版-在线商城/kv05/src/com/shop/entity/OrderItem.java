package com.shop.entity;

import java.io.Serializable;

import com.shop.util.NumberUtil;

public class OrderItem implements Serializable{

	private static final long serialVersionUID = 7669951336610808614L;
	private int id;
	private int pid;// 
	private String title;// 
	private String img;// 
	private double price;// 
	private int count;
	private Order order;
	
	public OrderItem() {
		super();
	}
	public OrderItem(int count, Product product) {
		super();
		this.count = count;
		this.title = product.getTitle();
		this.img = product.getImg();
		this.price = product.getPriceShop();
		this.pid = product.getId();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return NumberUtil.format(price);
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}