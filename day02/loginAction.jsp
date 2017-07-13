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
 	// 0. 解决获取汉字乱码问题，注意一定要在获取数据之前设置编码格式，否则取到文字还是会乱码
 	// 第一种处理乱码的方式(POST请求方式)
 	//request.setCharacterEncoding("UTF-8");
 
 	// 1. 获取用户名
 	String username = request.getParameter("user");
 						//参数写上<input type="text" name=""/>name的内容
 	// 第二种处理乱码的方式(GET请求方式)
 	// 先把字符串转换为byte的形式
 	byte[] bytes = username.getBytes("UTF-8");// 使用浏览器指定的字符集编码解码
	// byte bytes[] = username.getBytes(); // C/C++的方式，不建议使用
 	// 根据byte的内容重新创建字符串
 	username = new String(bytes, "UTF-8");	// 重新编码
 	
 	// 第三种修改tomcat的配置文件server.xml(GET请求方式)
 	// 找到<Connector/>标签在尖括号里添加上URIEncoding="UTF-8"
 								
 	// 2. 获取密码
 	String password = request.getParameter("pass");
 	// 3. 和数据库里的记录比较，设定假的数据表示数据库里用户名和密码
 	String USERNAEM = "admin";	// 假设是数据里的用户名
 	String PASSWORD = "1234";	// 假设是数据里的密码
 	// 不能使用==比较，对于非基本类型来说==是比较内存地址是否一致。需要使用equals方法比较
 	if (USERNAEM.equals(username) && PASSWORD.equals(password)){// 用户名和密码必须同时符合
 		// 3.1 如果和数据库里的一致，打印用户可以登录
 		//out.println("用户可以登录");
 	
 		// 保存用户名
 		request.setAttribute("user", username);
 		session.setAttribute("sessionUsername", username);
 	
 		// 登录成功，转换到登录成功的页面
 		//response.sendRedirect("loginSuccess.jsp");	// 重定向
 		// 服务器内部进行转发
 		RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
 		rd.forward(request, response);// request和response会转递给新的页面所可以获取到username
 	}else{
 		// 3.2 如果不一致，打印用户名或密码错误
 		//out.println("用户名或密码错误");
 		// 登录失败，转换到登录页面让用户重新登录
 		//request.setAttribute("user", username);
 		//从定向后是无法获取到username，因为我们没有把request传递给新的页面
 		//response.sendRedirect("login.jsp");
 		
 		request.setAttribute("errorMsg", "用户名或密码错误");
 		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
 		rd.forward(request, response);
 	}
 	
 	//out.println("username = " + username);
 %>
</body>
</html>