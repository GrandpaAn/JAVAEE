<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 处理整个登录的流程
	
	// 1. 获取用户提交的用户名和密码
	request.setCharacterEncoding("UTF-8");		// 中文用户名需要添加
	String name = request.getParameter("user");
	String pass = request.getParameter("pass");
	// 2. 比对数据库里的用户和密码是否一致
	String dbName = "李明";
	String dbPass = "1234";
	if (dbName.equals(name) && dbPass.equals(pass)){
		// 3. 如果一致就在session里保存用户状态
		session.setAttribute("user", name);
		// 4. 跳转到用户登录后显示的首页
		response.sendRedirect("loginSuccess.jsp");	// 因为已经把数据保存在session所以可以使用重定向
													// 实际开发过程更多会使用转发
	}else{
		// 5. 如果不一致，在request里保存错误信息和登录的用户名
		request.setAttribute("errorMsg", "用户名或密码错误");
		request.setAttribute("user", name);
		// 6. 重新打开登录页(显示错误信息)
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>