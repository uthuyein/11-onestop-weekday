package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class OrderDetailPk implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "order_id")	
	private int orderId;
	
	@Column(name = "payment_id")	
	private int paymentId;
}
