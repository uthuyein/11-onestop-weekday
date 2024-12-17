package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Person;

import jakarta.persistence.EntityManager;

public class E_CallBackTest extends JpaEntityManagerFactory{

	private EntityManager em;
	
	@ParameterizedTest
	@CsvSource("Andrew")
	@Order(3)
	void removeTest(String name) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		var p = em.find(Person.class, 1);
		em.remove(p);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource("William")
	@Order(2)
	void updateTest(String name) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		var p = em.find(Person.class, 1);
		p.setName(name);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource("Andrew")
	@Order(1)
	void persistTest(String name) {
		em = emf.createEntityManager();
		var p = new Person();
		p.setName(name);
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
}
