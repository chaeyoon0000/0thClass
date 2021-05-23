package com.example.controller;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Team;
import com.example.model.User;

public class ActivityCommand {
	private String title;
	private String aContent;
	private MultipartFile image;
	private String actAddress;
	private Date actDate;
	private String uNum;
	private String tNum;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	public String getActAddress() {
		return actAddress;
	}
	public void setActAddress(String actAddress) {
		this.actAddress = actAddress;
	}
	public Date getActDate() {
		return actDate;
	}
	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}
	public String getuNum() {
		return uNum;
	}
	public void setuNum(String uNum) {
		this.uNum = uNum;
	}
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	
	
	
	
}