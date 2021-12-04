package com.study.spring.case04.mvc.service;

import java.util.List;
import java.util.Optional;

import com.study.spring.case04.mvc.entity.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(String name);
	List<User> queryUsers();
	List<User> queryUsers(int minAge, int maxAge);
	Optional<User> getUser(String name);
	double getAverageAge(); // 平均年齡 
}
