package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
