package com.jdc.mkt.dto;

import java.time.LocalDateTime;

public class Account {

	private int id;
	private double balance;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private User user;
	
	public Account() {
		super();
	}
	public Account(int id, double balance, LocalDateTime createDate, LocalDateTime updateDate, User user) {
		super();
		this.id = id;
		this.balance = balance;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public User getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
