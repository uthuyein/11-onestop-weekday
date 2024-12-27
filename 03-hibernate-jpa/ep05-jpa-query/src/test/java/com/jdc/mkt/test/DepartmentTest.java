package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.services.projection_join.DepartmentJoinService;

public class DepartmentTest {

	private static DepartmentJoinService empService;
	
	@BeforeAll
	static void init() {
		empService = new DepartmentJoinService();
	}
	
	@ParameterizedTest
	@CsvSource("Andrew")
	void findDepartmentByEmpNameTest(String name) {
		var jpql = empService.findDepartmentByEmpNameWithJpql(name);
		System.out.println(jpql);
		
		var criteria = empService.findDepartmentByEmpNameWithCriteria(name);
		System.out.println(criteria);
	}
}
