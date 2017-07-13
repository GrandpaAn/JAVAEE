package com.zr.jdbc;

import java.sql.*;
import java.util.Properties;
/**
 * JDBC工具库
 */
public class JdbcUtil_v1 {
	private static Connection con;			// 保存数据库连接
	private static String url;
	private static String username;
	private static String password;
	private static String driverClassName;
	// java使用变量，是使用最靠近的变量，变量的作用域是离它最近的大括号里
	static{
		// 这是一个静态代码块，调用JdbcUtil的时候，这里面的代码会优先执行一次(仅一次)
		// 1. 创建Propeties对象，只要是创建就使用new关键字
		Properties p = new Properties();
		// 2. 加载配置文件
		try{
			p.load(JdbcUtil_v1.class.getClassLoader().
				getResourceAsStream("db.properties"));
			username = p.getProperty("username");
			password = p.getProperty("password");
			driverClassName = p.getProperty("driverName");
			url = p.getProperty("url") + "?useUnicode=" + 
					p.getProperty("useUnicode") + "&characterEncoding=" +
					p.getProperty("charset");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建数据库的连接
	 */
	public static void init(){
//		String url = "jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF8";
//		String username = "root";
//		String password = "123123";
		try{
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 关闭数据库连接
	 */
	public static void close(){
		if (con != null){
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭ResultSet
	 * @param rs
	 */
	public static void close(ResultSet rs){
		if (rs != null){ //	判断是否真正传入有效参数
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 实现数据库的增删改操作
	 * @return	int			操作的记录数
	 */
	public static int executeUpdate(String sql){
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			return result;		// 返回结果传递调用者
		}catch(Exception e){
			e.printStackTrace();
			return -1;			// 如果执行过程中出现错误，把-1返回给调用者
		}finally{
			if (stmt != null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 实现增加操作
	 * @param sql			需要执行的SQL语句
	 * @return	ResultSet	查询到的结果集
	 */
	public static ResultSet executeQuery(String sql){
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}










