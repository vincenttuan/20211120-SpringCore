package com.study.spring.case06.aop;

import org.springframework.stereotype.Component;

@Component
public class HealthImpl implements Health {

	@Override
	public Double getBMI(Double h, Double w) {
		if(w <= 0 || h <= 0) {
			throw new RuntimeException("輸入資料異常");
		}
		double bmi = w / Math.pow(h/100, 2);
		return bmi;
	}
	
}
