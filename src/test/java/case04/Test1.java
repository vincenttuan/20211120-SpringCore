package case04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext4.xml");
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
