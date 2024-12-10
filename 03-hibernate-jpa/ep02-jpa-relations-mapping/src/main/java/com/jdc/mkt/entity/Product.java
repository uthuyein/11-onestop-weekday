package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_tbl")
@Check(constraints = "dtPrice >= wsPrice")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	private double dtPrice;
	private double wsPrice;
	
	@Column(nullable = false,columnDefinition = "tinyint(1) default 1")
	private boolean activated;
	
	private LocalDate createDate;
	// onetoone or manytoone 
//	
//	@JoinTable(name = "product_category_tbl",
//	joinColumns = {
//			@JoinColumn(name = "prod_id")
//	},
//	inverseJoinColumns = {
//			@JoinColumn(name = "cat_id")
//	}
//			)
	@ManyToOne
	private Category catgory;
	
	@ManyToMany(mappedBy = "products")
	private List<Voucher> vouchers;
}






