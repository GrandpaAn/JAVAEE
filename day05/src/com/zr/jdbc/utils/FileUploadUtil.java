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
	 * �ж��Ƿ���ʹ���ϴ��ļ��ĸ�ʽ�ύ����
	 * @param request
	 * @return
	 */
	public static boolean isMultipartContent(HttpServletRequest request){
		return ServletFileUpload.isMultipartContent(request);
	}
	
	public static List<String> processUploadFile(HttpServletRequest request, String path){
		List<String> list = new ArrayList<String>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8192);		// ���̻���
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		// ���ﲻ�����ļ���С���ƣ�����ʹ�������ļ���ʽ��������
		try {
			List<FileItem> items = upload.parseRequest(request);	// �����ϴ����ݻ�ȡ�ϴ��ļ�����
			FileItem item;			// ����һ���ϴ�������
			File newFilename;		// �����ļ�ʱʹ�õ����ļ���
			for (int i=0;i<items.size();i++){
				item = items.get(i);
				// �ж��Ƿ�Ϊ�ϴ��ļ�
				if (!item.isFormField()){
					newFilename = new File(path + "/" + System.currentTimeMillis() + "");
					// �����ļ�������ʽ��ԭ�ļ���,���ļ���
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
