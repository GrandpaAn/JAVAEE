<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.entity.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
使用JSTL的前提
1. 将stardard.jar和jstl.jar复制到WebContent->WEB-INF->lib目录里(jstl-1.2不需要使用standard.jar，
	如果使用的是1.0需要引用)
2. 在<%@page%>后添加<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>(uri的地址可以
	通过alt+/[在英文输入法状态下]快捷选择添加)
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:out value="" default="" escapeXml=""
	value		需要输出的内容
	default		如果需要输出内容的变量不存在就输出default的内容
	escapeXml	如果内容里包含html的标签，true把标签当做是字符串解释，false当做是HTML的标签使用
 --%>
<%
	request.setAttribute("name", "<李白>");// 期待：&lt;李白&gt;
	request.setAttribute("table", "<table border=\"1\"><tr><td>姓名</td></tr><tr><td>李白</td></tr></table>");
%>
<c:out value="${name}" default="李太白" escapeXml="true"/> /
<c:out value="${name}" default="李太白" escapeXml="false"/> /
<c:out value="${nickname}" default="李太白" escapeXml="true"/>
<c:out value="${table}" escapeXml="false"/>
<c:out value="${table}" escapeXml="true"/>
<hr />
<%-- 
	<c:set var="" value="" scope=""/>		设置一个变量
		var			设置一个变量名，后面的代码可以根据这个变量名获取内容
		value		设置需要保存的内容
		scope		设置当前变量保存在什么范围里，范围包括request, session和applicaiton
	<c:set target="" property="" value=""/>	修改一个对象里的属性
		target		需要修改的对象，对象需要使用EL表达式获取(不能直接写变量名)
		property	需要修改对象里的某个属性(成员变量、变量)
		value		需要修改的内容
 --%>
<c:set var="url" value="/20170711" scope="request"/>
${url} / <c:out value="${url}" default="没有找到变量" />
<hr />
<%
	User user = new User();
	request.setAttribute("user", user);
%>
没有修改前：<c:out value="${user.username}" default="还没有设置内容"/><br/>
<c:set target="${user}" property="username" value="李白"/>
修改之后：<c:out value="${user.username}" default="还没有设置内容"/><br/>
</body>
</html>










