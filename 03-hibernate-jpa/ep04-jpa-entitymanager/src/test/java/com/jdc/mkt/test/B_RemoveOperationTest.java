package com.jdc.mkt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class B_RemoveOperationTest extends JpaEntityManagerFactory{

	
	@Test
	@Order(3)
	void removeCategoryTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var c = em.find(Category.class, 1);
		c.removeProduct(0);
		//em.remove(c);
		em.getTransaction().commit();
	}
	
	//@Test
	@Order(2)
	void removeProductTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var p = em.find(Product.class, 1);
		em.remove(p);
		em.getTransaction().commit();
	}
	
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
		//em.persist(mango);
		//em.persist(orange);
		em.getTransaction().commit();
	}
}
