package com.zr.jdbc.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class FileUploadUtil {
	/**
	 * 判断是否上使用上传文件的格式提交数据
	 * @param request
	 * @return
	 */
	public static boolean isMultipartContent(HttpServletRequest request){
		return ServletFileUpload.isMultipartContent(request);
	}
	
	public static Map<String, Object> processUploadFile(HttpServletRequest request, String path){
		List<String> list = new ArrayList<String>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8192);		// 磁盘缓冲
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 这里不设置文件大小限制，建议使用配置文件方式配置限制
		
		// Object指的是任意东西
		Map<String, Object> returnObject = new HashMap<>();
		try {
			List<FileItem> items = upload.parseRequest(request);	// 解释上传数据获取上传文件数据
			FileItem item;			// 保存一条上传的数据
			File newFilename;		// 保存文件时使用的新文件名
			Map<String, String> formFields = new HashMap<>();
			for (int i=0;i<items.size();i++){
				item = items.get(i);
				// 判断是否为上传文件
				if (!item.isFormField()){
					newFilename = new File(path + "/" + System.currentTimeMillis() + "");
					// 保存文件名，格式：原文件名,新文件名
					list.add(item.getName() + "," + newFilename.getName());
					item.write(newFilename);
					item.delete();
				}else{
					String name = item.getFieldName();// 获取标签的name属性的内容
					String value = item.getString();  // 获取标签的value属性的内容
					formFields.put(name, value);
				}
			}
			returnObject.put("formField", formFields);
			returnObject.put("filename", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnObject;
	}
}
