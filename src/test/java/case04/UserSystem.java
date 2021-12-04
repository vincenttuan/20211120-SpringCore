package case04;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case04.mvc.controller.UserController;
import com.study.spring.case04.mvc.entity.User;

public class UserSystem {
	
	private static UserController userController;
	static {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext4.xml");
		userController = ctx.getBean(UserController.class);
	}
	
	public static void menu() {
		while (true) {
			System.out.println("+---------------------+");
			System.out.println("| 1. 新增");
			System.out.println("| 2. 修改年齡");
			System.out.println("| 3. 刪除");
			System.out.println("| 4. 查詢全部");
			System.out.println("| 5. 查詢平均年齡");
			System.out.println("| 0. Exit");
			System.out.println("+---------------------+");
			System.out.print("請選擇: ");
			menuChoice();
			System.out.println("按下 Enter 後繼續...");
			new Scanner(System.in).nextLine();
		}
	}
	
	public static void menuChoice() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch (input) {
			case 1:
				add();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				queryUsers();
				break;
			case 5:
				printAverageAge();
				break;
			case 0:
				System.out.println("離開系統");
				System.exit(1);
		
		}
	}
	
	public static void add() {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入姓名: ");
		String name = sc.next();
		System.out.print("請輸入年齡: ");
		int age = sc.nextInt();
		User user = new User(name, age);
		userController.create(user);
	}
	
	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入姓名: ");
		String name = sc.next();
		Optional<User> opt = userController.getUser(name);
		if(opt.isPresent()) {
			User user = opt.get();
			System.out.println("+----------+----------+");
			System.out.println("|   name   |    age   |");
			System.out.println("+----------+----------+");
			System.out.println(String.format("|%-10s|%10d|", user.getName(), user.getAge()));
			System.out.println("+----------+----------+");
			System.out.print("請輸入欲修改的年齡: ");
			int newAge = sc.nextInt();
			user.setAge(newAge);
			userController.update(user);
		} else {
			System.out.println("此人不存在");
		}
	}
	
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入姓名: ");
		String name = sc.next();
		Optional<User> opt = userController.getUser(name);
		if(opt.isPresent()) {
			userController.delete(name);
		} else {
			System.out.println("此人不存在");
		}
	}
	
	public static void queryUsers() {
		List<User> users = userController.queryUsers();
		System.out.println("+----------+----------+");
		System.out.println("|   name   |    age   |");
		System.out.println("+----------+----------+");
		for(User user : users) {
			System.out.println(String.format("|%-10s|%10d|", user.getName(), user.getAge()));
			System.out.println("+----------+----------+");
		}
	}
	
	public static void printAverageAge() {
		System.out.printf("平均年齡 %.1f\n", userController.getAverageAge());
	}
	
	public static void main(String[] args) {
		menu();
	}
}
