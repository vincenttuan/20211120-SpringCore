package com.study.spring.case06.aop_dancer;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
	
	@Before("execution(* com.study.spring.case06.aop_dancer.Performance.perform(..))")
	public void slienceCellPhone() {
		System.out.println("觀眾-關手機");
	}
	
	@Before("execution(* com.study.spring.case06.aop_dancer.Performance.perform(..))")
	public void takeSeats() {
		System.out.println("觀眾-找到座位");
	}
	
	@AfterReturning("execution(* com.study.spring.case06.aop_dancer.Performance.perform(..))")
	public void applause() {
		System.out.println("觀眾-拍手鼓掌");
	}
	
	@AfterThrowing("execution(* com.study.spring.case06.aop_dancer.Performance.perform(..))")
	public void demandRefund() {
		System.out.println("觀眾-退票! 退票!");
	}
	
	@After("execution(* com.study.spring.case06.aop_dancer.Performance.perform(..))")
	public void exit() {
		System.out.println("觀眾-離開表演場!");
	}
}
