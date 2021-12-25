package case07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TestCreateEmp {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
	@Test
	public void test() {
		//case1(); // 單筆新增
		case2("Happy", 23); // 單筆新增
	}
	
	// 單筆新增 I
	private void case1() {
		String sql = "INSERT INTO emp(ename, age) VALUES(?, ?)";
		jdbcTemplate.update(sql, "JoJo2", 21);
		System.out.println("Insert OK 1");
	}
	
	// 單筆新增 II
	private void case2(String ename, Integer age) {
		String sql = "INSERT INTO emp(ename, age) VALUES(:ename, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("ename", ename)
				.addValue("age", age);
		namedParameterJdbcTemplate.update(sql, params);
		System.out.println("Insert OK 2");
	}
	
	
	
	
	

}
