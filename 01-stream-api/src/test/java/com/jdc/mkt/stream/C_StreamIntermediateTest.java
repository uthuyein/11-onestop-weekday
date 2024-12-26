package com.jdc.mkt.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class C_StreamIntermediateTest {

	private List<String> list1 = List.of("9","10","4","5","4",""," ","10","1","6","7","2","3","8");
	private List<String> list2 = List.of("3","9","10","4");
	
	interface MyInter{
		void show(int a);
	}
	
	interface UniInter{
		int apply(int a);
		
		default UniInter compose(UniInter inter) {
			return a -> apply(inter.apply(a));
		}
	}
	
	static void doSome(int a) {
		System.out.println("Do Some : "+a);
	}
	
	MyInter useInter() {
		return a -> System.out.println("");
	}
	
	@Test
	void test() {
//		MyInter i = a -> System.out.println("Lambda :" +a );
//		i.show(20);
//		MyInter i2 = C_StreamIntermediateTest:: doSome;
//		i2.show(20);
		
		UniInter one = a -> a * 5;
		UniInter two = a -> one.compose(x -> x+1 ).apply(a);
		System.out.println(two.apply(0));
	}
	
	//@Test
	void dropWhileTest() {
		//it should use in sequential and sorted
		// prevent while element is true for a time;
		list2.stream()
		.map(e -> Integer.parseInt(e))
		.sorted()
		.dropWhile(i -> (i %2 ) == 0)
		.forEach(i -> System.out.println("Use DropWhile :"+i));
	}
	//@Test
	void takeWhileTest() {
		list2.stream()
		.map(e -> Integer.parseInt(e))
		.takeWhile(i -> i <= 4)
		.forEach(i -> System.out.println("Use TakeWhile :"+i));
	}
	//@Test
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
