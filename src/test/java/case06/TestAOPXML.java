package case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case06.aopxml.Calc;

public class TestAOPXML {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopxml-config.xml");
		Calc calc = ctx.getBean("calcImpl", Calc.class);
		System.out.println(calc.add(40, 20));
		System.out.println("-----------------------");
		System.out.println(calc.div(40, 20));

	}

}
