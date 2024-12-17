package com.jdc.mkt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	@PrePersist
	public void beforeInsert() {
		System.out.println("Before presist person");
	}
	@PostPersist
	public void afterInsert() {
		System.out.println("After persist person");
	}
	
	@PreUpdate
	public void beforeUpdate() {
		System.out.println("Before merge person");
	}	
	@PostUpdate
	public void afterUpdate() {
		System.out.println("After merge person");
	}
	
	@PreRemove
	public void beforeRemove() {
		System.out.println("Before remove person");
	}
	@PostRemove
	public void afterRemvoe() {
		System.out.println("After remove person");
	}
}
