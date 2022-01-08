package case07;

import java.util.List;
import static java.util.stream.Collectors.toList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.study.spring.case07.jdbc.Emp;
import com.study.spring.case07.jdbc.Job;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;

public class TestReadEmpAndJob2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		// 請查出每個人的工作名稱為何 ?
		// 例如: mary -> [ 寫程式, 寫報告 ]
		//       bobo -> [ 倒茶水, 寫App ]
		String sql = "select e.eid, e.ename, e.age, e.createtime, "
				+ "j.jid as job_jid, j.jname as job_jname, j.eid as job_eid "
				+ "from emp e left outer join job j on j.eid = e.eid ";
		// j.jid as job_jid 這樣的命名原則 "job_jid" 是表示將 jid 的內容 是對應給 job 的資料表  
		
		ResultSetExtractor<List<Emp>> resultSetExtractor = 
				JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid")
				.newResultSetExtractor(Emp.class);
		
		List<Emp> emps = jdbcTemplate.query(sql, resultSetExtractor);
		
		for(Emp emp : emps) {
			System.out.printf("%s %s\n", 
							emp.getEname(),
							emp.getJobs().stream().map(Job::getJname).collect(toList()));
		}
	}
}
