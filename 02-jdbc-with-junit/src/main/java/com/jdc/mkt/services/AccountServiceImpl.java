package com.jdc.mkt.services;

import java.time.LocalDateTime;
import java.util.List;

import com.jdc.mkt.dto.Account;

public class AccountServiceImpl implements AccountInt{

	@Override
	public int save(Account acc) {
		return 0;
	}

	@Override
	public int update(double balance, LocalDateTime updTime) {
		return 0;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public List<Account> search(Account acc) {
		return null;
	}

}
