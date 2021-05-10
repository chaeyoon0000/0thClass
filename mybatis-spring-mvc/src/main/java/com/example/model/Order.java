package com.example.model;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable{
	private String o_num;
	private String price;
	private String item;
	private String kind;
	private User owner;

	public String getO_num() {
		return o_num;
	}
	public void setO_num(String o_num) {
		this.o_num = o_num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
