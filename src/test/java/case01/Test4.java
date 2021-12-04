package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Book;

public class Test4 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		Book b1 = ctx.getBean("book", Book.class);
		System.out.println(b1);
		
		Book b2 = ctx.getBean("book2", Book.class);
		System.out.println(b2);
		
		Book b3 = ctx.getBean("book3", Book.class);
		System.out.println(b3);
		
		Book b4 = ctx.getBean("book4", Book.class);
		System.out.println(b4);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
