package com.jdc.mkt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String user;
	private String password;
}
