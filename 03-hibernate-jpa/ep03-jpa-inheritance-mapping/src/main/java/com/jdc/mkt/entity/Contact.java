package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email;
	private String phone;
	
	
}
