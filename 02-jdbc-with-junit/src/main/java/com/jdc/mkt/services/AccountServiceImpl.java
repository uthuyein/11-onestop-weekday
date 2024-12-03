package com.jdc.mkt.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.Account;
import com.jdc.mkt.dto.User;

import static com.jdc.mkt.utils.DbConnection.getConnection;

public class AccountServiceImpl implements AccountInt{

	private Connection con;
	private PreparedStatement stmt;
	
	public PreparedStatement execution(String sql,Object[]array) {
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			if(null != array)
			for(int i = 0 ; i < array.length ; i ++) {
				stmt.setObject(i+1, array[i]);
			}		
			return stmt;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeConnection() throws SQLException {
		if(null != con && !con.isClosed())
			con.close();
	}
	
	@Override
	public int save(Account acc) throws SQLException {
		String sql = "insert into account_tbl(balance,create_date_time,user_id) values (?,?,?)";
		Object[] array = { acc.getBalance(),Timestamp.valueOf(acc.getCreateDate()),acc.getUser().getId()};
		
		stmt = execution(sql, array);
		stmt.executeUpdate();
		var rs = stmt.getGeneratedKeys();
		var res = 0;
		
		while(rs.next()) {
			res = rs.getInt(1);
		}
		closeConnection();
		return res;
	}

	@Override
	public int update(double balance, LocalDateTime updTime,int userId,int accId) throws SQLException {
		String sql = "update account_tbl set balance = ?,update_date_time = ? where user_id =  ? and id = ?";
		Object[] params = {balance,updTime,userId,accId}; 
		return execution(sql, params).executeUpdate();
	}

	@Override
	public void reset() throws SQLException {
		execution("truncate table account_tbl", null).execute();
	}

	@Override
	public List<Account> search(Account acc) throws SQLException {
		List<Account> accounts  = new ArrayList<Account>();
		List<Object> params = new ArrayList<Object>();
		StringBuilder sb = new StringBuilder("""
				select a.id,a.balance,a.create_date_time crdTime,a.update_date_time updTime,
				u.id,u.username,u.password,u.create_date from user_tbl u
				join account_tbl a on u.id = a.user_id
				where 1=1
				""");
		if(acc.getId() > 0) {
			sb.append(" and a.id = ?");
			params.add(acc.getId());
		}
		if(acc.getBalance() > 0) {
			sb.append(" and a.balance  >= ?");
			params.add(acc.getBalance());
		}
		if(null != acc.getCreateDate()) {
			sb.append(" and a.create_date_time >= ?");
			params.add(acc.getCreateDate());
		}
		if(null != acc.getUser()) {
			if(acc.getUser().getId() > 0) {
				sb.append(" and u.id = ?");
				params.add(acc.getUser().getId());
			}
			if(null != acc.getUser().getUsername()) {
				sb.append(" and u.username = ?");
				params.add(acc.getUser().getUsername());
			}
		}
		
		var rs = execution(sb.toString(), params.toArray()).executeQuery();
		while(rs.next()) {
			var user = new User(
					rs.getInt("u.id"),
					rs.getString("u.username"),
					rs.getString("u.password"),
					rs.getTimestamp("u.create_date").toLocalDateTime()
					);
			var account = new Account();
			account.setId(rs.getInt("a.id"));
			account.setBalance(rs.getDouble("a.balance"));
			account.setCreateDate(rs.getTimestamp("crdTime").toLocalDateTime());
			account.setUpdateDate(rs.getTimestamp("updTime").toLocalDateTime());
			account.setUser(user);
			accounts.add(acc);
		}
		return accounts;
	}
	
	

}
