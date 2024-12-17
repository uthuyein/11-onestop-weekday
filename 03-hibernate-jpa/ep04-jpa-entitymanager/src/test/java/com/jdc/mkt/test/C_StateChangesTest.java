package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class C_StateChangesTest extends JpaEntityManagerFactory{

	private EntityManager em;
	
	@ParameterizedTest
	@Order(3)
	@CsvSource(value = {"Alcohol"})
	void removeTest(String cat) {
		em  = emf.createEntityManager();
		em.getTransaction().begin();
		
		//to be managed state
		var c1 = em.find(Category.class, 1);
		assertTrue(em.contains(c1));
		
		//to be removed state
		em.remove(c1);
		assertFalse(em.contains(c1));
		
		//to be managed state
		em.persist(c1);
		assertTrue(em.contains(c1));
		
		//to be detached state
		em.detach(c1);
		assertFalse(em.contains(c1));
		
		assertThrows(IllegalArgumentException.class, () -> em.remove(c1));
		
		
		em.getTransaction().commit();
	}
	
	@Disabled
	@ParameterizedTest
	@Order(2)
	@CsvSource(value = {"Alcohol"})
	void mergeTest(String cat) {
		em = emf.createEntityManager();
		
		// to be transient state
		var c1 = new Category(cat);
		
		em.getTransaction().begin();
		
		// to be managed state
		var c2 =  em.merge(c1);
		assertFalse(em.contains(c1));
		assertTrue(em.contains(c2));
		
		//to be detached state
		em.detach(c2);
		assertFalse(em.contains(c2));
		
		// to be managed state
		var c3 = em.merge(c2);
		assertTrue(em.contains(c3));
		
		// to be remove state
		em.remove(c3);
		assertFalse(em.contains(c3));
		
		assertThrows(IllegalArgumentException.class, () -> em.merge(c3));
		
		em.getTransaction().commit();
		
	}
	
	@Disabled
	@ParameterizedTest
	@Order(1)
	@CsvSource(value = {"Alcohol,Tiger beer,3000"})
	void persistTest(String cat,String prod,int price) {
		em = emf.createEntityManager();
		
		// to be transient state
		var c = new Category(cat);
		
		//var p = new Product(prod,price);
		//c.addProduct(p);
		
		em.getTransaction().begin();
		
		// to be managed state
		em.persist(c);
		assertTrue(em.contains(c));
		
		// to be detached state
		em.detach(c);
		assertFalse(em.contains(c));
		
		assertThrows(PersistenceException.class, () -> em.persist(c));
		
		//to be managed state
		var newC = em.merge(c);
		assertTrue(em.contains(newC));
		
		//to be remove state
		em.remove(newC);
		assertFalse(em.contains(newC));
		
		// to be manage state
		em.persist(newC);
		assertTrue(em.contains(newC));
		
		em.getTransaction().commit();
		
	}
}
