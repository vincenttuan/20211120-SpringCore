package case07;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.study.spring.case07.jdbc.Emp;

public class TestCreateEmp {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
	NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
	@Test
	public void test() {
		case1(); // 單筆新增
		//case2("Happy", 23); // 單筆新增
		//case3(); // 多筆新增
		//case4(); // 多筆新增
	}
	
	// 單筆新增 I
	private void case1() {
		String sql = "INSERT INTO emp(ename, age) VALUES(?, ?)";
		int row = jdbcTemplate.update(sql, "JoJo2", 21);
		System.out.println("Insert OK 1: " + row);
	}
	
	// 單筆新增 II
	private void case2(String ename, Integer age) {
		String sql = "INSERT INTO emp(ename, age) VALUES(:ename, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("ename", ename)
				.addValue("age", age);
		int row = namedParameterJdbcTemplate.update(sql, params);
		System.out.println("Insert OK 2: " + row);
	}
	
	// 多筆新增 I
	public void case3() {
		String sql = "INSERT INTO emp(ename, age) VALUES(?, ?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {"Jean", 22});
		list.add(new Object[] {"Anita", 23});
		list.add(new Object[] {"Jo", 24});
		int[] rows = jdbcTemplate.batchUpdate(sql, list);
		System.out.println("Batch insert 1: " + Arrays.toString(rows));
	}
	
	// 多筆新增 II
	public void case4() {
		String sql = "INSERT INTO emp(ename, age) VALUES(?, ?)";
		List<Emp> emps = Arrays.asList(
				new Emp("Bob", 30),
				new Emp("Alice", 40)
		);
		// Entity 的屬性 -> 資料表的欄位
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// i = emps 的 index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
			}

			@Override
			public int getBatchSize() {
				return emps.size();
			}
			
		};
		
		int[] rows = jdbcTemplate.batchUpdate(sql, setter);
		System.out.println("Batch insert 2: " + Arrays.toString(rows));
	}
	
	
	
	

}
