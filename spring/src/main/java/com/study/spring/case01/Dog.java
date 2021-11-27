package com.study.spring.case01;

public class Dog implements Animal {
	private String name;
	 
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printName() {
		System.out.println(name);
	}
}
