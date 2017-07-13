<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	// 获取当前页
	String p = request.getParameter("p");
	int cur = 1;
	if (p!=null){
		cur = (int)Math.abs(Integer.parseInt(p));
	}
	// 设置当前页到request
	request.setAttribute("cur", cur);
	// 设置最后一页页码到request
	request.setAttribute("last", 10);
	
	Date date = new Date();
	request.setAttribute("date", date);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>if标签</title>
</head>
<body>
<!-- 判断是否为第一页、最后一页或其他页 -->
<%--
	<c:if/>			条件判断
		test		使用el表达式判断结果的真假
		var			声明一个变量用来保存test属性得到的结果
		scope		设置var声明的变量保存在什么范围
	注意：JSTL 没有提供else或者是elseif的标签
 --%>
<c:if test="${cur==1 || cur==last}" var="testPage" scope="request">
	当前页是第一页或最后一页
</c:if>
<c:if test="${!testPage}"><!-- 不是第一页或最后页时 -->
	当前页是其他页
</c:if>
<hr/>
<h3>格式化日期输出</h3>
<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/><br/>
<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/>
</body>
</html>








