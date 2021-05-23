package com.example.controller.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productList")
public class ProductList {
	
	private List<ProductItem> products;
	
	public ProductList() {
		
	}
	
	public ProductList(List<ProductItem> products) {
		this.products = products;
	}

	public List<ProductItem> getProducts() {
		return products;
	}

	public void setProducts(List<ProductItem> products) {
		this.products = products;
	}

	
}
