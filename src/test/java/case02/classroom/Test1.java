package case02.classroom;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.classroom.Student;
import com.study.spring.case02.classroom.Teacher;

public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext2.xml");
		
		Student[] students = {
				ctx.getBean("student1", Student.class),
				ctx.getBean("student2", Student.class),
				ctx.getBean("student3", Student.class),
		};
		
		Arrays.stream(students).forEach(System.out::println);
		
		Teacher teacher1 = ctx.getBean("teacher1", Teacher.class);
		System.out.println(teacher1);
	}
	
}
