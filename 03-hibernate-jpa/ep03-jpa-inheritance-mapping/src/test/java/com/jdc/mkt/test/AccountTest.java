package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Account;
import com.jdc.mkt.entity.Account.AccountType;
import com.jdc.mkt.entity.Student;
import com.jdc.mkt.entity.Teacher;

import jakarta.persistence.EntityManager;

public class AccountTest extends JpaManagerFactory{

	private EntityManager em;
	
	@BeforeEach
	void createEm() {
		em = emf.createEntityManager();
	}
	
	@Test
	void insertTest() {
		Account acc = new Teacher();
		acc.setUsername("officer");
		acc.setPassword("123");
		acc.setEmail("office@gmail.com");
		acc.setType(AccountType.OFFICE);
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
	}
	
	@AfterEach
	void closeEm() {
		if(null != em && em.isOpen())
			em.close();
	}
}
