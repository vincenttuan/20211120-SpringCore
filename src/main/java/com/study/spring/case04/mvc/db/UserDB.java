package com.study.spring.case04.mvc.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.study.spring.case04.mvc.entity.User;

public class UserDB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	
	public void save(User user) {
		if(users == null) {
			users = new ArrayList<>();
		}
		users.add(user);
		DBUtil.writeObject(this);
	}
	
	public List<User> queryAll() {
		return users;
	}
	
	// 測試
	public static void main(String[] args) {
		UserDB userDB = DBUtil.readObject();
		userDB.save(new User("Bobo", 25));
		System.out.println(userDB.users);
	}
	
}
