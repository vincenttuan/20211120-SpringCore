package case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case06.aopxml.Calc;
import com.study.spring.case06.aopxml.Worker;

public class TestAOPXML2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopxml-config.xml");
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.job();
	}

}
