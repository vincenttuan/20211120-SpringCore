package case07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestUpdateEmp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
		//將 eid = 1 的 ename = "Cake", age = 21
		Integer eid = 1;
		String ename = "Cake";
		Integer age = 21;
		
		String sql = "UPDATE emp SET ename=?, age=? WHERE eid=?";
		int row = jdbcTemplate.update(sql, ename, age, eid);
		System.out.println("Update OK: " + row);
		
	}

}
