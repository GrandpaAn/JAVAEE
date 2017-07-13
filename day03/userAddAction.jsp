<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.JdbcUtil"%>
<%
	// 1. 使用page引用数据库工具类
	// 2. 设置获取的数据编码格式为UTF-8
	request.setCharacterEncoding("UTF-8");
	// 3. 获取form表单提交给服务器的数据
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	// 4. 生成SQL语句和添加的数据
	String sql = "INSERT INTO t_user(username, password) VALUES(?, ?)";
	Object[] params = {username, password};
	// 5. 初始化数据库连接
	JdbcUtil.init();
	// 6. 调用工具类的添加方法
	int result = JdbcUtil.executeUpdate(sql, params);
	// 7. 关闭工具类的数据库连接
	JdbcUtil.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 1. 如果值小于-1数据出现问题，如果是0表示添加不成功时输出对应的信息
	if (result <= 0){
		out.println("服务器出了点小问题，等一会再尝试或者联系管理员");
	}else{
	// 2. 其它情况输出添加成功的信息
		out.println("添加用户成功。<a href=\"userAdd.jsp\">添加新的用户</a>");
	}
%>
</body>
</html>