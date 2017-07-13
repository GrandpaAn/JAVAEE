<%@page import="org.apache.commons.io.FileUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="org.apache.commons.fileupload.disk.*"%>
<%@page import="org.apache.commons.fileupload.servlet.*"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List" %>

<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.io.*" %>

<%
	// 1. 设置获取的字符集编码
	request.setCharacterEncoding("UTF-8");
	// 2. 创建DiskFileItemFactory
	DiskFileItemFactory factory = new DiskFileItemFactory();
	// 3. 创建ServletFileUpload
	ServletFileUpload fileUpload = new ServletFileUpload(factory);
	// 4. 通过ServletFileUpload解释request提交上来的数据
	List<FileItem> fileItems = fileUpload.parseRequest(request);
	FileItem fileItem;
	for (int i=0;i<fileItems.size();i++){
		fileItem = fileItems.get(i);
		if (fileItem.isFormField()){ // 判断是不是普通的字段(不是文件)
			String name = fileItem.getFieldName();	// 标签里name的值 
			String value = fileItem.getString();	// 获取标签的内容
			out.println(name + ", " + value);
		}else{
			String name = fileItem.getName();		// 获取上传文件的文件名
			// 创建保存文件的新文件名
			// System.currentTimeMillis()			获取当前系统的毫秒数
			// System.currentTimeMillis() + ""		把数字转换为字符串
			String newFilename = System.currentTimeMillis() + "";
			// 保存文件
			// 创建文件的输出流
			File file = new File("e:/tmp/"+newFilename);
			//FileOutputStream fos = new FileOutputStream(file);
			//IOUtils.copy(fileItem.getInputStream(), fos);
			//fos.close();
			fileItem.write(file);
			// 把临时保存的上传文件删除
			fileItem.delete();
			
			//out.println(name);
		}
	}
	

%>