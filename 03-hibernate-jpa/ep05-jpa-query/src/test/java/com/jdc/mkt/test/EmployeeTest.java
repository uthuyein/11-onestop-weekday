package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.services.JpqlService;

public class EmployeeTest {

	private static JpqlService jpqlService;
	
	@BeforeAll
	static void init() {
		jpqlService = new JpqlService();
	}
	
	@ParameterizedTest
	@CsvSource("A")
	void findByEmployeeNameLikeTest(String name) {
		var list = jpqlService.findByNameLike(name);
		System.out.println(list);
	}
}
