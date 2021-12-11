package com.study.spring.case06.proxy.dyn.jdk;

import java.lang.reflect.Method;
import java.util.Arrays;

// Aspect 切面程式
public class MyLogger {
	// 公用方法 (前置通知)
	public static void before(Method method, Object[] args) {
		// 查看參數
		System.out.println("前置通知(方法名稱):" + method.getName());
		System.out.println("前置通知(查看參數):" + Arrays.toString(args));
		System.out.println("前置通知: 紀錄 log 1");
	}

	// 公用方法 (後置通知)
	public static void end() {
		System.out.println("後置通知: 紀錄 log 2");
	}

	// 公用方法 (異常通知)
	public static void throwing(Exception e) {
		System.out.println("異常通知: 紀錄 error: " + e);
	}

}
