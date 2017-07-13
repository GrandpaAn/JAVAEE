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
			System.out.print("ʹ��PreparedStatement��");
			if (rs.next()){
				System.out.println("���ҵ�����");
			}else{
				System.out.println("���Ҳ�������");
			}
			
			sql = "SELECT * FROM t_user WHERE username='a' AND password='1' OR '1'='1'";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.print("ʹ��Statement��");
			if (rs.next()){
				System.out.println("���ҵ�����");
			}else{
				System.out.println("���Ҳ�������");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
