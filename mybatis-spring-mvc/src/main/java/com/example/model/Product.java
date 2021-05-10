package com.example.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {
	private String pNum;
	private String name;
	private String price;
	private Category cate;
	private String content;
	private String image;
	private User seller;
	private String filePath;
	private String isSale;
	
	public Product() { }
	public Product(String pNum, String name, String price, String content, Category cate,//Category category, 
			String image, String filePath, String isSale) {
		this.pNum = pNum;
		this.name = name;
		this.price = price;
		this.content = content;
		this.cate = cate;
		this.image = image;
		this.filePath = filePath;
		this.isSale = isSale;
	}
	
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getIsSale() {
		return isSale;
	}
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}

	
	
	
}
