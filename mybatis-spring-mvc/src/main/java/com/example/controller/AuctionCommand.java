package com.example.controller;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Auction;

public class AuctionCommand {
	private String aNum;
	private String name;
	private String catNum; //category
	private String low;
	private String high;
	private String content;
	private Date startAuc;
	private Date endAuc;
	private String state;
	private String uNum;
	private MultipartFile image;
	private MultipartFile filePath;
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
	public String getCatNum() {
		return catNum;
	}
	public void setCatNum(String catNum) {
		this.catNum = catNum;
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
	public String getuNum() {
		return uNum;
	}
	public void setuNum(String uNum) {
		this.uNum = uNum;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public MultipartFile getFilePath() {
		return filePath;
	}
	public void setFilePath(MultipartFile filePath) {
		this.filePath = filePath;
	}
}
