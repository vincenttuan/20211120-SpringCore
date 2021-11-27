package com.study.spring.case01;

// 開燈/關燈
public class TurnOn {
	
	public TurnOn() {
		System.out.println("TurnOn 建構子: 我想要開燈");
	}
	
	public void init() {
		System.out.println("1. 買燈");
		System.out.println("2. 買燈泡");
		System.out.println("3. 插電");
	}
	
	public void play() {
		System.out.println("把燈開了");
	}
	
	public void destroy() {
		System.out.println("把燈關閉");
	}
	
}
