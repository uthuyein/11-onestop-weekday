package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true,length = 45)
	private String name;
	@Column(columnDefinition = "tinyint(1) not null default 1")
	private boolean activated;
	private LocalDate createDate;
	
	// it will create foreign key on product_tbl table
	//@JoinColumn(name = "cat_id")
	@OneToMany(mappedBy = "catgory")
	private List<Product> products;
}






