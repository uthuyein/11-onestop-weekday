package com.jdc.mkt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale_details_tbl")
@IdClass(SaleDetailsPk.class)
public class SaleDetails {

//	@EmbeddedId
//	private SaleDetailsPk id;
	
	@Id
	private int productId;
	@Id
	private int accountId;
	@Id
	private LocalDate saleDate;
	private int qty;
	
}
