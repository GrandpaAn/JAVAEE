package com.zr.jdbc.utils;

import java.sql.ResultSet;

/*
 * interface和class区别
 * interface包含行为的定义担不提供具体的实现
 * class可以用来具体实现interface定义的行为
 * 
 * <T>	是泛型，表示任意类型，具体是什么类型由class实现接口时定义
 */
public interface RowMapper<T> {
	T parse(ResultSet rs);
}
