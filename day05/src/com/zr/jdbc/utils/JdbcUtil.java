package com.zr.jdbc.utils;

/**
 * JDBC工具库
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.naming.*;
import javax.sql.*;

import com.alibaba.druid.pool.DruidDataSource;


public class JdbcUtil {
	private static DataSource dds = null;
	static{
		// 1. 先尝试获取Tomcat的连接池
		initJndiDataSource();
		// 2. 判断是否获取到
		if (dds == null){
			// 3. 如果没有获取使用Druid的连接池
			initDruidDataSource();
		}
	}
	public static void initJndiDataSource(){
		try {
			Context ctx = new InitialContext();
			dds = (DataSource)ctx.lookup("java:comp/env/jdbc/test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void initDruidDataSource(){
		Properties p = new Properties();
		try{
			// 读取配置文件，并获取数据库相关参数
			p.load(JdbcUtil.class.getClassLoader().
				getResourceAsStream("db.properties"));
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String driverClassName = p.getProperty("driverName");
			String url = p.getProperty("url") + "?useUnicode=" + 
					p.getProperty("useUnicode") + "&characterEncoding=" +
					p.getProperty("charset");
			// 配置Druid连接池必要参数
			DruidDataSource ds = new DruidDataSource();
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setDriverClassName(driverClassName);
			ds.setUrl(url);
			
			// 对加密的密码进行解密
			ds.setConnectionProperties("config.decrypt=true");
			ds.setFilters("wall, config");
			dds  = ds;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据连接，整个程序结束时才需要调用，平时不能调用 
	 */
	/*public static void close(){
		if (dds != null){
			try{
				dds.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}*/
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
	 * @param(String)	sql			操作的SQL语句
	 * @param(Object[])	params		SQL需要使用到的参数	
	 * @return	int					操作的记录数
	 */
	public static int executeUpdate(String sql, Object[] params){
		PreparedStatement stmt = null;
		Connection con = null;
		try{
			con = dds.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				stmt.setObject(i+1, params[i]);// params[i] 从数组获取第i个数据
			}
			int result = stmt.executeUpdate();
			return result;		// 返回结果传递调用者
		}catch(Exception e){
			e.printStackTrace();
			return -1;			// 如果执行过程中出现错误，把-1返回给调用者
		}finally{
			close(stmt);
			close(con);
		}
	}
	/**
	 * 实现增加操作
	 * @param sql			需要执行的SQL语句
	 * @return	ResultSet	查询到的结果集
	 */
	public static ResultSet executeQuery(String sql){
		Statement stmt = null;
		Connection con = null;
		try{
			con = dds.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			close(stmt);
			close(con);
		}
	}
	
	
	
	public static <T> List<T> executeQuery(String sql, Object[] params, RowMapper<T> mapper){
		PreparedStatement stmt = null;
		List<T> list = new ArrayList<>();
		Connection con = null;
		try{
			con = dds.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				stmt.setObject(i+1, params[i]);
			}
			ResultSet rs = stmt.executeQuery();

			T t;
			while(rs.next()){
				t = mapper.parse(rs);	// 调用用户自定义ResultSet映射方法，实现从ResulSet转换为实体类型
				list.add(t);
			}
			// list.add(t); 	// 不能在这里做添加
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			close(stmt);
			close(con);
		}
	}
	/**
	 * 关闭Statement/PreparedStatement连接
	 * @param stmt
	 */
	public static void close(Statement stmt){
		if (stmt != null){
			try{
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection con){
		if (con != null){
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}










