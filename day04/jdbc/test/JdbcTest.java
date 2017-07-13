package com.zr.jdbc.test;

import com.zr.jdbc.entity.User;
import com.zr.jdbc.utils.JdbcUtil;
import java.sql.*;

public class JdbcTest {

	public static void main(String[] args) {
		JdbcUtil.init();
		
		// limit 1 ��ʾֻ��ȡ��ѯ���ĵ�1�����
		String sql = "SELECT * FROM t_user LIMIT 1";
		//Object[] params = {};//��ʾû�в���
		ResultSet rs = JdbcUtil.executeQuery(sql);
		User user = null;
		try{
			if (rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
		}
		System.out.println(user.getUsername());
		
		JdbcUtil.close();
	}

}
