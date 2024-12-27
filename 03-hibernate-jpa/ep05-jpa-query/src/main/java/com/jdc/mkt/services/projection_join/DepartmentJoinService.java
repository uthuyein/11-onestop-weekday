package com.jdc.mkt.services.projection_join;

import java.util.List;

import com.jdc.mkt.entity.Department;
import com.jdc.mkt.services.JpaFactoryService;

public class DepartmentJoinService extends JpaFactoryService{

	 public List<Department> findDepartmentByEmpNameWithCriteria(String name){
		 var em = emf.createEntityManager();
		 var cb = em.getCriteriaBuilder();
		 var cq = cb.createQuery(Department.class);
		 
		 var root = cq.from(Department.class);
		 var join = root.join("employees");
		 
		 var predicate = cb.equal(join.get("name"), name);
		 cq.where(predicate);
		 
		 var query = em.createQuery(cq);
		 
		 return query.getResultList();
	 }
	 
	 public List<Department> findDepartmentByEmpNameWithJpql(String name) {
		 var em = emf.createEntityManager();
		 var query = em.createQuery("""
		 		select d from Department d
		 		join d.employees e
		 		where e.name = :emp
		 		""",Department.class);
		 
		 query.setParameter("emp", name);
		 
		 return query.getResultList();
	 }
	 
	
}
