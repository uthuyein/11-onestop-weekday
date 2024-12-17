package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;

public class A_CrudOperationTest extends JpaEntityManagerFactory {
	
	@Test
	@Order(4)
	void removeTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		//to be managed state
		var c1 = em.find(Customer.class,1);
		
		//to be removed state
		em.remove(c1);
		em.getTransaction().commit();
	}

	@Test
	@Order(3)
	void updateTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//to be managed state
		var cu = em.find(Customer.class, 1);
		
		//to be detached state
		em.detach(cu);
		em.detach(cu.getAddress());
		cu.setName("wanna");
		cu.getAddress().setCity("yangon");
		
		//to be managed state
		em.merge(cu);
		em.merge(cu.getAddress());
		
		em.getTransaction().commit();
	}
	
	@Test
	@Order(2)
	void findVsGetReferenceTest() {
		var em1 = emf.createEntityManager();
		//to be managed state
		var cu1 = em1.find(Customer.class, 1);
		assertNotNull(cu1);
		em1.clear();
		em1.close();
		show(cu1);
		
		
	
		var em2 = emf.createEntityManager();
		//to be managed state
		var cu2 = em2.getReference(Customer.class, 1);
		assertNotNull(cu2);
		em2.clear();
		em2.close();
		show(cu2);
		
		
		
	}
	
	private void show(Customer c) {
		System.out.printf("\nName :%s\t pEmail :%s\t pPhone :%s\t Street :%s\n",
				c.getName(),
				c.getPrimary().getEmail(),
				c.getPrimary().getPhone(),
				c.getAddress().getStreet()
				);
	}
	
	
	@Test
	@Order(1)
	void createTest() {
		var em = emf.createEntityManager();
		
		//to be transient state
		var address = new Address();
		address.setCity("Mandalay");
		address.setTownship("Patheingyi");
		address.setStreet("19st");
		
		var pri = new Contact();
		pri.setEmail("aung@gmail.com");
		pri.setPhone("098823423");
		
		var sec = new Contact();
		sec.setEmail("aung123@gmail.com");
		sec.setPhone("0923423423");
		
		var customer = new Customer();
		customer.setAddress(address);
		customer.setName("Aung Aung");
		customer.setPrimary(pri);
		customer.setSecondary(sec);
		
		em.getTransaction().begin();
		//managed state
		em.persist(customer);
		em.persist(address);
		
		em.getTransaction().commit();
	}
}
