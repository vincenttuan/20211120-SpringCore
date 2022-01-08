package case07;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.study.spring.case07.jdbc.Job;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;

public class TestReadEmpAndJob3 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		// 請查出每個工作的人名為何 ?
		// 例如: 寫程式 -> mary
		//      寫報告 -> mary
		//      倒茶水 -> bobo
		//      寫App -> bobo
		// 提示: 將 Job.java 加入 private Emp emp; 屬性
		String sql = "select j.jid, j.jname, j.eid, "
				+ "e.eid as emp_eid, e.ename as emp_ename, e.age as emp_age, e.createtime as emp_createtime "
				+ "from job j left outer join emp e on e.eid = j.eid";
		
		ResultSetExtractor<List<Job>> resultSetExtractor = 
				JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid")
				.newResultSetExtractor(Job.class);
		
		List<Job> jobs = jdbcTemplate.query(sql, resultSetExtractor);
		System.out.println(jobs);
		
	}
}
