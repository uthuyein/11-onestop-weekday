package com.jdc.mkt.entity.business_data;

import java.time.LocalDateTime;

import com.jdc.mkt.entity.customer_data.Customer;
import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
@Table(name = "rental_tbl")
public class Rental implements EnableTimesListener {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Embedded
	private Times times;
	
	private LocalDateTime returnTime;
	
	@ManyToOne(optional = false)
	private Customer customer;
}
