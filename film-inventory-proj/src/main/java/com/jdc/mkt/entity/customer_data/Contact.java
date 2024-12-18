package com.jdc.mkt.entity.customer_data;

import java.io.Serializable;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;

	@Check(constraints = "email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'")
	@Column(nullable = false)
	private String email;
	
	@Column(length = 12,nullable = false)
	private String phone;
}
