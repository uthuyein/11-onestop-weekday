package com.jdc.mkt.stream;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class A_BeforeAndAfterStreamTest {

	private List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
	
	@Test
	@Order(2)
	void withStreamTest() {
		System.out.println(
				"With stream result :"
				+list.stream().mapToInt(e ->e).sum()
				);
	}
	
	@Test
	@Order(1)
	void withoutStreamTest() {
		var itr = list.iterator();
		var result = 0;
		while(itr.hasNext()) {
			result += itr.next();
		}
		System.out.println("Without stream result : "+result);
	}
}
