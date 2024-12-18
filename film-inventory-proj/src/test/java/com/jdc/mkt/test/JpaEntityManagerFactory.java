package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public class JpaEntityManagerFactory {

	protected static EntityManagerFactory emf;
	
	@BeforeAll
	public static  void init() {
		emf = Persistence.createEntityManagerFactory("film-inventory-proj");
	}
	
	@Test
	void tst() {}
}
