package com.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.LoginEntity;
import com.demo.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	//Get list of user registrated
	@Override
	public List<LoginEntity> getUsers() {
		List<LoginEntity> loginList = loginRepository.findAll();
		return loginList;
	}

	// save/create a new user with hashed password
	@Override
	public LoginEntity save(LoginEntity loginEntity) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(loginEntity.getPassword().getBytes());
			byte[] resultByteArray = messageDigest.digest();
			StringBuilder stringB = new StringBuilder();
			
			for(byte b: resultByteArray) {
				stringB.append(String.format("%02", b));
			}
			String hashedPassword = stringB.toString();
			loginEntity.setPassword(hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm Exception...");
		}
		
		LoginEntity savedUser = loginRepository.save(loginEntity);
		return savedUser;
	}
	
	
//Valid if the user is registrated
	@Override
	public Boolean isValidUser(int loginId, String password) {
		
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			byte[] resultByteArray = messageDigest.digest();
			StringBuilder stringB = new StringBuilder();
			
			for(byte b : resultByteArray) {
			stringB.append(String.format("%02", b));
			}
			
			String hashedPassword = stringB.toString();
			// unhashed the password to verify existence 
			LoginEntity loginEntity = findByLoginIdAndPassword(loginId, hashedPassword);
			
			if(loginEntity != null) {
				return true;
			} else {
				return false;
			}
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm Exception...");
		}
		return false;
	}

@Override
public LoginEntity findByLoginIdAndPassword(int loginId, String password) {
	return loginRepository.findByLoginIdAndPassword(loginId, password);
}
	
	



}
