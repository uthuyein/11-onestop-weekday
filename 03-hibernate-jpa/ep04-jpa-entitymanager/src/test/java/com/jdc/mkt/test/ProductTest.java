package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class ProductTest extends JpaEntityManagerFactory{

	@Test
	@Order(1)
	void insertProductAndCategoryTest() {
		var mango = new Product("Mango",2000);
		var orange = new Product("Orange",2500);
		var c = new Category("Fruits");
		c.addProduct(mango);
		c.addProduct(orange);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.persist(mango);
		em.persist(orange);
		em.getTransaction().commit();
	}
}
