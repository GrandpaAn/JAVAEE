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
	// 从request里获取errorMsg
	Object obj = request.getAttribute("errorMsg");
	// 判断是否有这个内容
	if (obj != null){
		// 如果有内容把内容输出
		out.println(obj);
	}
%>
</body>
</html>