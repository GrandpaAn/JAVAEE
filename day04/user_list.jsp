<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.JdbcUtil" %>
<%@page import="com.zr.jdbc.entity.UserRowMapper" %>
<%@page import="com.zr.jdbc.entity.User" %>
<%@page import="java.util.List" %>
<%
// 1. 生成需要查找数据的SQL语句
String sql = "SELECT * FROM t_user";
// 2. 创建需要传递的参数
Object[] params = {};
// 3. 创建UserRowMapper
UserRowMapper mapper = new UserRowMapper();
// 4. 查找数据
List<User> users = JdbcUtil.executeQuery(sql, params, mapper);
// 5. 通过table列出数据
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户 - 列表</title>
</head>
<body>
	<!-- border添加边框, width设置格式的宽度, align设置格式的对齐方式 -->
	<table width="700" align="center"><tr><td><a href="user_add.jsp">添加用户</a></td><tr></table>
	<table border="1" width="700" align="center"><!-- 表示这是一个表格 -->
		<!-- <tr><td colspan="4"><a href="user_add.jsp">添加用户</a></td></tr> -->
		<tr><!-- 表格里一行 -->
			<th>ID</th><!-- 表示是某列的标题 -->
			<th>用户名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
<%
	User user;	// 如果在循环里声明，每次循环结束变量会变回收，新的开始时变量又要重新创建
	for(int i=0;i<users.size();i++){
		user = users.get(i);
		
		// 直接使用JAVA代码输出一行数据
/* 		out.println("<tr align=\"center\">");
		out.println("<td>"+user.getId()+"</td>");
		out.println("<td>"+user.getUsername()+"</td>");
		out.println("<td>"+user.getPassword()+"</td>");
		out.println("<td>编辑　删除</td>");
		out.println("</tr>"); */
%>
		<!-- 嵌套HTML代码在JAVA代码里 -->
		<tr align="center"><!-- 设置tr里的td的文字的对齐方式 -->
			<td><%out.print(user.getId());%></td><!-- 表示一列 -->
			<td><%=user.getUsername()%></td><!-- 是上面的缩写，效果一致 -->
			<td><%=user.getPassword() %></td>
			<td>
				<a href="user_edit.jsp?id=<%=user.getId()%>">编辑</a>
				<a href="user_delete.jsp?id=<%=user.getId()%>">删除</a>
			</td>
		</tr>
<% } %>
	</table>
	
</body>
</html>





