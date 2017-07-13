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
	 * �ж��Ƿ���ʹ���ϴ��ļ��ĸ�ʽ�ύ����
	 * @param request
	 * @return
	 */
	public static boolean isMultipartContent(HttpServletRequest request){
		return ServletFileUpload.isMultipartContent(request);
	}
	
	public static Map<String, Object> processUploadFile(HttpServletRequest request, String path){
		List<String> list = new ArrayList<String>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8192);		// ���̻���
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		// ���ﲻ�����ļ���С���ƣ�����ʹ�������ļ���ʽ��������
		
		// Objectָ�������ⶫ��
		Map<String, Object> returnObject = new HashMap<>();
		try {
			List<FileItem> items = upload.parseRequest(request);	// �����ϴ����ݻ�ȡ�ϴ��ļ�����
			FileItem item;			// ����һ���ϴ�������
			File newFilename;		// �����ļ�ʱʹ�õ����ļ���
			Map<String, String> formFields = new HashMap<>();
			for (int i=0;i<items.size();i++){
				item = items.get(i);
				// �ж��Ƿ�Ϊ�ϴ��ļ�
				if (!item.isFormField()){
					newFilename = new File(path + "/" + System.currentTimeMillis() + "");
					// �����ļ�������ʽ��ԭ�ļ���,���ļ���
					list.add(item.getName() + "," + newFilename.getName());
					item.write(newFilename);
					item.delete();
				}else{
					String name = item.getFieldName();// ��ȡ��ǩ��name���Ե�����
					String value = item.getString();  // ��ȡ��ǩ��value���Ե�����
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
