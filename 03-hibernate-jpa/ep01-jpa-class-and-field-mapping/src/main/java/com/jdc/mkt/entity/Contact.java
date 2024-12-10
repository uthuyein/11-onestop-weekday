package com.jdc.mkt.entity;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_tbl")
@SecondaryTable(name = "address_tbl")
@SecondaryTable(name = "webAddress_tbl")
public class Contact {

	@Id
	private int id;
	@Column(nullable = false,length = 45,table = "address_tbl")
	private String street;
	
	@Column(nullable = false,length = 45,table = "address_tbl")
	private String township;
	
	@Column(nullable = false,length = 45,table = "address_tbl")
	private String city;
	
	@Column(nullable = false,length = 12,unique = true)
	private String primaryContact;
	
	//@Check(constraints = "char_length(secondaryContact) <= 12")
	@Column(length = 12,unique = true,columnDefinition = "varchar(12) check (char_length(secondaryContact) <= 12)")
	private String secondaryContact;
	
	@Check(constraints = "email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'")
	@Column(nullable = false,length = 45,table = "webAddress_tbl")
	private String email;
	
	@Column(nullable = false,length = 45,table = "webAddress_tbl")
	private String webLinkAddress;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getTownship() {
		return township;
	}


	public void setTownship(String township) {
		this.township = township;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPrimaryContact() {
		return primaryContact;
	}


	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}


	public String getSecondaryContact() {
		return secondaryContact;
	}


	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWebLinkAddress() {
		return webLinkAddress;
	}


	public void setWebLinkAddress(String webLinkAddress) {
		this.webLinkAddress = webLinkAddress;
	}
	
	
	
}
