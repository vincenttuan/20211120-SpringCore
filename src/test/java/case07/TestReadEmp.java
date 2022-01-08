package case07;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.study.spring.case07.jdbc.Emp;

public class TestReadEmp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		
		// 多筆查詢 1
		String sql = "SELECT eid, ename, age, createtime FROM emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		System.out.println(emps);
		
		// 多筆查詢 2
		List<Emp> emps2 = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Integer eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			Integer age = rs.getInt("age");
			Date createtime = rs.getTimestamp("createtime");
			
			Emp emp = new Emp();
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setAge(age);
			emp.setCreatetime(createtime);
			return emp;
		});
		System.out.println(emps2);
		
		// 多筆查詢 3
		List<Emp> emps3 = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		System.out.println(emps3);
		
		// 單筆查詢 使用 queryForObject
		// 上課同學自行練習
		// 例如: 查詢 int eid = 2;
		sql = "SELECT eid, ename, age, createtime FROM emp WHERE eid=?";
		Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), 2);
		System.out.println(emp);
		sql = "SELECT ename FROM emp WHERE eid=?";
		String ename = jdbcTemplate.queryForObject(sql, String.class, 2);
		System.out.println(ename);
		
		// 資料筆數
		sql = "SELECT count(*) FROM emp";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("資料筆數:" + count);
		
	}

}
