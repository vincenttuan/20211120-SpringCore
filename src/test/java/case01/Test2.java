package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Author;

public class Test2 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		//Author a1 = ctx.getBean(Author.class); // 只能用在配置檔中針對只有"一"個該類別的設定
		//System.out.println(a1);
		
		Author a = ctx.getBean("author", Author.class);
		a.setName("John");
		a.setSex('M');
		a.setAge(20);
		System.out.println(a);
		
		Author a2 = (Author)ctx.getBean("author2");
		System.out.println(a2);
		
		Author a3 = ctx.getBean("author3", Author.class);
		System.out.println(a3);
		
		Author a4 = ctx.getBean("author4", Author.class);
		System.out.println(a4);
		
		Author a5 = ctx.getBean("author5", Author.class);
		System.out.println(a5);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
