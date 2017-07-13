package com.zr.jdbc.utils;


import java.sql.*;
import java.util.Properties;
/**
 * JDBC���߿�
 */
public class JdbcUtil {
	private static Connection con;			// �������ݿ�����
	private static String url;
	private static String username;
	private static String password;
	private static String driverClassName;
	// javaʹ�ñ�������ʹ������ı���������������������������Ĵ�������
	static{
		// ����һ����̬����飬����JdbcUtil��ʱ��������Ĵ��������ִ��һ��(��һ��)
		// 1. ����Propeties����ֻҪ�Ǵ�����ʹ��new�ؼ���
		Properties p = new Properties();
		// 2. ���������ļ�
		try{
			p.load(JdbcUtil.class.getClassLoader().
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
	 * �������ݿ������
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
	 * �ر����ݿ�����
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
	 * �ر�ResultSet
	 * @param rs
	 */
	public static void close(ResultSet rs){
		if (rs != null){ //	�ж��Ƿ�����������Ч����
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * ʵ�����ݿ����ɾ�Ĳ���
	 * @param(String)	sql			������SQL���
	 * @param(Object[])	params		SQL��Ҫʹ�õ��Ĳ���	
	 * @return	int					�����ļ�¼��
	 */
	public static int executeUpdate(String sql, Object[] params){
		//Statement stmt = null;
		PreparedStatement stmt = null;
		try{
			/*stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);*/
			stmt = con.prepareStatement(sql);
			/*
			 * for (int i=0;i<params.length;i++)�ظ�ִ��i�δ��룬i�Ĵ�����ҪС��params������������ݸ���
			 * ִ�����̣�
			 * 1. int i=0
			 * 2. i<params.length	���С��ִ��ѭ�������ڻ���ڲ���ִ��ѭ��
			 * 3. �����2��Ϊֱ��ִ�д���
			 * 4. ִ��i++��i++��ͬ��i=i+1
			 * 5. ִ�е�2��
			 */
			for (int i=0;i<params.length;i++){
				stmt.setObject(i+1, params[i]);// params[i] �������ȡ��i������
			}
			int result = stmt.executeUpdate();
			return result;		// ���ؽ�����ݵ�����
		}catch(Exception e){
			e.printStackTrace();
			return -1;			// ���ִ�й����г��ִ��󣬰�-1���ظ�������
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
	 * ʵ�����Ӳ���
	 * @param sql			��Ҫִ�е�SQL���
	 * @return	ResultSet	��ѯ���Ľ����
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
	
	
	public static <T> void executeQuery(String sql, Object[] params, RowMapper<T> mapper){
		PreparedStatement stmt = null;
		try{
			stmt = con.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				stmt.setObject(i+1, params[i]);
			}
			ResultSet rs = stmt.executeQuery();
			Object obj;
			while(rs.next()){
				obj = mapper.parse(rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(stmt);
		}
	}
	/**
	 * �ر�Statement/PreparedStatement����
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
}










