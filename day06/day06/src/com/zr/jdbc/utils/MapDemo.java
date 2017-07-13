package com.zr.jdbc.utils;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		// map有个特征，它是以键值对的形式保存数据，前面的是键，后面的是值，需要获取数据的时候使用键得到值 
		Map<String, String> map = new HashMap<String, String>();
		
		// 设置保存内容
		map.put("name", "李白");
		map.put("age", "1200");
		map.put("sex", "男");
		
		// 获取值
		System.out.println(map.get("name"));
		
		// Map的遍历
		// 获取所有key的遍历方式
		Set<String> set = map.keySet();//获取到所有的键
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
