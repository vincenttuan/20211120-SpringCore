package com.study.spring.case01;

public class Husband {
	private String name;
	private Wife wife;
	
	public Husband() {
		System.out.println("建立 Husband 物件");
	}
	
	public Husband(String name) {
		this.name = name;
		System.out.println("建立 Husband 物件");
	}
	
	public Husband(String name, Wife wife) {
		this.name = name;
		this.wife = wife;
		System.out.println("建立 Husband 物件");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "Husband [name=" + name + ", wife=" + wife.getName() + "]";
	}
	
	
	
}
