package com.shop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class CategorySecond implements Serializable {

	private static final long serialVersionUID = 8153856644889800879L;
	private int id;// 主键
	private String name;// 名称
	private Category category;
	private Set<Product> products = new HashSet<Product>();
	
	public CategorySecond() {
		super();
	}
	public CategorySecond(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}