package com.zr.jdbc.entity;

public class User {
	// Integer��int�İ�װ�࣬��ͬ��int���ṩ��һЩ�������Ϊ�������ȡint�����(С)ֵ��
	
	/*
	 * �������ݳ���Ϊ���ԣ���Ӧ�����ÿһ���ֶΣ����������Ը��ֶ�����һ��
	 */
	private Integer id;
	private String username;
	private String password;
	
	/*
	 * �ṩget/set��������������Խ��У���ȡ/���ã�
	 * 1. ͬʱ��Shift+Alt���ٰ�s���ͻ��һ���Ի���
	 * 2. �ڶԻ���ʱѡ��Generate Getters adn Setters...
	 * 3. ���µĶԻ����и�������ѡ��Select All(Select Getters/Select Setters)
	 * 4. ��OK���
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
