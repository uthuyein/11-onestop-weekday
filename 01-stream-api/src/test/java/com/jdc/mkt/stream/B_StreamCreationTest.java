package com.jdc.mkt.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class B_StreamCreationTest {
	
	
	
	@Test
	void createGenerateAndIterateTest() {
		int i = 3; //effecitvely final cause of use in lambda
		System.out.println( DoubleStream.generate(() -> i).limit(10).sum());
		System.out.println(DoubleStream.iterate(1, arg -> arg).limit(10).sum());		
	}
	
	
	
	
	@Test
	void createFromRangeAndRangeClosedTest() {
		//IntStream
		System.out.println( IntStream.range(1, 10).sum());
		System.out.println( IntStream.rangeClosed(1, 10).sum());
		
		//LongStream
		System.out.println( LongStream.range(1, 10).sum());
		
		//Double Stream
		System.out.println(DoubleStream.of(1.1,1.2,1.3,1.4).sum());
	
	}

	@Test
	void createFromArrayAndCollectionTest() {
		int[] array = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.stream(array).sum());
		
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
		System.out.println(list.stream().mapToInt(e -> e).sum());
	}
}
