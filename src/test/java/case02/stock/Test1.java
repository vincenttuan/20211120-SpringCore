package case02.stock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.motor.Car;
import com.study.spring.case02.stock.MyStock;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext2.xml");
		MyStock myStock = (MyStock)ctx.getBean("myStock");
		System.out.println(myStock);
		
	}
	
}
