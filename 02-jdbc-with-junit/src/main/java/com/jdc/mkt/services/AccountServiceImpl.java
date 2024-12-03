package com.jdc.mkt.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.mkt.dto.Account;
import static com.jdc.mkt.utils.DbConnection.getConnection;

public class AccountServiceImpl implements AccountInt{

	private Connection con;
	private PreparedStatement stmt;
	
	private PreparedStatement execution(String sql,Object[]array) {
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
	public int update(double balance, LocalDateTime updTime) {
		return 0;
	}

	@Override
	public void reset() throws SQLException {
		execution("truncate table account_tbl", null).execute();
	}

	@Override
	public List<Account> search(Account acc) {
		return null;
	}
	
	

}
