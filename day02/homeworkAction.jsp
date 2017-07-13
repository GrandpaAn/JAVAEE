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
	// 1. 获取第1个年龄
	String t = request.getParameter("age1");
	int age1 = Integer.parseInt(t);
	// 2. 获取第2个年龄
	t = request.getParameter("age2");// 重复使用上面声明过的变量
	int age2 = Integer.parseInt(t);
	// 3. 比较那个年龄比较大
	if (age1 > age2){// 判断第一个条件是否满足
		out.println(age1 + "比较大");
	}else if (age1 == age2){// 判断第二个条件是否满足
		out.println("两个都是" + age1);
	}else{// 如果上面的条件都不满足
		out.println(age2 + "比较大");
	}
%>
</body>
</html>