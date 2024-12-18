package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.listeners.EnableTimesListener;

import jakarta.persistence.EntityManager;

public class F_ListenerTest extends JpaEntityManagerFactory{

	private EntityManager em;
	
	@ParameterizedTest
	@CsvSource("4,R7,Beer")
	@Order(2)
	void updateTest(int id,String prod,String cat) {
		
		EnableTimesListener et = new Category();
		et.getTimes();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		var c = em.find(Category.class, id);
		c.setName(cat);
		c.getProducts().get(0).setName(prod);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource("Alcohol,Regel 7,2000")
	@Order(1)
	void insertTest(String cat,String prod,int price) {
		var c = new Category(cat);
		var p = new Product(prod,price);
		c.addProduct(p);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
}
