package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.services.projection_join.EmployeeProjectionService;

public class ProjectionTest {

	static EmployeeProjectionService empProjectService;
	
	@BeforeAll
	static void init() {
		empProjectService = new EmployeeProjectionService();
	}
	
	@Test
	void test() {
		var jpql = empProjectService.findEmployeWithJpql();
		System.out.println(jpql);
		
		var criteria = empProjectService.findEmployeWithCriteria();
		System.out.println(criteria);
	}
}
