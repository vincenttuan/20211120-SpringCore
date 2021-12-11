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
			
			try {
				// 公用方法 (前置通知)
				//System.out.println("前置通知: 紀錄 log 1");
				MyLogger.before(method, args);
				// 透過代理程式來影響商業邏輯的結果(使用上要小心)
				// 假設 method = "div" and args[1] = 0
				// 強迫回傳 0
				if(method.getName().equals("div") && 
						Integer.parseInt(args[1]+"") == 0) {
					return 0;
				}
				// 業務邏輯 (代理方法的呼叫)
				result = method.invoke(object, args);
				System.out.println(result);
			} catch (Exception e) {
				// 公用方法 (異常通知)
				//System.out.println("異常通知: 紀錄 error: " + e);
				MyLogger.throwing(e);
			} finally {
				// 公用方法 (後置通知)
				//System.out.println("後置通知: 紀錄 log 2");
				MyLogger.end();
			}
			
			return result;
		};
		// 4. 透過 Proxy.newProxyInstance 實現代理機制
		Object proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
