package case02.motor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.motor.Car;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext2.xml");
		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car)ctx.getBean("car");
		System.out.println(car2);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
