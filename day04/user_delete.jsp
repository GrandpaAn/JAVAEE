<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.JdbcUtil" %>
<%
// 1. 获取用户传递过来的id
String id = request.getParameter("id");
// 2. 生成删除的SQL语句
String sql = "DELETE FROM t_user WHERE id=?";
// 3. 设置需要删除的id值
Object[] params = {id};
// 4. 执行SQL语句
JdbcUtil.executeUpdate(sql, params);
// 5. 返回到user_list.jsp
response.sendRedirect("user_list.jsp");
%>