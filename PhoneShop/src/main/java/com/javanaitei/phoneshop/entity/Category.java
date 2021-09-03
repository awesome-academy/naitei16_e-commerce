package com.javanaitei.phoneshop.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private Integer id;
	private String name;
	private Category categoryParent;
	private List<Category> categoryChilds;
	private List<Product> products = new ArrayList<>();

	public List<Category> getCategoryChilds() {
		return categoryChilds;
	}

	public void setCategoryChilds(List<Category> categoryChilds) {
		this.categoryChilds = categoryChilds;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}

}
