package com.example.model;

import java.io.Serializable;
import java.util.Date;

/*
 * 190605 Team 모델 전체 교체 언더바 삭제
 * 
 */

@SuppressWarnings("serial")
public class Team implements Serializable{
	private String tNum;
	private String tName;
	private Category category;
	private Date tStart;
	private Date tEnd;
	private String tLimit;
	private String tTerm; 
	private String recruit;
	private String tContent;
	private String price;
	private String count;
	
	
	
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	private User Mentor;
	
	public String gettNum() {
		return tNum;
	}
	public void settNum(String tNum) {
		this.tNum = tNum;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Date gettStart() {
		return tStart;
	}
	public void settStart(Date tStart) {
		this.tStart = tStart;
	}
	public Date gettEnd() {
		return tEnd;
	}
	public void settEnd(Date tEnd) {
		this.tEnd = tEnd;
	}
	public String gettLimit() {
		return tLimit;
	}
	public void settLimit(String tLimit) {
		this.tLimit = tLimit;
	}
	public String gettTerm() {
		return tTerm;
	}
	public void settTerm(String tTerm) {
		this.tTerm = tTerm;
	}
	public String getRecruit() {
		return recruit;
	}
	public void setRecruit(String recruit) {
		this.recruit = recruit;
	}
	public String gettContent() {
		return tContent;
	}
	public void settContent(String tContent) {
		this.tContent = tContent;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public User getMentor() {
		return Mentor;
	}
	public void setMentor(User mentor) {
		Mentor = mentor;
	}
}

