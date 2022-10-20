package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.LoginEntity;
import com.demo.service.LoginService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/getlogin")
	List<LoginEntity> getUsers(){
		List<LoginEntity> userList =  loginService.getUsers();
		return userList;
	}
	
	@PostMapping("/login")
	public LoginEntity createUser(@RequestBody LoginEntity loginEntity) {
		LoginEntity savedUser = loginService.save(loginEntity);
		return savedUser;
	}
}
