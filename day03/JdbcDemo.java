package com.zr.jdbc;

import java.sql.*;


public class JdbcDemo {

	public static void main(String[] args) {
		//testAdd();
		//testAdd("libai", "libai");
		//testUpdate("abc", "321", 1);
		testDelete(5);
	}
	/**ʵ�����ӣ������⣺�����ִ�ִ�У�ԭ��sql���д����*/
	public static void testAdd(){
		// �������ݿ�����ĳ��ñ���
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123123";
		// try...catch...finally��Ϊ�������ִ�й��̳��ֵ����⣬�����ʹ�ô����ֱ�ӽ�����ʹ���˿��Դ������������ִ��
		// try ��Ҫִ�еĴ��� catch ��������ʱִ�еĴ��� finally ���һ��Ҫִ�еĴ���
		try{
			// 1. ��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ��ȡ����
			con = DriverManager.getConnection(url, username, password);
			// 3. ����Statement
			stmt = con.createStatement();
			// 4. ִ��SQL
			String sql = "INSERT INTO t_user(username, password) VALUES('С��', 'xueba')";
			int result = stmt.executeUpdate(sql);
			System.out.println("��ִ����" + result + "�����");// ���
			// 5. �ر�����
			// con.close();			// ���Բ�������д����finally���ն����ݿ����ӽ��йر�
		}catch(Exception e){
			e.printStackTrace();	// ���������Ϣ
		}finally{
			try{
				if (con != null){con.close();}
				if (stmt != null){stmt.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void testAdd(String name, String pass){
		// �������ݿ�����ĳ��ñ���
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123123";
		// try...catch...finally��Ϊ�������ִ�й��̳��ֵ����⣬�����ʹ�ô����ֱ�ӽ�����ʹ���˿��Դ������������ִ��
		// try ��Ҫִ�еĴ��� catch ��������ʱִ�еĴ��� finally ���һ��Ҫִ�еĴ���
		try{
			// 1. ��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ��ȡ����
			con = DriverManager.getConnection(url, username, password);
			// 3. ����Statement
			stmt = con.createStatement();
			// 4. ִ��SQL
			String sql = "INSERT INTO t_user(username, password) VALUES('"+name+"', '"+pass+"')";
			int result = stmt.executeUpdate(sql);
			System.out.println("��ִ����" + result + "�����");// ���
			// 5. �ر�����
			// con.close();			// ���Բ�������д����finally���ն����ݿ����ӽ��йر�
		}catch(Exception e){
			e.printStackTrace();	// ���������Ϣ
		}finally{
			try{
				if (con != null){con.close();}
				if (stmt != null){stmt.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**ʵ��ɾ��*/
	public static void testDelete(int id){
		// �������ݿ�����ĳ��ñ���
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123123";
		try{
			// 1. ��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ��ȡ����
			con = DriverManager.getConnection(url, username, password);
			// 3. ����Statement
			stmt = con.createStatement();
			// 4. ִ��SQL
			String sql = "DELETE FROM t_user";
			int result = stmt.executeUpdate(sql);
			System.out.println("��ִ����" + result + "�����");// ���
		// 5. �ر�����		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (con != null){con.close();}
				if (stmt != null){stmt.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * ʵ�ָ���
	 * @param(String)		name		��Ҫ�޸ĵ��û���������
	 * @param(String)		pass		��Ҫ�޸ĵ���������
	 * @param(int)			id			��Ҫ�޸ĵ�����
	 */
	public static void testUpdate(String name, String pass, int id){
		try{
			// 1. ��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ��ȡ����
			String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
			String username = "root";
			String password = "123123";
			//�µ�try..catch�������Զ��رմ򿪵Ķ��󣬵���ҪJDK7�����ϰ汾֧��
			try(Connection con = DriverManager.getConnection(url, username, password)){
			// 3. ����Statement
				try(Statement stmt = con.createStatement()){// ���Զ��ر�Statment
					// 4. ִ��SQL
					String sql = "UPDATE t_user SET username='"+
							name+"', password='"+pass+"' WHERE id="+id;
					int result = stmt.executeUpdate(sql);
					System.out.println("������"+result+"������");
				}
			// 5. �ر����ӣ�������д try(){}catch(){}���С���Ŵ򿪵������Զ����رգ�������JDK7�����ϵİ汾֧��
			} catch(Exception e1){
				e1.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**ʵ�ֲ�ѯ*/
	public static void testFind(){
		
	}
}
