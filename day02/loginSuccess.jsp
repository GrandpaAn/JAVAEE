<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎<%
// (String)把后面的内容强制转换为小括里的数据类型
String username = (String)request.getAttribute("user");
out.print(username); 
%>，登录成功
<div><%out.println("sessionUsername=" + session.getAttribute("sessionUsername")); %></div>
</body>
</html>