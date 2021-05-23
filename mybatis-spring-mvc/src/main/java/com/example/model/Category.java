package com.example.model;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable{
	private String catNum;
	private String catTitle;
	public String getCatNum() {
		return catNum;
	}
	public void setCatNum(String catNum) {
		this.catNum = catNum;
	}
	public String getCatTitle() {
		return catTitle;
	}
	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}
	
	
}
