package hospital;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.join.AdminVO;
import hospital.join.DoctorVO;
import hospital.join.PatientVO;
import hospital.notice.NoticeVO;
import oracle.jdbc.pool.OracleDataSource;


public class HospitalApplication {
	private static PatientVO session = new PatientVO();
	private static DoctorVO session2 = new DoctorVO();
	private static AdminVO session3 = new AdminVO();
	private static NoticeVO session4 = new NoticeVO();
	private static JdbcTemplate template = new JdbcTemplate();
	
	public static void main(String[] args) {
		new Home().initalize();
	}
	
	public static PatientVO getSession() {
		return session;
	}
	
	public static DoctorVO getSession2() {
		return session2;
	}
	
	public static AdminVO getSession3() {
		return session3;
	}
	
	public static NoticeVO getSession4() {
		return session4;
	}

	public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            dataSource.setUser("practice");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return template;
	}
		
}
