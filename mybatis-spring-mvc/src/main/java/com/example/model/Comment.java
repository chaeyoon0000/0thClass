package com.example.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("serial")
public class Comment implements Serializable{
   private String cNum;
   private String uNum;
   private String rNum;
   private String content;
   private Date cDate;
   
  
   public String getuNum() {
	return uNum;
}
public void setuNum(String uNum) {
	this.uNum = uNum;
}

   public String getrNum() {
	return rNum;
}
public void setrNum(String rNum) {
	this.rNum = rNum;
}
public String getContent() {
	   return content;
   }
   public void setContent(String content) {
	   this.content = content;
   }
public String getcNum() {
	return cNum;
}
public void setcNum(String cNum) {
	this.cNum = cNum;
}
public String getcDate() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	return sdf.format(cDate);
}
public void setcDate(Date cDate) {
	
	this.cDate = cDate;
}

  
}
   
