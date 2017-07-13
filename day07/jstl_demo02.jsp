<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<String> list = Arrays.asList(new String[]{
			"李白1","李白2","李白3","李白4","李白5"
	});
	request.setAttribute("list", list);
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>迭代</title>
</head>
<body>
	<%--
		forEach			循环
			items		需要循环的内容
			var			循环过程中每次得到的值都会被赋给var所声明的变量名
			varStatus	声明一个表示状态的变量
				index	数组或list的下标号
				count	当前是第几个数据
			begin		从那个下标开始获取
			end			获取到那个下标
			step		相隔多长的间隔获取一条记录，默认1
	 --%>
	<h3>例五、模拟翻页的序号</h3>
	<%
		// 1. 提供当前是第几页
		String p = request.getParameter("p");
		int currentPage = 1;
		if (p!=null){	// 没有设置p的内容
			currentPage = (int)Math.abs(Integer.parseInt(p));
		}
		request.setAttribute("page", currentPage);
		// 2. 设置好每页的最大记录数
		request.setAttribute("max", "5");
	%>
	<table width="500" border="1">
		<tr><th>序号</th><th>姓名</th></tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr align="center"><td>${(page-1)*max + status.count}</td><td>${item}</td></tr>
		</c:forEach>
	</table>
	 
	<h3>例四</h3>
	<table width="500" border="1">
		<tr><th>序号</th><th>姓名</th></tr>
		<c:forEach items="${list}" var="item" varStatus="status" step="2">
		<tr align="center"><td>${status.count}</td><td>${item}</td></tr>
		</c:forEach>
	</table>
	 
	<h3>例三</h3>
	<table width="500" border="1">
		<tr><th>序号</th><th>姓名</th></tr>
		<c:forEach items="${list}" var="item" varStatus="status" begin="1" end="3">
		<tr align="center"><td>${status.count}</td><td>${item}</td></tr>
		</c:forEach>
	</table> 
	 
	<h3>例二</h3>
	<table width="500" border="1">
		<tr><th>序号</th><th>姓名</th></tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr align="center"><td>${status.count}</td><td>${item}</td></tr>
		</c:forEach>
	</table>
	 
	<h3>例一</h3>
	<table width="500" border="1">
		<tr><th>姓名</th></tr>
		<%-- <% for(int i=0;i<list.size()i++){String s = list.get(i);} %> --%>
		<c:forEach items="${list}" var="item">
		<tr align="center"><td>${item}</td></tr>
		</c:forEach>
	</table>
</body>
</html>









