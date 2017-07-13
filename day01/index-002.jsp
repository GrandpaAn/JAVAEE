<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// request - 处理用户请求
	/*
	获取用户提交给服务器端的数据
	request.getParameter("参数的名称")
	返回指定参数名称数值，返回类型为String类型，若无对应名称的参数，返回null
	测试：localhost:8080/index-002.jsp?age=100
	*/
	String age = request.getParameter("age");// 获取浏览器提供的age的数据，赋值给age变量
	// "你的年龄是：" + age，把age拼接到前的字符串后面，变为一个新的字符串
	out.println("你的年龄是：" + age);
%>
</body>
</html>