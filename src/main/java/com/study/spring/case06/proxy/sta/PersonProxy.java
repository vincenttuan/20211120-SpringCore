package com.study.spring.case06.proxy.sta;

public class PersonProxy implements Person {
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	public PersonProxy(String className) throws Exception {
		// 要給類別全名: 套件名 + 類別名
		String fullName = "com.study.spring.case06.proxy.sta." + className;
		//this.person = (Person)Class.forName(fullName).newInstance();
		this.person = (Person)Class.forName(fullName) // 類別全名
								   .getDeclaredConstructor() // 調用建構子
								   .newInstance(); // 建立實體(例)
	}
	
	@Override
	public void work() {
		// 1.公用方法
		System.out.println("戴口罩 (proxy)");
		System.out.println("戴錢包 (proxy)");
		System.out.println(person.getClass().getSimpleName());
		// 2.執行業務方法
		person.work();
	}
	
}
