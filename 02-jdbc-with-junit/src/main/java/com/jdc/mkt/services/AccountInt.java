package com.jdc.mkt.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.mkt.dto.Account;

public interface AccountInt {

	int save(Account acc) throws SQLException;
	int update(double balance,LocalDateTime updTime,int userId,int accId) throws SQLException;
	void reset()  throws SQLException;
	List<Account> search(Account acc) throws SQLException;
}
