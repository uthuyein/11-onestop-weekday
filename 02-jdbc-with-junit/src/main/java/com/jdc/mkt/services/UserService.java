package com.jdc.mkt.services;

import static com.jdc.mkt.utils.DbConnection.getConnection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.User;

public class UserService{
		
	public int insert(User user) {
		String sql =  "insert into user_tbl (id,username,password) values (?,?,?)";
		Object[] array = {user.getId(),user.getUsername(),user.getPassword()};
		return execution(sql, array);
	}
	
	public  int update(String updPass,int id) {
		String sql =  "update user_tbl set password = ? where id = ?";
		Object[] array = {updPass,id};
		return execution(sql, array);
	}
	
	public int delete(int id) {
		String sql =  "delete from user_tbl where id = ?";
		Object[] array = {id};
		return execution(sql, array);
	}
	
	public List<User> select(String name,String password,LocalDateTime from,LocalDateTime to) {
		StringBuilder sb = new StringBuilder("select * from user_tbl where 1=1");
		List<Object> temp = new ArrayList<>();
		List<User> users = new ArrayList<User>();
		
		if(null != name) {
			sb.append(" and username = ?");
			temp.add(name);
		}
		if(null != password) {
			sb.append(" and password = ?");
			temp.add(password);
		}
		if(null != from) {
			sb.append(" and create_date_time >= ? ");
			temp.add(from);
		}
		if(null != to) {
			sb.append(" and create_date_time <= ? ");
			temp.add(to);
		}
		
		try(var con = getConnection();
				var stmt = con.prepareStatement(sb.toString()) ){
			
			for(int i = 0 ;i < temp.size() ; i ++) {			
				stmt.setObject(i+1, temp.get(i));
			}
			var rs = stmt.executeQuery();
			while(rs.next()) {
				var user = new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getTimestamp("create_date_time").toLocalDateTime()					
						);
				users.add(user);				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return users;
	}
	
	public void resetUserTable() {
		String sqlUser =  "truncate table user_tbl";
		Object[] array = {};
		execution(sqlUser, array);
	}
	
	private  int execution(String sql,Object[] params) {
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql) ){
			
			for(int i = 0 ;i < params.length ; i ++) {			
				stmt.setObject(i+1, params[i]);
			}
			var res = stmt.executeUpdate();
			System.out.println("Res : "+res);
			return res;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
