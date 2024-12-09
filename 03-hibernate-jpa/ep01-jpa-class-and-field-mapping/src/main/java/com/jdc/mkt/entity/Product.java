package com.jdc.mkt.entity;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
@Check(constraints = "dtPrice >= wsPrice")
public class Product {

	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	private double dtPrice;
	private double wsPrice;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	public Size getSize() {
		return size;
	}


	public void setSize(Size size) {
		this.size = size;
	}


	public double getDtPrice() {
		return dtPrice;
	}


	public void setDtPrice(double dtPrice) {
		this.dtPrice = dtPrice;
	}


	public double getWsPrice() {
		return wsPrice;
	}


	public void setWsPrice(double wsPrice) {
		this.wsPrice = wsPrice;
	}
	
	
}
