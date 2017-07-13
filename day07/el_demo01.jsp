<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.entity.*, java.util.*" %>
<%
	String name = "李白";
	request.setAttribute("name", name);
	
	User user = new User();
	user.setAge(1300);
	user.setId(1);
	user.setPassword("1234");
	user.setSex("男");
	user.setUsername("libai");
	request.setAttribute("user", user);
	
	String[] names = {"李白","李黑","李高","李矮"};
	List<String> list = Arrays.asList(names); // Arrays.asList把数组转换为List的形式
	Map<String, String> map = new HashMap<>();
	map.put("name", "李白");
	map.put("nickname", "李太白");
	map.put("age", "1300");
	
	request.setAttribute("names", names);
	request.setAttribute("list", list);
	request.setAttribute("map", map);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 之前 -->
	<%=name %> / 
	<!-- 现在 -->
	<%-- 使用EL表达式，需要把值保存在request,session里。如果需要输入的内容没有保存，不会有输出 --%>
	${name} - (${firstName})
	<hr/>
	<!-- 之前 -->
	<%=user.getUsername() %> / 
	<!-- 现在 -->	
	${user.username} / ${user["username"] }
	<hr/>
	<!-- 获取数组的内容 -->
	<!-- 不能使用属性.数字的形式获取数据的内容，只能使用[]，在中括里写上需要获取位置的数据 -->
	names = ${names[1]} / <%-- ${names.1}--%> (${names[10]})
	<hr/>
	<!-- 获取list数据 -->
	list = ${list[2]} / <%-- ${list.2} --%> (${list[10]})
	<hr/>
	<!-- 获取map数据 -->
	<!-- 可以通过[]或.的方式获取，如果获取的键不存在什么内容都不会输出 -->
	map = ${map["nickname"]} / ${map.name}
	
	
</body>
</html>




