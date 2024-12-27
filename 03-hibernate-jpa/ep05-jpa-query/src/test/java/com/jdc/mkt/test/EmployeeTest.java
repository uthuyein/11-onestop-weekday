package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.services.EmployeeService;

public class EmployeeTest {

	private static EmployeeService jpqlService;
	
	@BeforeAll
	static void init() {
		jpqlService = new EmployeeService();
	}
	
	@ParameterizedTest
	@CsvSource("A")
	void findByEmployeeNameLikeTest(String name) {
		var jpql = jpqlService.findByNameLikeWithJpql(name);
		System.out.println(jpql);
		
		var sql = jpqlService.findByNameLikeWithSql(name);
		System.out.println(sql);
		
		var criteria = jpqlService.findByNameLikeWithCriteria(name);
		System.out.println(criteria);
	}
}
