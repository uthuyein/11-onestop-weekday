package com.jdc.mkt.entity;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Check(constraints = "dtPrice >= wsPrice")
@Table(name = "product_tbl")
@Getter 
@Setter
public class Product {

	@Id
	@GeneratedValue(generator = "product_gen_tbl")
	@TableGenerator(name = "product_gen_tbl",initialValue = 1,allocationSize = 1)
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


	
	
	
}
