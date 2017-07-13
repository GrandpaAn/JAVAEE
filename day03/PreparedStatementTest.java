package com.zr.jdbc;

import java.sql.*;

public class PreparedStatementTest {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///test", "root", "123123");
			String sql = "SELECT * FROM t_user WHERE username=? AND password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setObject(1, "abc");
			pstmt.setObject(2, "1' OR '1'='1");
			ResultSet rs = pstmt.executeQuery();
			System.out.print("使用PreparedStatement：");
			if (rs.next()){
				System.out.println("查找到数据");
			}else{
				System.out.println("查找不到数据");
			}
			
			sql = "SELECT * FROM t_user WHERE username='a' AND password='1' OR '1'='1'";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.print("使用Statement：");
			if (rs.next()){
				System.out.println("查找到数据");
			}else{
				System.out.println("查找不到数据");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
