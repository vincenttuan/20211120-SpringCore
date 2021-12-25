package case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case06.aop_dancer.AOPConfig;
import com.study.spring.case06.aop_dancer.Actor;
import com.study.spring.case06.aop_dancer.Performance;
import com.study.spring.case06.aop_dancer.Singer;

public class TestDancer {
	public static void main(String[] args) {
		// 使用 Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		// 使用 XML 配置
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("aop-dancer.xml");
		Performance performance = ctx.getBean("dancer", Performance.class);
		// 觀眾-關手機
		// 觀眾-找座位
		// 觀眾-拍手鼓掌
		// 舞者表演

		try {
			performance.perform();
		} catch (Exception e) {
			// 觀眾-退票退票 (有表演錯誤發生)
			System.out.println(e);
			// 轉行: 舞者 -> 歌者
			Singer singer = (Singer) performance;
			singer.sing();
			// 轉行: 舞者 -> 演員
			Actor actor = (Actor) performance;
			actor.show();
		}

		// 觀眾-離開表演場地
	}
}
