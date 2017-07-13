<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="loginAction.jsp" method="post">
			<h3>XXX系统</h3>
			<!-- value打开页面时可以在页面的输入框看到value的内容 -->
			<div>用户名：<input type="text" name="user" value="<%
				// 从request里获取保存的登录名
				String user = (String)request.getAttribute("user");
				// 如果登录过就把用户名输出
				if (user != null){
					out.print(user);
				}
			%>"/></div>
			<div>密　码：<input type="password" name="pass"/></div>
			<div><%
				String text = (String)request.getAttribute("errorMsg");
				if(text!=null){
					out.println(text);
				} 
				%></div>
			<div><input type="submit" value="登录"/>　<a href="#">注册账号</a></div>
		</form>	
	</div>
</body>
</html>