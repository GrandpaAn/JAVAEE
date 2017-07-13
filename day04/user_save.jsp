<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.JdbcUtil"%>

<%
// 1. 设置使用的字符集编码
request.setCharacterEncoding("UTF-8");
// 2. 获取username和password
String username = request.getParameter("username");
String password = request.getParameter("password");
// 3. 生成sql语句
String sql = "INSERT INTO t_user(username, password) VALUES(?, ?)";
// 4. 设置sql语句的参数
Object[] params = {username, password};
// 5. 调用工具的executeUpdate方法
JdbcUtil.executeUpdate(sql, params);
// 6. 返回到user_list.jsp
response.sendRedirect("user_list.jsp");
%>