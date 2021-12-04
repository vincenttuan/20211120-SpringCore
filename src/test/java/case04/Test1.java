package case04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext4.xml");
		
		UserController userController = ctx.getBean(UserController.class);
		System.out.println(userController);
		userController.create(new User("John", 20));
		System.out.println(userController.queryUsers());
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
