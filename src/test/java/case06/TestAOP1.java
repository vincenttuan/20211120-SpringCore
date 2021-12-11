package case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case06.aop.Health;
import com.study.spring.case06.aopxml.Calc;
import com.study.spring.case06.aopxml.Worker;

public class TestAOP1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Health health = ctx.getBean("healthImpl", Health.class);
		System.out.println(health.getBMI(170.0, 60.0));
	}

}
