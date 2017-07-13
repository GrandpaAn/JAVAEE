<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 判断是否用户有登录
	// 1. 从session里获取表示用户状态变量（使用预定义好的表示用户状态变量名）
	Object obj = session.getAttribute("user");
	// 2. 判断获取出来的变量是否为null
	if (obj == null){
		// 3. 如果是表示用户是没有登录的，需要设置一个提示信息表示用户需要登录
		// <a/>就是在页面上鼠标可以点击的文字，href就是点击需要打开那一个地址的页面
		String s = "您还没有登录，请先<a href=\"login.jsp\">登录账号</a>。" +
			"如果您没有账号请先<a href=\"#\">注册</a>";
		request.setAttribute("errorMsg", s);
		// 4. 转发到错误页面
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");//设定需要打开的页面
		rd.forward(request, response);									 //打开页面
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 用户是否登录，一般把登录状态放在session范围里 --%>
<%out.print(session.getAttribute("user"));%>，欢迎使用XXX系统
</body>
</html>