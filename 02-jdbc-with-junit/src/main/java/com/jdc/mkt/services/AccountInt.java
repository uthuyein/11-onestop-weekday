package com.jdc.mkt.services;

import java.time.LocalDateTime;
import java.util.List;

import com.jdc.mkt.dto.Account;

public interface AccountInt {

	int save(Account acc);
	int update(double balance,LocalDateTime updTime);
	void reset();
	List<Account> search(Account acc);
}
