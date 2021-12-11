package case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case06.aop.Area;

public class TestAOP2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Area area = ctx.getBean("rect", Area.class);
		System.out.println(area.getValue(10, 20));
		System.out.println(area.getValue(10, -20));
	}

}
