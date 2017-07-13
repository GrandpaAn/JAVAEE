package com.zr.jdbc;

import java.util.*;

public class PropertiesTest {

	public static void main(String[] args) {
		// ��ȡ.properties�����ļ�
		// 1. ����Propeties����ֻҪ�Ǵ�����ʹ��new�ؼ���
		Properties prop = new Properties();
		try{	// ����ִ��try��������Ĵ���
			// 2. ���������ļ�
			prop.load(PropertiesTest.class.getClassLoader().
				getResourceAsStream("db.properties"));
			// 3. ��ȡ�ļ������Ե����ƴӶ��õ�����
			String url = prop.getProperty("hello");
			System.out.println(url);
		}catch(Exception e){// ���ִ��try�Ĵ�������з��������ִ��catch��Ĵ��룬�����������
			e.printStackTrace();
		}
	}

}
