package com.zr.jdbc;

import com.alibaba.druid.filter.config.ConfigTools;

public class DruidConfigToolsTest {

	public static void main(String[] args) {
		// ConfigTolls	��Druid�ṩ��һ�����߿�
		// 	encrypt		���ַ������м��ܴ���
		try {
			String password = "123123";
			// ����
			String newPassword = ConfigTools.encrypt(password);
			System.out.println(password + ", " + newPassword);
			
			// ����
			String dePassword = ConfigTools.decrypt(newPassword);
			System.out.println(dePassword);
			
			// MD5, SHA1 SHA128, SHA256, SHA512��ɢ���㷨����������
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
