<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zr.jdbc.utils.*, java.util.*" %>

<%
	// 判断上传数据是否包含multipart/form-data，如果有使用FileUplaodUtil处理上传数据
	if (FileUploadUtil.isMultipartContent(request)){
		// 设置保存文件的路径
		// 1. 获取到前项目的根目录
		//String root = request.getServletContext().getRealPath("/");
		// 2. 设置图片最终的保存目录
		//String path = root + "/file_upload";
		
		// 或者可以直接通过getRealPath获取
		String path = request.getServletContext().getRealPath("/file_upload");
		
		// 使用FileUploadUtil工具解释并得到上传的数据（数据库会保存在一个Map里）
		Map<String, Object> map = FileUploadUtil.processUploadFile(request, path);
		// 获取上传的文件名
		List<String> filenames = (List<String>)map.get("filename");
		// 获取上传的普通数据
		Map<String, String> formFields = (Map<String, String>)map.get("formField");
		
		// 通过循环把所有的文件拼接在一起，通过,把文件分隔开来
		String filename = "";
		if (filenames.size()>0){
			filename = filenames.get(0);
		}
		for (int i=1;i<filenames.size();i++){
			filename = filename + "," + filenames.get(i);
		}
		
		// 生成SQL
		String sql = "INSERT INTO t_products(images, description) VALUES(?, ?)";
		Object[] params = {filename, formFields.get("description")};
		JdbcUtil.executeUpdate(sql, params);
		
		
		// 自动生成SQL语句
		/*String fields = "";
		String values = "";
		List<Object> params = new ArrayList<>();
		// 获取所有的键
		Set<String> keys = formFields.keySet();
		for (String key : keys){
			fields = fields + key + ",";
			values = values + "?,";
			params.add(formFields.get(key));	// 设置参数
		}
		// 把最后的,删除
		// substring 截取字符串
		// substring(开始位置, 结束位置)，字串会从开始的位置截取到结束位置-1的长度，
		// 例如:"abcdefgh".substring(0, 3)结果是abc
		// fields.length()-2，因为不需要最后一个逗号所以需要把字符串的长度减2
		//fields = fields.substring(0, fields.length()-2);
		//values = values.substring(0, values.length()-2);
		fields = fields + "images";
		values = values + "?";
		params.add(filename);
		
		String sql = "INSERT INTO t_product(" + fields + ") VALUES(" + values + ")";
		//out.print(sql);
		JdbcUtil.executeUpdate(sql, params.toArray());*/
		
	}
	// 如果没有使用request方式处理
	
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