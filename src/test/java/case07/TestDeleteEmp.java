package case07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDeleteEmp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
		//將 eid = 1 的資料刪除
		Integer eid = 1;
		
		String sql = "DELETE FROM emp WHERE eid=?";
		int row = jdbcTemplate.update(sql, eid);
		System.out.println("DELETE OK: " + row);
		
	}

}
