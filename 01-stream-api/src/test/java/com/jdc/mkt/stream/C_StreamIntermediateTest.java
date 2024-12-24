package com.jdc.mkt.stream;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class C_StreamIntermediateTest {

	private List<String> list1 = List.of("9","10","4","5","4",""," ","10","1","6","7","2","3","8");
	private List<String> list2 = List.of("9","10","4");
	
	@Test
	void testTwo() {
		Stream.of(list1,list2)
		.flatMap(es -> es.stream()) // collection stream to element stream
		.filter(e -> !e.isBlank())
		.map(str -> Integer.parseInt(str))
		//.map(str -> str+",") // generic type return
		.sorted()
		.filter(i -> i%2 == 0)
		.distinct()
		.forEach(e -> System.out.println(e));
	}
	
	//@Test
	void testOne() {
		list1.stream()
		.filter(str -> !str.isBlank()) // to prevent empty or white space
		.distinct() // to remove duplicate element
		.limit(5) // use first 5 elements
		.mapToLong(e -> Integer.parseInt(e)) // to convert type string to int
		.sorted() // order by asc
		.skip(2) // skip first 2 element
		//.filter(i -> i % 3 == 0)
		.forEach(e -> System.out.println(e));
	}
}
