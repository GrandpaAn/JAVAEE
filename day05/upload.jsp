<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传 - 例子</title>
</head>
<body>
<!-- 
1. 把commons-fileupload-版本.jar和commons-io-版本.jar这两个复制到WEB-INF/lib目录下
2. 写文件上传的form表单内容，
		form必须添加enctype属性并把内容设为multipart/form-data
		上传文件必须把method设置为POST，如果是GET是无法上传文件

 -->
<form action="uploadAction.jsp" method="post" enctype="multipart/form-data">
	标题：<input type="text" name="title"/><br/> 
	文件：<input type="file" name="upfile"/><!-- 上传文件使用 --><br/>
	<input type="submit" value="保存"/>
</form>

</body>
</html>