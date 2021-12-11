package case06;

import com.study.spring.case06.proxy.dyn.jdk.Calc;
import com.study.spring.case06.proxy.dyn.jdk.CalcImpl;
import com.study.spring.case06.proxy.dyn.jdk.ProxyUtil;
import com.study.spring.case06.proxy.sta.Man;
import com.study.spring.case06.proxy.sta.Person;

public class TestDyn1 {
	public static void main(String[] args) {
		//Calc ca = new CalcImpl();
		//System.out.println(ca.add(10, 20));
		
		Calc calc = (Calc)new ProxyUtil(new CalcImpl()).getProxy();
		int sum = calc.add(10, 20);
		System.out.println("sum=" + sum);
		
		Person person = (Person)new ProxyUtil(new Man()).getProxy();
		person.work();
		
	}
}
