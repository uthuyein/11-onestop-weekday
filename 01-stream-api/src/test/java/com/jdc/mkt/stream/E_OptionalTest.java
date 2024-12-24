package com.jdc.mkt.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class E_OptionalTest {

	private Optional<String> getValue(String str){
		//if use (of) method will can cause NullPointerException 
		//if use (ofNullable) method can be empty but never be exception
		return Optional.ofNullable(str);
	}
	
	@Test
	void retriveTest() {
		
		 assertEquals("hello", getValue("hello").get());
		 
		 getValue("Hello").ifPresent(arg -> assertEquals("Hello", arg));
		 
		 //if present, will use present value or use given value
		 getValue(null).ifPresentOrElse(
				 a -> System.out.println(a),
				 () -> System.out.println("No param"));
		 
		 // if present ,will use present value or else throw given exception
		 assertThrows(NoSuchElementException.class, 
				() -> getValue(null).orElseThrow(
						() -> new NoSuchElementException()));
	}
	
	@Test
	void checkTest() {		
		assertTrue(getValue(null).isEmpty());
		assertTrue(getValue("Hello").isPresent());
	}
	
	class Action{
		static void doAction(String s1,String s2,String s3) {}
		static void doAction(String s1,String s2) {
			doAction(s1,s2,null);
		}
		
		static void doAction(String s1) {
			doAction(s1,null,null);
		}
		
		static void doAction() {
			doAction(null,null,null);
		}
	}
}
