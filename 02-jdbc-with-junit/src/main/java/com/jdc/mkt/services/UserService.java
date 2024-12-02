package com.jdc.mkt.services;

import static com.jdc.mkt.utils.DbConnection.getConnection;

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
