package lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.lab.RoundBean;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("beans-config.xml");
		RoundBean roundBean = ctx.getBean(RoundBean.class);
		System.out.println(roundBean.getRoundArea());
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
