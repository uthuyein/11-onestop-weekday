package com.jdc.mkt.dto;

import java.time.LocalDateTime;

public class User {

	private int id;
	private String username;
	private String password;
	private LocalDateTime createDate;
	
	public User() {
		super();
	}

	public User(String username, String password, LocalDateTime createDate) {
		super();
		this.username = username;
		this.password = password;
		this.createDate = createDate;
	}

	public User(int id, String username, String password, LocalDateTime createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	
	
}
