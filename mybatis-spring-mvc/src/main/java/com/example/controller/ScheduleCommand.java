package com.example.controller;

import java.util.Date;

import com.example.model.Team;
import com.example.model.User;

public class ScheduleCommand {
	private String title;
//	private String schWrite;
	private Date schDate;
	
//	private String schDate;
	
	private String schAddr;
	private String schContent;
	private String uNum;
	private String tNum;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public String getSchWrite() {
//		return schWrite;
//	}
//	public void setSchWrite(String schWrite) {
//		this.schWrite = schWrite;
//	}
//	public String getSchDate() {
//		return schDate;
//	}
//	public void setSchDate(String schDate) {
//		this.schDate = schDate;
//	}
	
	public Date getSchDate() {
		return schDate;
	}
	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}
	
	public String getSchAddr() {
		return schAddr;
	}
	public void setSchAddr(String schAddr) {
		this.schAddr = schAddr;
	}
	public String getSchContent() {
		return schContent;
	}
	public void setSchContent(String schContent) {
		this.schContent = schContent;
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