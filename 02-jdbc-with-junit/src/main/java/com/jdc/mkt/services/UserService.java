package com.jdc.mkt.services;

import static com.jdc.mkt.utils.DbConnection.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.User;

public class UserService {
	private Connection con;
	private static PreparedStatement stmt;

	public int insert(User user) throws SQLException {
		String sql = "insert into user_tbl (username,password) values (?,?)";
		Object[] array = { user.getUsername(), user.getPassword() };
		stmt = execution(sql, array);
		stmt.executeUpdate();
		var rs = stmt.getGeneratedKeys();
		while(rs.next()) {
			return rs.getInt(1);
		}
		closeConnection();
		return 0;
	}

	public int update(String updPass, int id) throws SQLException {
		String sql = "update user_tbl set password = ? where id = ?";
		Object[] array = { updPass, id };
		int res = execution(sql, array).executeUpdate();
		closeConnection();
		return res;

	}

	public int delete(int id) throws SQLException {
		String sql = "delete from user_tbl where id = ?";
		Object[] array = { id };
		int res = execution(sql, array).executeUpdate();
		closeConnection();
		return res;
	}

	public List<User> search(String name, String password, LocalDateTime from, LocalDateTime to) throws SQLException {
		StringBuilder sb = new StringBuilder("select * from user_tbl where 1=1");
		List<Object> temp = new ArrayList<>();
		List<User> users = new ArrayList<User>();

		if (null != name) {
			sb.append(" and username = ?");
			temp.add(name);
		}
		if (null != password) {
			sb.append(" and password = ?");
			temp.add(password);
		}
		if (null != from) {
			sb.append(" and create_date_time >= ? ");
			temp.add(from);
		}
		if (null != to) {
			sb.append(" and create_date_time <= ? ");
			temp.add(to);
		}

		var rs = execution(sb.toString(), temp.toArray()).executeQuery();

		while (rs.next()) {
			var user = new User(
					rs.getInt("id"), 
					rs.getString("username"), 
					rs.getString("password"),
					rs.getTimestamp("create_date_time").toLocalDateTime());
			users.add(user);
		}
		closeConnection();
		return users;
	}

	private PreparedStatement execution(String sql, Object[] params) {
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			if (null != params)
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			return stmt;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void reset() throws SQLException {
		try {		
			con = getConnection();
			var stmt = con.createStatement();
			stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
			stmt.execute("truncate table user_tbl");
			stmt.execute("SET FOREIGN_KEY_CHECKS = 1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection();

	}

	private void closeConnection() throws SQLException {
		
//		if(stmt != null && !stmt.isClosed()) {
//			stmt.close();
//		}
		if (null != con && !con.isClosed()) {
			con.close();
		}
	}
}
