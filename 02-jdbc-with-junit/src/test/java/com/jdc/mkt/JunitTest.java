package com.jdc.mkt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitTest {

	@BeforeAll
	static void befAll() {
		System.out.println("Before All");
	}
	@AfterAll
	static void aftAll() {
		System.out.println("After All");
	}
	@BeforeEach
	void befEach() {
		System.out.println("Before Each");
	}
	@AfterEach
	void aftEach() {
		System.out.println("After Each");
	}
	@Test
	void testOne() {
		System.out.println("Test One");
	}
	@Test
	void testTwo() {
		System.out.println("Test Two");
	}
}
