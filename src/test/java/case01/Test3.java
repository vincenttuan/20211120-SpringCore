package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Lotto;

public class Test3 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		Lotto lotto = ctx.getBean("lotto", Lotto.class);
		System.out.println(lotto.getNumbers());
		
		Lotto lotto2 = ctx.getBean("lotto", Lotto.class);
		System.out.println(lotto2.getNumbers());
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
