package case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Husband;
import com.study.spring.case01.Wife;

public class Test5 {
	
	public static void main(String[] args) {
		// 載入配置檔會將所有的 <bean scope="singleton"> 標籤內容實例化, 不論程式碼是否有用到
		// <bean scope="prototype"> 則不會預先實例化
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		Husband h1 = ctx.getBean("husband", Husband.class);
		System.out.println(h1);
		
		Wife w1 = ctx.getBean("wife", Wife.class);
		System.out.println(w1);
		
		Husband h2 = ctx.getBean("husband2", Husband.class);
		System.out.println(h2);
		
		Wife w2 = ctx.getBean("wife2", Wife.class);
		System.out.println(w2);
		
		System.out.println(h1.getName());
		System.out.println(h1.getWife().getHusband().getName());
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
