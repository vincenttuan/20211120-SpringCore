package com.study.spring.case04.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
}
