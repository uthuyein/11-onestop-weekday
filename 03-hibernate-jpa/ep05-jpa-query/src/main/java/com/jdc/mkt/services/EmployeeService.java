package com.jdc.mkt.services;

import java.util.List;

import com.jdc.mkt.entity.Employee;
import com.jdc.mkt.entity.Employee_;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeService {

	private EntityManagerFactory emf;
	
	public EmployeeService() {
		emf = Persistence.createEntityManagerFactory("jpa-query");
	}
	
	public List<Employee> findByNameLikeWithJpql(String name){
		var em = emf.createEntityManager();
		var query = em.createQuery("select e from Employee e where name like :name",Employee.class);
		query.setParameter("name", name.concat("%"));
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByNameLikeWithSql(String name){
		var em = emf.createEntityManager();
		var query = em.createNativeQuery("select * from employee_tbl where name like ?",Employee.class);
		query.setParameter(1, name.concat("%"));
		return query.getResultList();
	}
	
	public List<Employee> findByNameLikeWithCriteria(String name){
		var em = emf.createEntityManager();
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Employee.class);
		
		//select from Employee
		var root = cq.from(Employee.class);
		
		//where name like ?
		var predicate = cb.like(root.get(Employee_.name), name.concat("%"));
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		return query.getResultList();
	}
	
}










