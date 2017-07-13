<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.*,com.zr.jdbc.entity.*, java.util.*" %>

<%
	// 声明每页最大显示记录数
	Integer max = 1;
	// 1. 获取总记录数
	String sql = "SELECT COUNT(id) AS size FROM t_user"; // 查询t_user表有多少条记录数
	Object[] params = {};
	CountSizeRowMapper csm = new CountSizeRowMapper();
	CountSize countSize = JdbcUtil.executeQuery(sql, params, csm).get(0);// 获取到总记录数
	// 2. 计算最大的页码数
	// 公式：最大记录数 / 每页最大的记录数 + (最大记录数 % 每页最大的记录数!=0需要加1)，%求余数
	//int maxPage = countSize.getSize() / max + (countSize.getSize() % max != 0 ? 1 : 0);
	// 在java里两个整数相除结果还是整数
	// Math包操作数字的结果一般都是小数，所以需要把数字强制转换为整数
	// ceil ceil(5.1)=6.0, round round(4.5)=5.0 round(4.4)=4.0, floor floor(4.9)=4.0
	// ceil(-5.9)=-5.0
	int maxPage = (int)Math.ceil(countSize.getSize() * 1.0 / max);
	// 3. 计算获取数据的开始位置
	// 公式：(当前页-1) * 每页的最大记录数(如果使用Oracle需要+1)
	// 3.1 获取当前页
	String currentPage = request.getParameter("p");
	// 3.2 判断当前页是否为null，如果是设置为1(默认第1页)
	int current;
	if (currentPage == null){
		current = 1;
	}else{
		// 3.3 判断当前页是否大于最大页码，如果大于设置为最后一页
		// 把字符串转换为数字再做判断
		current = Integer.parseInt(currentPage);// 把当前页从字符串的状态转换为数学上的数字
		if (current > maxPage){
			current = maxPage;
		}
		// 3.4 把负数转换为一个正数
		current = (int)Math.abs(current);
	}
	// 3.4 开始计算获取数据的开始位置
	Integer start = (current - 1) * max;
	
	// 4. 生成查询SQL语句
	// LIMIT限定数据的获取范围，LIMIT 开始位置, 最在获取数据量
	sql = "SELECT * FROM t_user LIMIT ?, ?"; 
	// 5. 生成参数
	Object[] params2 = {start, max};
	// 6. 调用工具类的查询语句
	UserRowMapper userRowMapper = new UserRowMapper();
	List<User> users = JdbcUtil.executeQuery(sql, params2, userRowMapper);
	//out.println(users);
	//User user = users.get(0);
	//out.println(user.getUsername());
	// 7. 显示数据
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页显示数据</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>性别</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<% for(int i=0;i<users.size();i++){ 
			 User u = users.get(i);
		%>
		<tr>
			<td><%=u.getId() %></td>
			<td><%=u.getUsername() %></td>
			<td><%=u.getPassword() %></td>
			<td><%=u.getSex() %></td>
			<td><%=u.getAge() %></td>
			<td>
				<a href="#?id=<%=u.getId()%>">编辑</a>
				<a href="#?id=<%=u.getId()%>">删除</a>
			</td>
		</tr>
		<% } %>
		<tr>
			<td colspan="6" align="right">
				<a href="pagination.jsp?p=<%=current-1==0?1:current-1%>">上一页</a>
				<a href="pagination.jsp?p=<%=current+1%>">下一页</a>
			</td>
		</tr>
	</table>
</body>
</html>



