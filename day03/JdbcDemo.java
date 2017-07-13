package com.zr.jdbc;

import java.sql.*;


public class JdbcDemo {

	public static void main(String[] args) {
		//testAdd();
		//testAdd("libai", "libai");
		//testUpdate("abc", "321", 1);
		testDelete(5);
	}
	/**实现增加，有问题：不能现次执行，原因sql语句写死了*/
	public static void testAdd(){
		// 定义数据库操作的常用变量
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123123";
		// try...catch...finally是为解决代码执行过程出现的问题，如果不使用代码会直接结束，使用了可以处理完错误后继续执行
		// try 需要执行的代码 catch 出现问题时执行的代码 finally 最后一定要执行的代码
		try{
			// 1. 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获取连接
			con = DriverManager.getConnection(url, username, password);
			// 3. 创建Statement
			stmt = con.createStatement();
			// 4. 执行SQL
			String sql = "INSERT INTO t_user(username, password) VALUES('小明', 'xueba')";
			int result = stmt.executeUpdate(sql);
			System.out.println("共执行了" + result + "条语句");// 输出
			// 5. 关闭连接
			// con.close();			// 可以不在这里写，在finally最终对数据库连接进行关闭
		}catch(Exception e){
			e.printStackTrace();	// 输出错误信息
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
		// 定义数据库操作的常用变量
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123123";
		// try...catch...finally是为解决代码执行过程出现的问题，如果不使用代码会直接结束，使用了可以处理完错误后继续执行
		// try 需要执行的代码 catch 出现问题时执行的代码 finally 最后一定要执行的代码
		try{
			// 1. 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获取连接
			con = DriverManager.getConnection(url, username, password);
			// 3. 创建Statement
			stmt = con.createStatement();
			// 4. 执行SQL
			String sql = "INSERT INTO t_user(username, password) VALUES('"+name+"', '"+pass+"')";
			int result = stmt.executeUpdate(sql);
			System.out.println("共执行了" + result + "条语句");// 输出
			// 5. 关闭连接
			// con.close();			// 可以不在这里写，在finally最终对数据库连接进行关闭
		}catch(Exception e){
			e.printStackTrace();	// 输出错误信息
		}finally{
			try{
				if (con != null){con.close();}
				if (stmt != null){stmt.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**实现删除*/
	public static void testDelete(int id){
		// 定义数据库操作的常用变量
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123123";
		try{
			// 1. 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获取连接
			con = DriverManager.getConnection(url, username, password);
			// 3. 创建Statement
			stmt = con.createStatement();
			// 4. 执行SQL
			String sql = "DELETE FROM t_user";
			int result = stmt.executeUpdate(sql);
			System.out.println("共执行了" + result + "条语句");// 输出
		// 5. 关闭连接		
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
	 * 实现更新
	 * @param(String)		name		需要修改的用户名的内容
	 * @param(String)		pass		需要修改的密码内容
	 * @param(int)			id			需要修改的条件
	 */
	public static void testUpdate(String name, String pass, int id){
		try{
			// 1. 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获取连接
			String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
			String username = "root";
			String password = "123123";
			//新的try..catch处理，会自动关闭打开的对象，但需要JDK7或以上版本支持
			try(Connection con = DriverManager.getConnection(url, username, password)){
			// 3. 创建Statement
				try(Statement stmt = con.createStatement()){// 会自动关闭Statment
					// 4. 执行SQL
					String sql = "UPDATE t_user SET username='"+
							name+"', password='"+pass+"' WHERE id="+id;
					int result = stmt.executeUpdate(sql);
					System.out.println("更新了"+result+"条数据");
				}
			// 5. 关闭连接，不用再写 try(){}catch(){}会把小括号打开的内容自动做关闭，必须是JDK7或以上的版本支持
			} catch(Exception e1){
				e1.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**实现查询*/
	public static void testFind(){
		
	}
}
