package com.jdc.mkt.entity.business_data;

import com.jdc.mkt.entity.customer_data.Address;
import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Store implements EnableTimesListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Embedded
	private Times times;
	
	@ManyToOne
	private Staff staff;
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	private Address address;
}
