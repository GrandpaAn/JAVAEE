package com.zr.jdbc.entity;

public class User {
	// Integer是int的包装类，等同于int并提供了一些额外的行为，例如获取int的最大(小)值等

	/*
	 * 以下内容称作为属性，对应表里的每一个字段，变量名可以跟字段名不一致
	 */
	private Integer id;
	private String username;
	private String password;
	private String sex;
	private Integer age;

	/*
	 * 提供get/set方法对上面的属性进行（获取/设置） 1. 同时按Shift+Alt，再按s，就会打开一个对话框 2.
	 * 在对话框时选择Generate Getters adn Setters... 3. 在新的对话框中根据需求选择Select All(Select
	 * Getters/Select Setters) 4. 点OK完成
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
