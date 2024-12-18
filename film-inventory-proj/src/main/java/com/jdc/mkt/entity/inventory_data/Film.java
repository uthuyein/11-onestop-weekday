package com.jdc.mkt.entity.inventory_data;

import com.jdc.mkt.entity.listeners.EnableTimesListener;
import com.jdc.mkt.entity.listeners.Times;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "film_tbl")
public class Film implements EnableTimesListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	private String description;
	
	private int length;
	
	@Enumerated(EnumType.STRING)
	private Rate rating;
	
	@Column(columnDefinition = "set('test1','test2','test3')")
	private String filmType;
	
	@Embedded
	private Times times;
	
	public enum Rate{
		One,Two,Three,Four,Five;
	}
	
	
}
