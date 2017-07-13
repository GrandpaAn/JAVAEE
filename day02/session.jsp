<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 保存一个session
	session.setAttribute("name", "隔壁老王");
	
	// 获取session保存的内容
	String name = (String)session.getAttribute("name");

	// <br/>是html里的换行符
	out.println("session保存的name是: " + name + "<br/>");
	
	// 获取sessionid
	String sessionId = session.getId();
	out.println("sessionId = " + sessionId + "<br/>");
	
	// 设置session失效
	// session.invalidate();
	// session失效后重新从session里获取name
	// name = (String)session.getAttribute("name");
	// 执行失败，产生了错误信息
	// java.lang.IllegalStateException: getAttribute: Session already invalidated
	// out.println("session在invalidation后获取的name是" + name + "<br/>");
	
	// 移除session中的属性
	//session.removeAttribute("name");
	//name = (String)session.getAttribute("name");
	//out.println("移除session后name是："+name+"<br/>");

	// 设置session的有效时间，单位是秒，如果设置为-1表示永久有效
	// 如果超过设定，session保存的内容会失效，但是内存不一定会马上被回收
	// session.setMaxInactiveInterval(1);
	
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