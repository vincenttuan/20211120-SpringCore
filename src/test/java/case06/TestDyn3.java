package case06;

import org.springframework.cglib.proxy.Enhancer;

import com.study.spring.case06.proxy.dyn.cglib.EnhacnerMessage;
import com.study.spring.case06.proxy.dyn.cglib.Message;
import com.study.spring.case06.proxy.dyn.cglib.MyMethodInterceptor;

public class TestDyn3 {
	public static void main(String[] args) {
		// 透過子類別(增強)來代理
		Message message = new EnhacnerMessage();
		System.out.println(message.send("John"));
		System.out.println();
		
		// 使用 cglib
		Enhancer enhancer = new Enhancer(); // 增強器
		enhancer.setSuperclass(Message.class); // 目標
		enhancer.setCallback(new MyMethodInterceptor()); // 回呼並攔截
		
		Message message2 = (Message)enhancer.create();
		System.out.println(message2.send("Mary"));
	}
}
