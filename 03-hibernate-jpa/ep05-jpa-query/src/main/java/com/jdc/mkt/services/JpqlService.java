package com.jdc.mkt.services;

import java.util.List;

import com.jdc.mkt.entity.Employee;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpqlService {

	private EntityManagerFactory emf;
	
	public JpqlService() {
		emf = Persistence.createEntityManagerFactory("jpa-query");
	}
	
	public List<Employee> findByNameLike(String name){
		var em = emf.createEntityManager();
		var query = em.createQuery("select e from Employee e where name like :name",Employee.class);
		query.setParameter("name", name.concat("%"));
		return query.getResultList();
	}
	
}










