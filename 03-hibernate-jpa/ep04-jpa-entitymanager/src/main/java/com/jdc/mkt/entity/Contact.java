package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column( length = 12)
	private String phone;
	private String email;
}
