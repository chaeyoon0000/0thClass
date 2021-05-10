package com.example.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class Review implements Serializable {
	private String num;
	private String title;
	private String content;
	private Date writeDate;
	private String rate;
	private String image;
	private String item;
	private User writer;
	private String kind;
	private Category category;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public User getWriter() {
		return writer;
	}
	public void setWriter(User writer) {
		this.writer = writer;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


}
