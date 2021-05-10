package com.example.controller;

import java.util.Date;


import com.example.model.Category;
import com.example.model.User;

public class TeamCommand {
	private String tNum;
	private String tName;
	private String catNum;
	private Date tStart;
	private Date tEnd;
	private String tLimit;
	private String tTerm; 
	private String recruit;
	private String tContent;
	private String price;
	private String uNum;
	
	
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
	public String getCatNum() {
		return catNum;
	}
	public void setCatNum(String catNum) {
		this.catNum = catNum;
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
	public String getuNum() {
		return uNum;
	}
	public void setuNum(String uNum) {
		this.uNum = uNum;
	}
	
	
	
}