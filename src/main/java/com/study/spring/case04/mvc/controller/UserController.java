package com.study.spring.case04.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.case04.mvc.entity.User;
import com.study.spring.case04.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("UserController");
	}
	
	public void create(User user) {
		userService.add(user);
	}
	
	public List<User> queryUsers() {
		return userService.queryUsers();
	}
	
}
