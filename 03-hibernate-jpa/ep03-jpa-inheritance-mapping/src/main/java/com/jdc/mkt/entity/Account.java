package com.jdc.mkt.entity;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String username;
	
	private String password;
	
	@Check(constraints = 
			"email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'")
	private String email;
	
	@ColumnDefault("'STUDENT'")
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	public enum AccountType{
		TEACHER,STUDENT,OFFICE
	}
}
