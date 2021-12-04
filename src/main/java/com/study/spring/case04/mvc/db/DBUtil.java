package com.study.spring.case04.mvc.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.google.gson.Gson;

public class DBUtil {

	public static void writeJsonFile(UserDB userDB) {
		// 將 userDB 轉為 json 字串
		String json = new Gson().toJson(userDB);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.json"))) {
			writer.write(json); // 將 json 字串寫入
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static UserDB readJsonFile() {
		// 先確認 users.json 是否存在 ?
		File file = new File("users.json");
		if (!file.exists()) {
			writeJsonFile(new UserDB());
		}
		
		UserDB userDB = null;
		try(BufferedReader reader = new BufferedReader(new FileReader("users.json"))) {
			String json = reader.readLine(); // 取得 json 字串
			userDB = new Gson().fromJson(json, UserDB.class); // 將 json 字串透過 Gson 轉為 UserDB 物件
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDB;
	}
	
	//----------------------------------------------------------------------------------------
	
	public static void writeObject(UserDB userDB) {
		try (FileOutputStream fos = new FileOutputStream("users.db");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(userDB);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static UserDB readObject() {
		// 先確認 users.db 是否存在 ?
		File file = new File("users.db");
		if (!file.exists()) {
			writeObject(new UserDB());
		}

		UserDB userDB = null;
		try (FileInputStream fis = new FileInputStream("users.db");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			userDB = (UserDB) ois.readObject();

		} catch (Exception e) {
			System.out.println(e);
		}
		return userDB;
	}
}
