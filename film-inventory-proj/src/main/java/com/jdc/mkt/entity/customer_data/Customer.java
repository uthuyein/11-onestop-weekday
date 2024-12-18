package com.jdc.mkt.entity.customer_data;

import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_tbl")
public class Customer implements EnableTimesListener {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(nullable = false,columnDefinition = "tinyint(1) default 1")
	private boolean active;
	
	@Embedded
	private Contact contact;
	
	@Embedded
	private Times times;
	
	@ManyToOne
	private Address address;
	
}
