package case07.jdbc;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import static java.util.stream.Collectors.toList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.spring.case07.jdbc.Emp;
import com.study.spring.case07.jdbc.Job;

public class TestReadEmpAndJob {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		// 請查出每個人的工作名稱為何 ?
		// 例如: mary -> [ 寫程式, 寫報告 ]
		//       bobo -> [ 倒茶水, 寫App ]
		String sql = "SELECT eid, ename, age, createtime FROM emp";
		List<Emp> emps = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Integer eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			Integer age = rs.getInt("age");
			Date createtime = rs.getTimestamp("createtime");
			
			Emp emp = new Emp();
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setAge(age);
			emp.setCreatetime(createtime);
			
			String sql2 = "SELECT jid, jname, eid FROM job where eid = ?";
			List<Job> jobs = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(Job.class), eid);
			emp.setJobs(jobs);
			return emp;
		});
		for(Emp emp : emps) {
			System.out.printf("%s %s\n", 
							emp.getEname(),
							emp.getJobs().stream().map(Job::getJname).collect(toList()));
		}
	}
}
