package com.jdc.mkt.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class D_StreamTerminalTest {

	private List<String> list1 = List.of("9", "10", "4", "5", "4", "", " ", "10", "1", "6", "7", "2", "3", "8");
	private List<String> list2 = List.of("9", "10", "4");

	
	@Test
	void collectTest() {
		var res = list1.stream()
				.filter(e -> !e.isBlank())
				.distinct()
				.map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		System.out.println(res);
	}
	
	//@Test
	void reduceTest() {
		var res = list1.stream()
				.filter(e -> !e.isBlank())
				.mapToInt(i -> Integer.parseInt(i))
				.distinct()
				.sorted()
				.reduce((a, b) -> a + b);
		System.out.println(res);
		
	}

	// @Test
	void resultTest() {
		var opt = list1.stream().parallel().findFirst();
		opt.ifPresentOrElse(a -> System.out.println(a),
				// use given value when there is no value
				() -> System.out.println("Empty"));

		var opt1 = list1.stream().parallel().findAny();
		opt1.ifPresentOrElse(a -> System.out.println(a), () -> System.out.println("Empty"));
	}

	// @Test
	void checkingTest() {
		var res = list2.stream().mapToInt(e -> Integer.parseInt(e))
				// .allMatch(i -> i<= 10 ) //true
				// .anyMatch(i -> i <= 9 ); //true
				.noneMatch(i -> i == 5);

		System.out.println(res);

	}

	// @Test
	void iterateTest() {
		// can't sorted in parallel processing with forEach
		list1.stream()
		.filter(s -> !s.isBlank()).mapToInt(i -> Integer.parseInt(i)).sorted().parallel()
				.forEachOrdered(s -> System.out.println(s));
	}

}
