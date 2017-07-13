<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<%--
这是jsp的注释方式，java代码不会执行
lanaguage			当前这个文件使用什么计算机语言执行，一般来说只能填写java
import 				引用java类到当前文件，所以可以使用java的类文件
					类似在java文件里的import java.util.Date;
contentType			告诉浏览器服务器响应的MIME和使用什么字符编码解释这个页面	
		charset		定义打开文件使用什么字符集
					常见字符集:
						ISO-8859-1			只能显示英文字符、数字和其它符号
						GBK					中文，能显示1万多个汉字
						GB2312				中文，表示的数字大概是2000多个
						UTF-8				Unicode的一种实现方式，能表示大部分地球上的语言
pageEncoding		当前文件使用什么字符集进行保存
 --%>    
<!-- HTML的注释,有可能造成java代码执行 -->
<%--
	可以在<%%>里写java代码，就像在class文件里一样
 --%>
<%
 	// out对象，类似System.out的作用
	out.print("今天早上的雨真的很大");
	out.println("今天的主要内容是JSP的使用");// 在浏览器上没有换行，HTML的换行符号是<br/>，println是在行的最后添加\n
									   // \n在页面上只能显示是一个空格，如果查看源码可以发现第三行实际是换行的
	out.print("今天是实训的第一天");
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