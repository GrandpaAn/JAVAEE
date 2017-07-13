package com.zr.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtilTest {

	public static void main(String[] args) {
//		v1()
		v2();
	}
	
	public static void v2(){
		JdbcUtil.init();

		String username = "adam";
		String password = "1234";
		
		String INSERT_USER = "INSERT INTO t_user(username, password) VALUES(?,?)";
		Object[] params = {username, password};
		JdbcUtil.executeUpdate(INSERT_USER, params);
		
		JdbcUtil.close();
	}

	public static void v1(){
		// 1. ��ʼ�����ݿ�����
				JdbcUtil.init();
				// 2. ִ�ж�ӦCRUD
				String INSERT_USER = "INSERT INTO t_user(username, password) VALUES('libai', '1234')";
				String DELETE_USER = "DELETE FROM t_user WHERE username='libai'";
				String FIND_USER = "SELECT * FROM t_user";
				
				//int result = JdbcUtil.executeUpdate(INSERT_USER);
				//System.out.println("���"+result+"������");
				
				ResultSet rs = JdbcUtil.executeQuery(FIND_USER);
				try{
					while(rs.next()){
						int id = rs.getInt("id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						System.out.println(id+", "+username+", "+password);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				JdbcUtil.close(rs);
				/*try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}*/
				
				
				// 3. �ر�����
				JdbcUtil.close();
	}
}
