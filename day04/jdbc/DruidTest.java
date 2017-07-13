package com.zr.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidTest {

	public static void main(String[] args) {
		// 1. ��jdbc������druid.jar����ճ����WebContent->WEB-INF->libĿ¼��
		// 2. �������ӳض���
		DruidDataSource dds = new DruidDataSource();
		// 3. ���ò���
		// 3.1 �������Ӳ���
		dds.setUsername("root");
		dds.setPassword("eFbXJ8YYyCvJ55H91mUCWwA5hdsnhF/2DIV5w5y1+cp08Nvn+Jq/BeyN3pYDJKRE4GUCKFSJKIBdVwzB+IYf1Q==");
		dds.setUrl("jdbc:mysql:///test");
		dds.setDriverClassName("com.mysql.jdbc.Driver");
		
		// 3.3 �����������(MySQL�������ӿ��в��ܳ���8Сʱ�����˻��Զ��Ͽ�)
		dds.setValidationQuery("SELECT 'x'");// ���ü�����ݿ����ӵ�SQL
								// MySQLʹ��: 	SELECT 'x'
								// Oracleʹ��: 	SELECT 1 FROM dual
		dds.setTestOnBorrow(false);	// ��ȡ����ʱ��������Ƿ���Ч
		dds.setTestOnReturn(false); // ��������ʱ��������Ƿ���Ч
		dds.setTestWhileIdle(true);	// ����ʱ��������Ƿ���Ч
		
		// 3.4 ���ÿ������ӹر�
		dds.setTimeBetweenEvictionRunsMillis(60000); // �����߳�ÿ���೤ʱ����һ���Ƿ��г�ʱ�Ŀ������ӣ���λ����
		// ��ǰʱ���ȥ����Ծʱ����� MinEvictableIdleTimeMillis�ᱻ�ر�
		dds.setMinEvictableIdleTimeMillis(600000);   
		
		// 3.2 ��������
		dds.setInitialSize(1);		// ��������ʱԤ�ȴ����೤������
		dds.setMaxActive(10);		// ���ӳ���󱣴���ٸ����ӣ�������������ָ��������
		dds.setMinIdle(5);			// ����ж��ٿ�������
		dds.setMaxWait(10000);		// �������ȴ�ʱ�䣬�������
		
		// 3.5 �Ƿ�ʹ�û���
		// �Ƿ񻺴�PreparedStatement��Oracle֧�ָò�����MySQL����5.5�����ϰ汾֧�֡����ʹ��MySQL5.1.x����true����Ч
		dds.setPoolPreparedStatements(true);
		dds.setMaxPoolPreparedStatementPerConnectionSize(20);	// ��໺����ٸ�PreparedStatement
		
		// 3.6 ����ʹ��druid����ʱ�������
		dds.setConnectionProperties("config.decrypt=true");		// ������Ҫ��������н���
		try {
			dds.setFilters("wall, config");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
									// stat				���ü��ͳ�Ƶ�filter
									// log4j			ʹ����־��filter
									// wall				ʹ�÷���SQLע���filter
									// config			ʹ�ý��ܵ�filter
		
		// ע�⣺3.1�������Ǳ������ã��������Բ����ã����û�����ð�Ĭ������ʹ�á�����3.3��Ҳ������
		
		// 4. ��ȡ����
		try {
			Connection con = dds.getConnection();
			System.out.println(con);
			con.close(); // ���������ر����ӣ��ǰ����ӽ��������ӳظ��¸�������ʹ��
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5. �ر����ӳ�
		dds.close();
	}

}
