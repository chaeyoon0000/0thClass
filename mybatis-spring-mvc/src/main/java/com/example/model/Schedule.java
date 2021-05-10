package com.example.model;

import java.io.Serializable;

/*
 * 190607 스케줄 모델 수정
 * 
 * 
 */

@SuppressWarnings("serial")
public class Schedule implements Serializable{
	private String sNum;
	private String title;
	private String schWrite;
	private String schDate;
	private String schAddr;
	private String schContent;
	private User mentor;
	private Team team;
	
	
	
	public String getsNum() {
		return sNum;
	}
	public void setsNum(String sNum) {
		this.sNum = sNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSchWrite() {
		return schWrite;
	}
	public void setSchWrite(String schWrite) {
		this.schWrite = schWrite;
	}
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
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
	public User getMentor() {
		return mentor;
	}
	public void setMentor(User mentor) {
		this.mentor = mentor;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	
	
	
	
	
}