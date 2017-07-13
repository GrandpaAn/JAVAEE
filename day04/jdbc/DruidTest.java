package com.zr.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidTest {

	public static void main(String[] args) {
		// 1. 把jdbc驱动和druid.jar复制粘贴到WebContent->WEB-INF->lib目录下
		// 2. 创建连接池对象
		DruidDataSource dds = new DruidDataSource();
		// 3. 设置参数
		// 3.1 设置连接参数
		dds.setUsername("root");
		dds.setPassword("eFbXJ8YYyCvJ55H91mUCWwA5hdsnhF/2DIV5w5y1+cp08Nvn+Jq/BeyN3pYDJKRE4GUCKFSJKIBdVwzB+IYf1Q==");
		dds.setUrl("jdbc:mysql:///test");
		dds.setDriverClassName("com.mysql.jdbc.Driver");
		
		// 3.3 检查数据连接(MySQL数据连接空闲不能超过8小时，超了会自动断开)
		dds.setValidationQuery("SELECT 'x'");// 设置检查数据库连接的SQL
								// MySQL使用: 	SELECT 'x'
								// Oracle使用: 	SELECT 1 FROM dual
		dds.setTestOnBorrow(false);	// 获取连接时检查连接是否有效
		dds.setTestOnReturn(false); // 返回连接时检查连接是否有效
		dds.setTestWhileIdle(true);	// 空闲时检查连接是否有效
		
		// 3.4 设置空闲连接关闭
		dds.setTimeBetweenEvictionRunsMillis(60000); // 销毁线程每隔多长时间检查一次是否有超时的空闲连接，单位毫秒
		// 当前时间减去最大活跃时间大于 MinEvictableIdleTimeMillis会被关闭
		dds.setMinEvictableIdleTimeMillis(600000);   
		
		// 3.2 调优设置
		dds.setInitialSize(1);		// 启动程序时预先创建多长个连接
		dds.setMaxActive(10);		// 连接池最大保存多少个连接，不允许创建超过指定的数量
		dds.setMinIdle(5);			// 最多有多少空闲连接
		dds.setMaxWait(10000);		// 连接最大等待时间，单秒毫秒
		
		// 3.5 是否使用缓存
		// 是否缓存PreparedStatement，Oracle支持该参数，MySQL必须5.5或以上版本支持。如果使用MySQL5.1.x设置true是无效
		dds.setPoolPreparedStatements(true);
		dds.setMaxPoolPreparedStatementPerConnectionSize(20);	// 最多缓存多少个PreparedStatement
		
		// 3.6 设置使用druid加密时候的配置
		dds.setConnectionProperties("config.decrypt=true");		// 设置需要对密码进行解密
		try {
			dds.setFilters("wall, config");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
									// stat				设置监控统计的filter
									// log4j			使用日志的filter
									// wall				使用防御SQL注入的filter
									// config			使用解密的filter
		
		// 注意：3.1的内容是必须配置，其它可以不配置，如果没有配置按默认配置使用。建议3.3的也配置上
		
		// 4. 获取连接
		try {
			Connection con = dds.getConnection();
			System.out.println(con);
			con.close(); // 不是真正关闭连接，是把连接交还给连接池给下个调用者使用
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5. 关闭连接池
		dds.close();
	}

}
