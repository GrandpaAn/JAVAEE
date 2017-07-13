<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.JdbcUtil" %>
<%
// 1. 设置获取参数的字符编码格式
request.setCharacterEncoding("UTF-8");
// 2. 获取id, username, password
String id = request.getParameter("id");
String username = request.getParameter("username");
String password = request.getParameter("password");
// 3. 生成更新的SQL语句
String sql = "UPDATE t_user SET username=?, password=? WHERE id=?";
// 4. 设置SQL的参数具体内容
Object[] params = {username, password, id};
// 5. 执行SQL语句 
JdbcUtil.executeUpdate(sql, params);
// 6. 返回user_list.jsp
response.sendRedirect("user_list.jsp");
%>