package com.zr.jdbc.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
	
	public static List<String> processUploadFile(HttpServletRequest request, String path){
		List<String> list = new ArrayList<String>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8192);		// 磁盘缓冲
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 这里不设置文件大小限制，建议使用配置文件方式配置限制
		try {
			List<FileItem> items = upload.parseRequest(request);	// 解释上传数据获取上传文件数据
			FileItem item;			// 保存一条上传的数据
			File newFilename;		// 保存文件时使用的新文件名
			for (int i=0;i<items.size();i++){
				item = items.get(i);
				// 判断是否为上传文件
				if (!item.isFormField()){
					newFilename = new File(path + "/" + System.currentTimeMillis() + "");
					// 保存文件名，格式：原文件名,新文件名
					list.add(item.getName() + "," + newFilename.getName());
					item.write(newFilename);
					item.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
