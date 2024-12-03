package com.jdc.mkt.services;

import static com.jdc.mkt.utils.DbConnection.getConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.User;

public class UserService {

	public int insert(User user) throws SQLException {
		String sql = "insert into user_tbl (username,password) values (?,?)";
		Object[] array = { user.getUsername(), user.getPassword() };
		return execution(sql, array).executeUpdate();
	}

	public int update(String updPass, int id) throws SQLException {
		String sql = "update user_tbl set password = ? where id = ?";
		Object[] array = { updPass, id };
		return execution(sql, array).executeUpdate();
	}

	public int delete(int id) throws SQLException {
		String sql = "delete from user_tbl where id = ?";
		Object[] array = { id };
		return execution(sql, array).executeUpdate();
	}

	public List<User> select(String name, String password, LocalDateTime from, LocalDateTime to) throws SQLException {
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
				var user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getTimestamp("create_date_time").toLocalDateTime());
				users.add(user);
			}

		
		return users;
	}

	public void resetUserTable() throws SQLException {
		try(var con = getConnection();
				var stmt = con.createStatement();) {		
			stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
			stmt.execute("truncate table user_tbl");
			stmt.execute("SET FOREIGN_KEY_CHECKS = 1");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private PreparedStatement execution(String sql, Object[] params) {
		try {
			var con = getConnection();
			var stmt = con.prepareStatement(sql);
			
			if(null != params)
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i + 1, params[i]);
			}
			return stmt;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
