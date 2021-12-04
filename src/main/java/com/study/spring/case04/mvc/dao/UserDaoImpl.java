package com.study.spring.case04.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.spring.case04.mvc.db.UserDB;
import com.study.spring.case04.mvc.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private UserDB userDB = DBUtil.readJsonFile();
	
	public UserDaoImpl() {
		System.out.println("UserDaoImpl");
	}

	@Override
	public void add(User user) {
		userDB.save(user);
	}

	@Override
	public void update(User user) {
		userDB.update(user.getName(), user.getAge());
	}

	@Override
	public void delete(String name) {
		userDB.delete(name);
	}

	@Override
	public List<User> queryUsers() {
		return userDB.queryAll();
	}

	@Override
	public Optional<User> getUser(String name) {
		return userDB.get(name);
	}
}
