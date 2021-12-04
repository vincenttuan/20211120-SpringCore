package com.study.spring.case04.mvc.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DBUtil {
	public static void writeObject(UserDB userDB) {
		try(FileOutputStream fos = new FileOutputStream("users.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(userDB);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static UserDB readObject() {
		// 先確認 users.db 是否存在 ?
		File file = new File("users.db");
		if(!file.exists()) {
			writeObject(new UserDB());
		}
		
		UserDB userDB = null;
		try(FileInputStream fis = new FileInputStream("users.db");
			ObjectInputStream ois = new ObjectInputStream(fis);) {
			userDB = (UserDB)ois.readObject();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return userDB;
	}
}
