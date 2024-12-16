package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;

import jakarta.persistence.EntityManager;

public class CustomerTest extends JpaEntityManagerFactory {

	EntityManager em;
	
	@Test
	void createTest() {
		em = emf.createEntityManager();
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
		em.persist(address);
		em.persist(customer);
		em.getTransaction().commit();
	}
}
