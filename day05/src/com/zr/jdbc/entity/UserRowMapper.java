package com.zr.jdbc.entity;

import java.sql.ResultSet;

import com.zr.jdbc.utils.RowMapper;

/*
 * implements	实现interface的具体算法
 */
public class UserRowMapper implements RowMapper<User> {

	public User parse(ResultSet rs) {
		User user = new User();
		
		try{
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return user;
	}

}
