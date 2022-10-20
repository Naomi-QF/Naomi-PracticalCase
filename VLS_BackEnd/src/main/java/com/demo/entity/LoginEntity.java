package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN")
public class LoginEntity {

	//Columns created
	@Id
	@Column(name="LOGIN_ID", nullable = false)
	private int loginId;
	
	@Column(name="PASSWORD", nullable = false)
	private String password;

	//Constructor
	public LoginEntity() {
	
	}

	//Getters and setters
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//To string method
	@Override
	public String toString() {
		return "LoginEntity [loginId=" + loginId + ", password=" + password + "]";
	}
	
	
	
}
