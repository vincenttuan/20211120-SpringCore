package com.study.spring.case04.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.case04.mvc.dao.UserDao;
import com.study.spring.case04.mvc.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}

	@Override
	public void add(User user) {
		if(user != null) {
			Optional<User> opt = getUser(user.getName());
			if(opt != null && opt.isPresent()) { // 是否有同名?
				System.out.println(user.getName() + " 已存在");
			} else {
				userDao.add(user);
			}
		}
	}

	@Override
	public void update(User user) {
		if(user != null) {
			userDao.update(user);
		}
	}

	@Override
	public void delete(String name) {
		if(name != null) {
			userDao.delete(name);
		}
	}

	@Override
	public List<User> queryUsers() {
		return userDao.queryUsers();
	}

	@Override
	public List<User> queryUsers(int minAge, int maxAge) {
		return userDao.queryUsers().stream()
				.filter(u -> u.getAge() >= minAge && u.getAge() <= maxAge)
				.toList();
	}

	@Override
	public Optional<User> getUser(String name) {
		if(name == null) {
			return null;
		}
		return userDao.getUser(name);
	}

	@Override
	public double getAverageAge() {
		return userDao.queryUsers().stream().mapToInt(User::getAge).average().getAsDouble();
	}
}
