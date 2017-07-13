<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.JdbcUtil" %>
<%@page import="com.zr.jdbc.entity.UserRowMapper" %>
<%@page import="com.zr.jdbc.entity.User" %>
<%@page import="java.util.List" %>

<%
// 1. 获取用户传递的id
String id = request.getParameter("id");
// 2. 生成查询的SQL语句
String sql = "SELECT * FROM t_user WHERE id=?";
// 3. 创建需要传递的参数
Object[] params = {id};
// 4. 创建UserRowMapper
UserRowMapper mapper = new UserRowMapper();
// 5. 执行查询语句
List<User> users = JdbcUtil.executeQuery(sql, params, mapper);
// 6. 如果有查询结果获取第1条记录
User user = null;
if (users.size() > 0){
	user = users.get(0);
}
// 7. 把用户记录显示出来
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户 - 编辑</title>
</head>
<body>
<form action="user_update.jsp" method="post">
	<!-- disabled="disabled" 不能在这个文本框输入内容，ID是不允许修改 
		disable的部分不能把内容提交到服务器端，需要使用隐藏域提交数据
	-->
	<div>ID:<input type="text" value="<%=user.getId()%>" disabled="disabled" />
		<input type="hidden" name="id" value="<%=user.getId()%>"/>
	</div>
	<div>用户名：<input type="text" name="username" value="<%=user.getUsername()%>"/></div>
	<div>密码：<input type="text" name="password" value="<%=user.getPassword()%>"/></div>
	<div><input type="submit" value="保存"/></div>
</form>
</body>
</html>







