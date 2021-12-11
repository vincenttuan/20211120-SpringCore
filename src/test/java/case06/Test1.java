package case06;

import com.study.spring.case06.proxy.sta.Man;
import com.study.spring.case06.proxy.sta.Person;
import com.study.spring.case06.proxy.sta.Woman;

public class Test1 {
	public static void main(String[] args) {
		Person p1 = new Man();
		Person p2 = new Woman();
		p1.work();
		p2.work();
	}
}
