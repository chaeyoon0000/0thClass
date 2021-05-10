package com.example.model;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Activity implements Serializable{
	private String aNum;
	private String title;
	private String aDate;
	private String aContent;
	private String image;
	private String actAddress;
	private String actDate;
	private User user;
	private Team team;
	
	
	public String getaNum() {
		return aNum;
	}
	public void setaNum(String aNum) {
		this.aNum = aNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getActAddress() {
		return actAddress;
	}
	public void setActAddress(String actAddress) {
		this.actAddress = actAddress;
	}
	public String getActDate() {
		return actDate;
	}
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	
	
}