package com.study.spring.case06.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class MyLoggerAspect {
	
	// 前置通知
	// JoinPoint 連接點
	public void before(JoinPoint joinpoint) {
		System.out.println("AOP XML 版 - 前置通知");
		System.out.println("方法:" + joinpoint.getSignature().getName());
		System.out.println("參數:" + Arrays.toString(joinpoint.getArgs()));
	}
	
}
