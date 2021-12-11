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
		// 建議使用 openjdk 1.8
		// 下載位置: https://github.com/ojdkbuild/ojdkbuild
		// 變更 eclipse jre 路徑: Window > Preferences > Java > Installed JREs (按下Edit) 變更  Location 路徑 為
		// C:\Program Files\ojdkbuild\java-1.8.0-openjdk-1.8.0.232-1\jre
		
		Enhancer enhancer = new Enhancer(); // 增強器
		enhancer.setSuperclass(Message.class); // 目標
		enhancer.setCallback(new MyMethodInterceptor()); // 回呼並攔截
		
		Message message2 = (Message)enhancer.create();
		System.out.println(message2.send("Mary"));
	}
}
