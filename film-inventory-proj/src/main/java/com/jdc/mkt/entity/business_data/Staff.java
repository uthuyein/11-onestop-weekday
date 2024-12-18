package com.jdc.mkt.entity.business_data;

import com.jdc.mkt.entity.customer_data.Address;
import com.jdc.mkt.entity.customer_data.Contact;
import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "staff_tbl")
public class Staff implements EnableTimesListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(nullable = false,length = 45)
	private String loginId;
	
	@Column(nullable = false,length = 45)
	private String password;
	
	@Embedded
	private Contact contact;
	
	@Embedded
	private Times times;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	private Address address;
}
