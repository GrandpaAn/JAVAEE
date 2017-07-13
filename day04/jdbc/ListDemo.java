package com.zr.jdbc;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		// list是接口，不能new，需要使用它的实现方式创建
		// ArrayList，是list的一种实现方式
		List list = new ArrayList();
		// 添加数据
		list.add(1);
		list.add(3);
		list.add(2);
		// 数据的插入
		// add(添加到的位置， 数据)
		list.add(1, 4);
		System.out.println(list);
		// 获取数据
		int a = (int)list.get(2);		//根据位置获取数据，位置索引是从0开始计算
		System.out.println("下标是2的数据是" + a);
		// 更新数据
		// set(需要修改的位置, 新的数据内容)
		list.set(0, 10);				// 把第1个数据修改为10
		System.out.println(list);
		// 删除
		// remove(对象)	删除某一个对象
		// remove(索引)  删除指定位置的数据
		list.remove(1);					// 删除第二个数据
		System.out.println(list);
		list.add("hello");
		list.add("中");
		
		// 遍历List
		// List的长度使用size()获取
		for (int i=0;i<list.size();i++){
			System.out.print(list.get(i));
		}
		
		// 使用泛型限定List保存的数据类型，如果数据库不一致编译过程中会发生错误
		// 泛型不能使用基本类型
		List<Integer> list2 = new ArrayList<Integer>();// JDK7以下
		list2.add(10);
		// 以下的添加数据会产生错误，原因是数据类型和泛型的类型不一致
//		list2.add(10.0);
//		list2.add(true);
//		list2.add("中");
		// 后面的泛型会自动根据声明变量时写类型决定需要使用什么 
		List<Integer> list3 = new ArrayList<>();//JDK7开始
	}

}





