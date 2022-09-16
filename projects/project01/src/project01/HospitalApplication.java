package project01;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;


import oracle.jdbc.pool.OracleDataSource;
import project01.join.PatientVO;

public class HospitalApplication {

	private static PatientVO session = new PatientVO(); 
	private static JdbcTemplate template = new JdbcTemplate(); // db연동
	
	// controller에서 session보내기
	public static PatientVO getSession() {
		return session;
	}

	// init 화면 출력
	public static void main(String[] args) {
		new Home().initialize();
	}

	// db연동
	public static JdbcTemplate getTemplate() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe"); // db url
			dataSource.setUser("practice"); // 사용자
			dataSource.setPassword("java"); // 비번
			template.setDataSource(dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return template;
	}

}