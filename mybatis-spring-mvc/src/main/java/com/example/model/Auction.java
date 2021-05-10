package com.example.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class Auction implements Serializable{
	
	private String aNum;
	private String name;
	private Category category;
	private String low;
	private String high;
	private String content;
	private Date startAuc;
	private Date endAuc;
	private String state;
	private User Seller;
	private String image;
	private String filePath;
	
	public String getaNum() {
		return aNum;
	}
	public void setaNum(String aNum) {
		this.aNum = aNum;
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
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartAuc() {
		return startAuc;
	}
	public void setStartAuc(Date startAuc) {
		this.startAuc = startAuc;
	}
	public Date getEndAuc() {
		return endAuc;
	}
	public void setEndAuc(Date endAuc) {
		this.endAuc = endAuc;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getSeller() {
		return Seller;
	}
	public void setSeller(User Seller) {
		this.Seller = Seller;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}