package com.study.spring.case06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(4)
public class ArgsAspect {
	@Pointcut(value = "execution(* com.study.spring.case06.aop.Rect.*(..))")
	public void pt() {}
	
	// 環繞通知
	@Around(value = "pt()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		
		try {
			
			//1. 前置通知
			System.out.println("環繞通知-前置通知");
			//2. 執行業務邏輯
			result = joinPoint.proceed();
			//3. 返回通知
			System.out.println("環繞通知-返回通知: " + result);
			
		} catch (Throwable e) {
			// 4. 異常通知
			System.out.println("環繞通知-異常通知: " + e);
			result = 0; // 改變回傳值
		} finally {
			// 5. 後置通知
			System.out.println("環繞通知-後置通知");
		}
		
		return result;
	} 
}
