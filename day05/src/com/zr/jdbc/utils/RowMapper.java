package com.zr.jdbc.utils;

import java.sql.ResultSet;

/*
 * interface��class����
 * interface������Ϊ�Ķ��嵣���ṩ�����ʵ��
 * class������������ʵ��interface�������Ϊ
 * 
 * <T>	�Ƿ��ͣ���ʾ�������ͣ�������ʲô������classʵ�ֽӿ�ʱ����
 */
public interface RowMapper<T> {
	T parse(ResultSet rs);
}
