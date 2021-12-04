package case01;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case01.Dog;
import com.study.spring.case01.Cat;
import com.study.spring.case01.Animal;

public class Test6 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
		Animal[] animals = {
				ctx.getBean("dog", Dog.class),
				ctx.getBean("dog2", Dog.class),
				ctx.getBean(Cat.class)
		};
		
		Arrays.stream(animals).forEach(Animal::printName);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
