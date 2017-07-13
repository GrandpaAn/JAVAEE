package com.zr.jdbc;

import java.util.*;

public class PropertiesTest {

	public static void main(String[] args) {
		// 读取.properties配置文件
		// 1. 创建Propeties对象，只要是创建就使用new关键字
		Properties prop = new Properties();
		try{	// 尝试执行try大括号里的代码
			// 2. 加载配置文件
			prop.load(PropertiesTest.class.getClassLoader().
				getResourceAsStream("db.properties"));
			// 3. 读取文件里属性的名称从而得到数据
			String url = prop.getProperty("hello");
			System.out.println(url);
		}catch(Exception e){// 如果执行try的代码过程中发生错误就执行catch里的代码，避免产生闪退
			e.printStackTrace();
		}
	}

}
