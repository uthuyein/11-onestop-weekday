package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.services.DynamicQueryEmployeeService;
import com.jdc.mkt.services.StaticQueryWithEmployeeSerivce;

public class EmployeeTest {

	private static DynamicQueryEmployeeService dynamicQueryService;
	private static StaticQueryWithEmployeeSerivce staticQuerySerivce;
	
	@BeforeAll
	static void init() {
		dynamicQueryService = new DynamicQueryEmployeeService();
		staticQuerySerivce = new StaticQueryWithEmployeeSerivce();
	}
	
	@ParameterizedTest
	@CsvSource(value = {"IT:1","Sales:3","Accountant:2"},delimiter = ':')
	void findCountByDepartmentNameTest(String dep,long res) {
		var jpql = staticQuerySerivce.findCountByDepartmentNameWithJpql(dep);
		assertEquals(res, jpql);
		
		var sql = staticQuerySerivce.findCountByDepartmentNameWithSql(dep);
		assertEquals(res, sql);
	}
	
	@ParameterizedTest
	@CsvSource("A")
	@Disabled
	void findByEmployeeNameLikeTest(String name) {
		var jpql = dynamicQueryService.findByNameLikeWithJpql(name);
		System.out.println(jpql);
		
		var sql = dynamicQueryService.findByNameLikeWithSql(name);
		System.out.println(sql);
		
		var criteria = dynamicQueryService.findByNameLikeWithCriteria(name);
		System.out.println(criteria);
	}
}
