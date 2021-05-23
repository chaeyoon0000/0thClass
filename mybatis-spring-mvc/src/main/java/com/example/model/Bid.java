package com.example.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Bid implements Serializable{
	
	private String bNum;
	private String price;
	private Auction auc;
	private User participant;
	private Date bidDate;
	
	public Date getBidDate() {
		return bidDate;
	}
	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}
	public String getbNum() {
		return bNum;
	}
	public void setbNum(String bNum) {
		this.bNum = bNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Auction getAuc() {
		return auc;
	}
	public void setAuc(Auction auc) {
		this.auc = auc;
	}
	public User getParticipant() {
		return participant;
	}
	public void setParticipant(User participant) {
		this.participant = participant;
	}
}