package com.zr.jdbc;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		// list�ǽӿڣ�����new����Ҫʹ������ʵ�ַ�ʽ����
		// ArrayList����list��һ��ʵ�ַ�ʽ
		List list = new ArrayList();
		// �������
		list.add(1);
		list.add(3);
		list.add(2);
		// ���ݵĲ���
		// add(��ӵ���λ�ã� ����)
		list.add(1, 4);
		System.out.println(list);
		// ��ȡ����
		int a = (int)list.get(2);		//����λ�û�ȡ���ݣ�λ�������Ǵ�0��ʼ����
		System.out.println("�±���2��������" + a);
		// ��������
		// set(��Ҫ�޸ĵ�λ��, �µ���������)
		list.set(0, 10);				// �ѵ�1�������޸�Ϊ10
		System.out.println(list);
		// ɾ��
		// remove(����)	ɾ��ĳһ������
		// remove(����)  ɾ��ָ��λ�õ�����
		list.remove(1);					// ɾ���ڶ�������
		System.out.println(list);
		list.add("hello");
		list.add("��");
		
		// ����List
		// List�ĳ���ʹ��size()��ȡ
		for (int i=0;i<list.size();i++){
			System.out.print(list.get(i));
		}
		
		// ʹ�÷����޶�List������������ͣ�������ݿⲻһ�±�������лᷢ������
		// ���Ͳ���ʹ�û�������
		List<Integer> list2 = new ArrayList<Integer>();// JDK7����
		list2.add(10);
		// ���µ�������ݻ��������ԭ�����������ͺͷ��͵����Ͳ�һ��
//		list2.add(10.0);
//		list2.add(true);
//		list2.add("��");
		// ����ķ��ͻ��Զ�������������ʱд���;�����Ҫʹ��ʲô 
		List<Integer> list3 = new ArrayList<>();//JDK7��ʼ
	}

}





