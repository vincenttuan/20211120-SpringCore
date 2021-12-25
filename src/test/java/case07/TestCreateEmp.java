package case07;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.study.spring.case07.jdbc.Emp;

public class TestCreateEmp {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
	
	@Test
	public void test() {
		case1(); // 單筆新增
	}
	
	// 單筆新增
	private void case1() {
		String sql = "INSERT INTO emp(ename, age) VALUES(?, ?)";
		jdbcTemplate.update(sql, "JoJo", 21);
		System.out.println("Insert OK 1");
	} 

}
