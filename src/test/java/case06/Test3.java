package case06;

import java.util.Scanner;

import com.study.spring.case06.proxy.sta.Man;
import com.study.spring.case06.proxy.sta.Person;
import com.study.spring.case06.proxy.sta.PersonProxy;
import com.study.spring.case06.proxy.sta.Woman;

public class Test3 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入類別名稱: ");
		String className = scanner.next();
		// 直接給類別名稱來產生指定物件
		Person p1 = new PersonProxy(className);
		p1.work();
		
	}
}
