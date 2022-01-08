package case07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestReadEmpAndJob {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		// 請查出每個人的工作名稱為何 ?
		// 例如: mary -> [ 寫程式, 寫報告 ]
		//       bobo -> [ 倒茶水, 寫App ]
		
	}
}
