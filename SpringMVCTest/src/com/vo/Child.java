package com.vo;

import org.hibernate.validator.constraints.NotBlank;

public class Child {
	
	@NotBlank(message="�û�������Ϊ��")
	private String username;
	@NotBlank(message="���벻��Ϊ��")
	private String password;
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
