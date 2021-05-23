package com.example.model;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class WishList implements Serializable {

  /* Private Fields */

	private String wNum;
	private String item; //��ǰ ��ȣ
	private String iName;
	private String catTitle;
	private String price;
	private String seller;
	private String isSale;
	private String kind; //�ڷ��� aucion���� ������Ʈ���� ������
	private User owner; //������ ���� ��� 
//	private User member;
	
	private final Map<Integer, Product> pMap = Collections.synchronizedMap(new HashMap<Integer, Product>());
	private final Map<Integer, Auction> aMap = Collections.synchronizedMap(new HashMap<Integer, Auction>());
	private final Map<Integer, Team> tMap = Collections.synchronizedMap(new HashMap<Integer, Team>());

	 public Iterator<Product> getAllProductItems() { return null; }
	 public Iterator<Auction> getAllAuctionItems() { return null; }
	 public Iterator<Team> getAllTeamItems() { return null; }

	public String getwNum() {
		return wNum;
	}
	public void setwNum(String wNum) {
		this.wNum = wNum;
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
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getCatTitle() {
		return catTitle;
	}
	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getIsSale() {
		return isSale;
	}
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}
//	public User getMember() {
//		return member;
//	}
//	public void setMember(User member) {
//		this.member = member;
//	}

		 
	 
	 
	 
	 
	 
	 
	 
	 
}
