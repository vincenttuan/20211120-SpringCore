package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.TurnOn;

public class Test7 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		TurnOn turnOn = ctx.getBean(TurnOn.class);
		turnOn.play();
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
