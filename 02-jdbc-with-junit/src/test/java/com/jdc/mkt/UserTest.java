package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.dto.User;
import com.jdc.mkt.services.UserService;

@TestMethodOrder(OrderAnnotation.class)
public class UserTest {

	private static UserService service;
	
	@BeforeAll
	static void init() {
		service = new UserService();
		
	}
	@Test
	@Order(1)
	void deleteTest() {
		var res = service.delete(1);
		assertEquals(1, res);
	}
	
	@Test
	@Order(2)
	void saveTest() {		
		var res =  service.insert(new User(1,"User", "User", null));
		assertNotNull(res);
		assertTrue(res > 0);
		assertFalse(res < 0);
		assertEquals(1, res);
		assertNotEquals(2, res);
	}
	@Test
	@Order(3)
	void updateTest() {		
		var res = service.update("123", 1);
		assertEquals(1, res);
	}
	
}
