<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "大乔");
	session.setAttribute("name", "小乔");
	application.setAttribute("name", "乔国老");
	
	Integer i = (Integer)request.getAttribute("times");
	Integer j = (Integer)session.getAttribute("times");
	Integer k = (Integer)application.getAttribute("times");
	if (i == null) {i = 0;}
	if (j == null) {j = 0;}
	if (k == null) {k = 0;}
	i = i + 1;
	j = j + 1;
	k = k + 1;
	request.setAttribute("times", i);
	session.setAttribute("times", j);
	application.setAttribute("times", k);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	name = ${name}<br/><!-- 如果没有说明作用域，默认情况是从request获取 -->
	request: ${requestScope.name}<br/>
	session: ${sessionScope.name}<br/>
	application: ${applicationScope.name}<br/>
	<hr/>
	<!-- 
	request			每次向服务器发送请求时都会产生一个新的request
	session			每次对会把当前浏览器保存的sessionId发送给服务器，服务器会出保存的数据
					里查看有没有这个ID，有可以重用
	application		所有浏览器共用application的空间保存数据
	 -->
	request第${requestScope.times}次访问<br/>
	session第${sessionScope.times}次访问<br/>
	application第${applicationScope.times}次访问<br/>
	
	
	
	
	
	
	
</body>
</html>