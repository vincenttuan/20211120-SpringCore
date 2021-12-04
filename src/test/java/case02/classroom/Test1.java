package case02.classroom;

import java.util.Arrays;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

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
		
		// 求出指定學生的總學分
		Student student1 = ctx.getBean("student1", Student.class);
		int sum = student1.getClazzs()
			.stream()
			.mapToInt(c -> c.getCredit())
			//.peek(System.out::println)
			.sum();
		System.out.println("sum = " +sum);
		// 將上述邏輯寫成一個Function
		ToIntFunction<Student> func1 = (s) -> s.getClazzs().stream().mapToInt(c -> c.getCredit()).sum();
		// 學生所選的科目平均每一科的平均
		ToDoubleFunction<Student> func2 = (s) -> s.getClazzs().stream().mapToInt(c -> c.getCredit()).average().getAsDouble();
		// teacher1 也就是 Bob 這位老師
		// 他旗下所學生的總學分為何 ?
		// 例如: 若 John 的總學分為 4(3+1), Helen 得總學分為 6(3+2+1)
		// 則總學分為 10
		int total = teacher1.getStudents().stream().mapToInt(func1).sum();
		System.out.println("Total = " + total);
		double avg = teacher1.getStudents().stream().mapToDouble(func2)
				.average().getAsDouble();
		System.out.println("Avg = " + avg);
		//---------------------------------------------------------------------
		int total2 = teacher1.getStudents().stream()
					.mapToInt(s -> s.getTotalCredits())
					.sum();
		System.out.println("Total2 = " + total2);
		//---------------------------------------------------------------------
		int total3 = teacher1.getTotalByStudentCredit();
		System.out.println("Total3 = " + total3);
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
