package com.study.spring.case04.mvc.dao;

import java.util.List;
import java.util.Optional;

import com.study.spring.case04.mvc.entity.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(String name);
	List<User> queryUsers();
	Optional<User> getUser(String name);
}
