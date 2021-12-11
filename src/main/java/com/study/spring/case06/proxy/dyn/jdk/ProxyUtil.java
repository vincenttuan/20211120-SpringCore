package com.study.spring.case06.proxy.dyn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
	private Object object;
	
	public ProxyUtil(Object object) {
		this.object = object;
	}
	
	public Object getProxy() {
		// 1. 類別載入器
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 目標所實作的介面
		Class[] interfaces = object.getClass().getInterfaces(); 
		// 3. 處理代理的實現
		// 介面: Interface InvocationHandler
		// 方法: Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
		InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
			Object result = null;
			// 公用方法
			System.out.println("紀錄 log 1");
			// 業務邏輯 (代理方法的呼叫)
			result = method.invoke(object, args);
			
			return result;
		};
		// 4. 透過 Proxy.newProxyInstance 實現代理機制
		Object proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
