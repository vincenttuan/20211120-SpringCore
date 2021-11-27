package com.study.spring.case02.motor;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Car> {

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		car.setName("BMW");
		car.setPrice(200_0000 + new Random().nextInt(10_0000));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
	
	// 若與 <bean score="prototype|singleton"> 有衝突
	// 設定 prototype 權限 > singleton 權限
	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
