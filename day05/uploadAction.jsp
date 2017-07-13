<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.zr.jdbc.utils.*, java.util.*"%>

<%
	// 判断是否为上传文件
	if(FileUploadUtil.isMultipartContent(request)){
		// 获取当前项目的根目录
		String root = request.getServletContext().getRealPath("/");
		// 需要先在WebContent目录下创建upload_files目录
		String path = root + "upload_files";
		
		// 把文件保存到指定的目录下，并获取原文件名和新文件名
		List<String> list = FileUploadUtil.processUploadFile(request, path);
		String s = list.get(0);
		String[] ary = s.split(","); // 根据,（逗号）把字符串拆分成一个数组
		out.println("原文件名是：" + ary[0]);
		out.println("新文件名是：" + ary[1]);
	}
%>