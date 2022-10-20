package com.demo.service;

import java.util.List;

import com.demo.entity.LoginEntity;

public interface LoginService{
	
	public List<LoginEntity> getUsers();
	
	LoginEntity save(LoginEntity loginEntity);
	
	Boolean isValidUser(int loginId, String password);
	
	LoginEntity findByLoginIdAndPassword(int loginId, String password);
	
	
}
