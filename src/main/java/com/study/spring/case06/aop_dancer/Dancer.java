package com.study.spring.case06.aop_dancer;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Dancer implements Performance {

	@Override
	public void perform() {
		System.out.println("舞者開始表演, 跳舞, 轉圈, 翻滾...");
		if(new Date().getTime() % 3 == 0) {
			throw new RuntimeException("舞者跌倒");
		}
	}
	
}
