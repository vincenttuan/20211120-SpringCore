package case03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case03.Cash;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext3.xml");
		Cash cash = ctx.getBean("cash", Cash.class);
		System.out.println(cash);
		
		Cash cash2 = ctx.getBean("cash2", Cash.class);
		System.out.println(cash2);
		
	}
	
}
