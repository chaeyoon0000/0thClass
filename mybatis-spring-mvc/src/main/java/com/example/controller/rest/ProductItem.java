package com.example.controller.rest;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.example.model.Category;

import javax.xml.bind.annotation.XmlAccessType;

public class ProductItem {
	private String pNum;
	private String name;
	private String price;
	private Category cate;
//	private String content;
	private String image;
//	private User seller;
//	private String filePath;
	private String isSale;
	
//	public ProductRest() { }
//	public Product(String pNum, String name, String price, String content, Category cate,//Category category, 
//			//String catTitle,
//			String image, String filePath, String isSale) {
//		this.pNum = pNum;
//		this.name = name;
//		this.price = price;
//		this.content = content;
////		this.catTitle = catTitle;
////		this.category = category;
//		this.cate = cate;
//		this.image = image;
//		this.filePath = filePath;
//		this.isSale = isSale;
//	}
	
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
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getCatTitle() {
//		return catTitle;
//	}
//	public void setCatTitle(String catTitle) {
//		this.catTitle = catTitle;
//	}
//	public Category getCategory() {
//		return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
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
//	public User getSeller() {
//		return seller;
//	}
//	public void setSeller(User seller) {
//		this.seller = seller;
//	}
//	public String getSeller() {
//		return seller;
//	}
//	public void setSeller(String seller) {
//		this.seller = seller;
//	}
	
//	
//	public String getFilePath() {
//		return filePath;
//	}
//	
//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//	}
	public String getIsSale() {
		return isSale;
	}
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}
	@Override
	public String toString() {
		return "ProductRest [pNum=" + pNum + ", name=" + name + ", price=" + price + ", cate=" + cate + 
				", image=" + image + ", isSale=" + isSale + "]";
	}

	
}
