<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.Date,java.text.SimpleDateFormat,java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 1. 创建日期格式化类，设定格式化的日期格式
/*
	y			表示年，2个表示是年的最后2位，完整的年份用4个y表示
	M			表示月，如果需要表示01月需要使用两个M
	d			表示日
	h/H			表示小时，h使用的是12小时制，H24小时
	m			表示分
	s			表示秒
*/
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		// 不是基本类型，大部分需要使用到关键new进行赋值
// 2. 获取当前的系统时间
Date date = new Date();
// 3. 格式化第二步的结果
String text = sdf.format(date);//format是格式，parse把字符串的日期转换为Date类型
// 4. 输出格式化后的日期
out.println(text);

// 判断是否为闰年
// 1. 新建Calendar类，把当时间赋给这个变量
Calendar cal = Calendar.getInstance();// Calendar是抽象类不能new
// cal.setTime(date);// 设置时间，getInstance会得到当前的系统时间，所以setTime不是必须的
// 1. 获取当前时间的年份
//int year = date.getYear();	// getYear不建议再使用，应该使用calendar.get(Calendar.YEAR);
int year = cal.get(Calendar.YEAR);// Calendar.MONTH, Calendar.SECOND
year = 2016;
// 2. 根据分析步骤判断是否为闰年
// 	&&	与运算，只有&&两侧的结果都是真的时候结果才会是真
//  ||	或运算，只要||两侧其中有一个是真结果就是真
/*
	条件判断，如果()里的布尔值是true执行代码1，如果结果是false执行代码2
	if (布尔表达式){
		// 代码1
	}else{
		// 代码2
	}
	%	取模(求余数)
	=	赋值
	==	比较基本类型的数据是否相同
	!=	比较基本类型的数据是否不相等
*/
out.print(year);
if ((year%4 == 0 && year%100 != 100) || (year % 400 == 0)){
	out.println("是闰年");
}else{
	out.println("不是闰年");
}

/*
 需求说明
 在JSP页面中输出格式化的系统日期，并判断是否是闰年
 格式要求为“XXXX年XX月XX日  XXXX是闰年”
 分析
 获取当前的系统日期，并完成格式化
 判断闰年的条件
 ((能够被4整除)但(不能被100整除))或者(能够被400整除)
 推荐使用Calendar来获取年份
 */
%>
</body>
</html>