<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
login.jsp
显示用户的登录界面
action				点击登录后要打开那一个页面
method				提交数据的方式，有两种方式：1.get(默认)2.post
					区别：get可以在地址栏看到提交的内容，post看不到
 -->
<form action="loginAction.jsp" method="post">
	<div>用户名：<input type="text" name="user"/></div>
	<div>密码：<input type="password" name="pass"/></div>
	<div><input type="submit" value="登录"/></div>
</form>
</body>
</html>