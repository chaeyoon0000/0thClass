package com.example.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Messenger implements Serializable{
	private String mNum;
	private String title;
	private String content;
	private User sender;
	private User receiver;
	private Date date;
	

	public String getmNum() {
		return mNum;
	}
	public void setmNum(String mNum) {
		this.mNum = mNum;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	//	public String getSender() {
//		return sender;
//	}
//	public void setSender(String sender) {
//		this.sender = sender;
//	}
//	public String getReceiver() {
//		return receiver;
//	}
//	public void setReceiver(String receiver) {
//		this.receiver = receiver;
//	}
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
