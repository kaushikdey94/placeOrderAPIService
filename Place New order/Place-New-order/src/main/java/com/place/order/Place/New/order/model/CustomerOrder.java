package com.place.order.Place.New.order.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CustomerOrder {
	
	private String ac;
	private String accountId;
	private String action;
	 private Info info; 
	private String status;
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	
	  public Info getInfo() 
	  { 
		  return info; 
		  } 
	  public void setInfo(Info info) 
	  {
	  this.info = info; 
	  }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	

}
