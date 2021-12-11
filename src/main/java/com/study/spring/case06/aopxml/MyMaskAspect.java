package com.study.spring.case06.aopxml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyMaskAspect {
	
	public void before(JoinPoint joinpoint) {
		System.out.println("before 戴上口罩");
	}
	
	public void end(JoinPoint joinpoint) {
		System.out.println("end 結束");
	}
}
