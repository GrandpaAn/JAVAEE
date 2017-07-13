<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="homework-01Action.jsp" method="post" enctype="multipart/form-data">
	<div>上传文件：<input type="file" name="file"></div>
	<div>文件描述：<input type="text" name="description"/></div>
	<div><input type="submit" value="保存"/></div>
</form>
</body>
</html>