package com.zr.jdbc.utils;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		// map�и������������Լ�ֵ�Ե���ʽ�������ݣ�ǰ����Ǽ����������ֵ����Ҫ��ȡ���ݵ�ʱ��ʹ�ü��õ�ֵ 
		Map<String, String> map = new HashMap<String, String>();
		
		// ���ñ�������
		map.put("name", "���");
		map.put("age", "1200");
		map.put("sex", "��");
		
		// ��ȡֵ
		System.out.println(map.get("name"));
		
		// Map�ı���
		// ��ȡ����key�ı�����ʽ
		Set<String> set = map.keySet();//��ȡ�����еļ�
		String fields = "";
		String values = "";
		for(String key : set){	// foreach
			System.out.println("key="+key + ", value="+map.get(key));
			fields = fields + key + ",";
			values = values + "?,";
		}
		
		System.out.println(fields);
		System.out.println(values);
		
	}

}
