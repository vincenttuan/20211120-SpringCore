package com.study.spring.case06.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 此物件透過掃描由 Spring 來管理
@Aspect // 切面程式
@Order(3) // 數字越小越先被執行(預設 order 的數值是 int 的最大值)
public class MyCheckAspect {
	// PointCut 切入點, 用來定義 JoinPoint 連接點
	// @Pointcut(value = "execution(* com.study.spring.case06.aop.*.*(..))")
	@Pointcut(value = "execution(* com.study.spring.case06.aop.HealthImpl.*(..))") // 切入點表達式
	public void pt() {
	}

	// 前置通知
	@Before(value = "pt()")
	public void before(JoinPoint joinPoint) {
		System.out.println("前置通知");
	}

	// 後置通知
	@After(value = "pt()")
	public void after(){
		System.out.println("後置通知");
	}
	
	// 返回通知 (可以設定 returning 來接收方法的回傳值)
	@AfterReturning(value = "pt()", returning = "result")
	public void afterReturning(Object result) {
		System.out.println("返回通知: " + result);
	}
	
	// 異常通知 (可以設定 throwing 的異常通知變數)
	@AfterThrowing(value = "pt()", throwing = "e")
	public void afterThrowing(Exception e) {
		System.out.println("異常通知: " + e);
	}
	
	
}
