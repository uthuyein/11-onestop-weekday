package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/transactionDb";
	private static final String USER = "transactionUser";
	private static final String PASSWORD = "transactionPass";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
