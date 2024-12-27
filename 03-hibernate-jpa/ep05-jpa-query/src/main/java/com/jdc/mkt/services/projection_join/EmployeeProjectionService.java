package com.jdc.mkt.services.projection_join;

import java.util.List;

import com.jdc.mkt.entity.Employee;
import com.jdc.mkt.entity.dto.EmployeeDto;
import com.jdc.mkt.services.JpaFactoryService;

public class EmployeeProjectionService extends JpaFactoryService{

	public List<EmployeeDto> findEmployeWithJpql(){
		var em = emf.createEntityManager();
		var query = em.createQuery("""
				select new com.jdc.mkt.entity.dto.EmployeeDto(
				e.name,e.dob,e.department.name)
				from Employee e
				""",EmployeeDto.class);
		return query.getResultList();
	}
	
	public List<EmployeeDto> findEmployeWithCriteria(){
		var em = emf.createEntityManager();
		var cb = em.getCriteriaBuilder();
		
		var cq = cb.createQuery(EmployeeDto.class);
		
		var root = cq.from(Employee.class);
		cq.select(
				cb.construct(
						EmployeeDto.class,
						root.get("name"),
						root.get("dob"),
						root.get("department").get("name")));
		
		var query = em.createQuery(cq);
		
		return query.getResultList();
	}
}
