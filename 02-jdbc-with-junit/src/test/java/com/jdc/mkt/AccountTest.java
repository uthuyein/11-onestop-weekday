package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.dto.Account;
import com.jdc.mkt.dto.User;
import com.jdc.mkt.services.AccountInt;
import com.jdc.mkt.services.AccountServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class AccountTest {

	private static AccountInt service;
	
	@BeforeAll
	static void init() throws SQLException {
		service = new AccountServiceImpl();
		service.reset();
	}
	@Test
	@Order(1)
	void insertTest() throws SQLException {
		var acc = new Account();
		acc.setBalance(50000);
		acc.setCreateDate(LocalDateTime.now());
		acc.setUser(new User(1, null, null, null));
		var res = service.save(acc);
		assertEquals(1, res);
	}
	@Test
	@Order(2)
	void updateTest() throws SQLException {
		var res = service.update(30000, LocalDateTime.now());
		assertEquals(1, res);
	}
	@Test
	@Order(3)
	void searchTest() {}
}
