package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ExcludeDefaultListeners
public class Customer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String name;
	
	@AttributeOverride(name = "phone",column = @Column(name ="pPhone"))
	@AttributeOverride(name = "email",column = @Column(name ="pEmail"))
	private Contact primary;
	
	@AttributeOverride(name = "phone",column = @Column(name ="sPhone"))
	@AttributeOverride(name = "email",column = @Column(name ="sEmail"))
	private Contact secondary;
	
	@OneToOne
	private Address address;
	
	@ElementCollection
	@CollectionTable(name = "cu_describe")
	private List<String> descriptions;
	
	public Customer() {
		super();
		descriptions = new ArrayList<String>( List.of("testOne","testTwo","testThree"));
		
	}
}
