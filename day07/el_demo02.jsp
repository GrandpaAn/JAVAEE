<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sex = "男";
request.setAttribute("sex", sex);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 小括号运算 -->
${3 * 5 + 9} / ${3 * (5 + 4)}
<hr/>
<!-- 算术运算符 -->
<!-- 注意：除法和java代码不样，在这里两个整数相除结果可以变成是小数（不能整除的数字） -->
${3 + 5} / ${3 - 5} / ${3 * 5} / ${3 / 5} / ${3 % 5}
<hr/>
<!-- 关系运算符 -->
${3 == 5} / ${3 != 5} / ${3 > 5} / ${3 >= 5} / ${3 < 5} / ${3 <= 5}
<hr/>
<!-- 逻辑运算符 -->
${true && true} / ${true && false} / ${true || true} / ${true || false} / ${!true} / ${!false}
<hr/>
<!-- 条件运算符 -->
${3>5?"比你高":"比你矮"}
<hr/>
<!-- 判断变量是否为null -->
${empty username ? "没有" : "有"}username这个变量
<hr/>
<!-- 单选框 -->
<!-- 注意：name属性一定要写，并且name的内容需要一致，否则不能做为单选 -->
<input type="radio" name="sex" ${sex=='男'?'checked="checked"':''}/>男
<input type="radio" name="sex" ${sex=='女'?'checked="checked"':''}/>女
</body>
</html>


