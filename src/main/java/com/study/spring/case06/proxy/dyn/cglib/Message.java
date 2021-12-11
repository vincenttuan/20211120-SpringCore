package com.study.spring.case06.proxy.dyn.cglib;

public class Message {
	public String send(String msg) { // 方法簽章(規格)
		return "Hello " + msg;
	}
}
