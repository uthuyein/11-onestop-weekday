package com.jdc.mkt.services;

public class StaticQueryWithEmployeeSerivce extends JpaFactoryService{

	public long findCountByDepartmentNameWithJpql(String name) {
		var em = emf.createEntityManager();
		var query = em.createNamedQuery("findCountByDepartmentName",Long.class);
		query.setParameter("department", name);
		return query.getSingleResult();
	}
	
	public long findCountByDepartmentNameWithSql(String name) {
		var em = emf.createEntityManager();
		var query = em.createNamedQuery("findCountByDepartmentNameSql",Long.class);
		query.setParameter(1, name);
		return query.getSingleResult();
	}
}
