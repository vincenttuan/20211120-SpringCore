package case02.pagers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.pagers.Pager;
import com.study.spring.case02.pagers.Pager2;
import com.study.spring.case02.pagers.Pager3;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext2.xml");
		
		Pager pager = ctx.getBean("pager", Pager.class);
		System.out.println(pager);
		
		Pager2 pager2 = ctx.getBean("pager2", Pager2.class);
		System.out.println(pager2);
		
		Pager3 pager3 = ctx.getBean("pager3", Pager3.class);
		System.out.println(pager3);
		
		((ClassPathXmlApplicationContext)ctx).close();
		
	}
	
}
