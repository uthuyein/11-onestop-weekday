package com.jdc.mkt.services;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactoryService {

	public EntityManagerFactory emf;

	{
		emf = Persistence.createEntityManagerFactory("jpa-query");
	}

}
