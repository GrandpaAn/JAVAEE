<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*"%>

<%
	Context ctx = new InitialContext();
	// 获取连接池对象
	// lookup里的字符串写法：java:comp/env/Context标签里的name
	DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/test");
	Connection con = dataSource.getConnection();
	// 进行数据的查找
	String sql = "SELECT * FROM t_user";
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if (rs.next()){
		out.println("Username: " + rs.getString("username"));
		out.println("<br/>Password: " + rs.getString("password"));
	}
	
	rs.close();
	stmt.close();
	con.close();
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