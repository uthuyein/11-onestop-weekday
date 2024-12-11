package com.jdc.mkt.entity;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

//@MappedSuperclass
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entity",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("acc")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false,length = 45)
	private String username;
	
	private String password;
	
	@Check(constraints = 
			"email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'")
	private String email;
	
	@Embedded
	@AttributeOverride(name ="email",column = @Column(name = "p_email"))
	@AttributeOverride(name ="phone",column = @Column(name = "p_phone"))
	private Contact pContact;
	
	@AttributeOverride(name ="email",column = @Column(name = "s_email"))
	@AttributeOverride(name ="phone",column = @Column(name = "s_phone"))
	private Contact sContact;
	
	@ColumnDefault("'STUDENT'")
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	public enum AccountType{
		TEACHER,STUDENT,OFFICE
	}
}
