package com.jdc.mkt.entity.inventory_data;

import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "actor_tbl")
public class Actor implements EnableTimesListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Embedded
	private Times times;
	
}
