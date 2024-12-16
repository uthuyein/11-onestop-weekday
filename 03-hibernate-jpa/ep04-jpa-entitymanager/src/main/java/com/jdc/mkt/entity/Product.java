package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false,length = 45)
	private String name;
	
	@NonNull
	private Integer price;
	
	@ColumnDefault("1")
	private boolean isActivated;
	
	@ManyToOne
	private Category category;
}
