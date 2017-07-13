package com.zr.jdbc.utils;

/**
 * JDBC���߿�
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
		// 1. �ȳ��Ի�ȡTomcat�����ӳ�
		initJndiDataSource();
		// 2. �ж��Ƿ��ȡ��
		if (dds == null){
			// 3. ���û�л�ȡʹ��Druid�����ӳ�
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
			// ��ȡ�����ļ�������ȡ���ݿ���ز���
			p.load(JdbcUtil.class.getClassLoader().
				getResourceAsStream("db.properties"));
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String driverClassName = p.getProperty("driverName");
			String url = p.getProperty("url") + "?useUnicode=" + 
					p.getProperty("useUnicode") + "&characterEncoding=" +
					p.getProperty("charset");
			// ����Druid���ӳر�Ҫ����
			DruidDataSource ds = new DruidDataSource();
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setDriverClassName(driverClassName);
			ds.setUrl(url);
			
			// �Լ��ܵ�������н���
			ds.setConnectionProperties("config.decrypt=true");
			ds.setFilters("wall, config");
			dds  = ds;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر��������ӣ������������ʱ����Ҫ���ã�ƽʱ���ܵ��� 
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
		PreparedStatement stmt = null;
		Connection con = null;
		try{
			con = dds.getConnection();
			stmt = con.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				stmt.setObject(i+1, params[i]);// params[i] �������ȡ��i������
			}
			int result = stmt.executeUpdate();
			return result;		// ���ؽ�����ݵ�����
		}catch(Exception e){
			e.printStackTrace();
			return -1;			// ���ִ�й����г��ִ��󣬰�-1���ظ�������
		}finally{
			close(stmt);
			close(con);
		}
	}
	/**
	 * ʵ�����Ӳ���
	 * @param sql			��Ҫִ�е�SQL���
	 * @return	ResultSet	��ѯ���Ľ����
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
				t = mapper.parse(rs);	// �����û��Զ���ResultSetӳ�䷽����ʵ�ִ�ResulSetת��Ϊʵ������
				list.add(t);
			}
			// list.add(t); 	// ���������������
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










