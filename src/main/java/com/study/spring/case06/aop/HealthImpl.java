package com.study.spring.case06.aop;

import org.springframework.stereotype.Component;

@Component
public class HealthImpl implements Health {

	@Override
	public Double getBMI(Double h, Double w) {
		double bmi = w / Math.pow(h/100, 2);
		return bmi;
	}
	
}
