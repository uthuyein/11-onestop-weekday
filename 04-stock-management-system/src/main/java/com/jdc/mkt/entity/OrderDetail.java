package com.jdc.mkt.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_detail_tbl")
public class OrderDetail {

	@EmbeddedId
	private OrderDetailPk id;
	private double unitPrice;
	private int qty;
	private int discount;
	
	@MapsId("productId")
	@ManyToOne
	//@JoinColumn(insertable = false,updatable = false)
	private Product product;
	@MapsId("orderId")
	@ManyToOne
	//@JoinColumn(insertable = false,updatable = false)
	private Order order;
	@MapsId("paymentId")
	@ManyToOne
	//@JoinColumn(insertable = false,updatable = false)
	private Payment payment;
}
