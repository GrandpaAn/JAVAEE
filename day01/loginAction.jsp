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
	文件名：loginAction.jsp		注意跟login.jsp的form的action要一致(包括大小写)
 -->
 <%
 	// 1. 获取用户名
 	String username = request.getParameter("user");
 						//参数写上<input type="text" name=""/>name的内容
 	// 2. 获取密码
 	String password = request.getParameter("pass");
 	// 3. 和数据库里的记录比较，设定假的数据表示数据库里用户名和密码
 	String USERNAEM = "admin";	// 假设是数据里的用户名
 	String PASSWORD = "1234";	// 假设是数据里的密码
 	// 不能使用==比较，对于非基本类型来说==是比较内存地址是否一致。需要使用equals方法比较
 	if (USERNAEM.equals(username) && PASSWORD.equals(password)){// 用户名和密码必须同时符合
 		// 3.1 如果和数据库里的一致，打印用户可以登录
 		out.println("用户可以登录");
 	}else{
 		// 3.2 如果不一致，打印用户名或密码错误
 		out.println("用户名或密码错误");
 	}
 %>
</body>
</html>