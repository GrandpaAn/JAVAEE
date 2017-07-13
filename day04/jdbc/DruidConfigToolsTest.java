package com.zr.jdbc;

import com.alibaba.druid.filter.config.ConfigTools;

public class DruidConfigToolsTest {

	public static void main(String[] args) {
		// ConfigTolls	是Druid提供的一个工具库
		// 	encrypt		给字符串进行加密处理
		try {
			String password = "123123";
			// 加密
			String newPassword = ConfigTools.encrypt(password);
			System.out.println(password + ", " + newPassword);
			
			// 解密
			String dePassword = ConfigTools.decrypt(newPassword);
			System.out.println(dePassword);
			
			// MD5, SHA1 SHA128, SHA256, SHA512，散列算法，不能逆向
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
