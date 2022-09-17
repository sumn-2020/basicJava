package project01.join;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import project01.HospitalApplication;


public class JoinDAO {
	
	//싱글톤
	private static JoinDAO instance = new JoinDAO();
	private JoinDAO() {}
	public static JoinDAO getInstance() {
		return instance;
	}
	
	//jdbc템플릿을 이용한 쿼리문 불러오기
	private JdbcTemplate template = HospitalApplication.getTemplate();
	
	//*** 쿼리문 ***
	//아이디 찾기 
	public PatientVO findPatient(int patId) {
		return template.queryForObject("SELECT DOC_CODE,\r\n"
				+ "       DOC_NAME,\r\n"
				+ "       DEPT_CODE,\r\n"
				+ "       DOC_OFF,\r\n"
				+ "       DOC_LOCATION,\r\n"
				+ "       DOC_ID,\r\n"
				+ "       DOC_PW\r\n"
				+ "  FROM DOCTOR\r\n"
				+ " WHERE DOC_ID = ? ", new BeanPropertyRowMapper<>(PatientVO.class), patId);
	}
	
	//입력된 정보 환자테이블에 추가 
	public int join(PatientVO vo) {
		return template.update("INSERT INTO PATIENT (\r\n"
				+ "    PAT_CODE,\r\n"
				+ "    PAT_NAME,\r\n"
				+ "    PAT_ADDR,\r\n"
				+ "    PAT_PHONE,\r\n"
				+ "    PAT_REG,\r\n"
				+ "    PAT_ID,\r\n"
				+ "    PAT_PW\r\n"
				+ ") VALUES (\r\n"
				+ "    (SELECT 'P'||TO_CHAR(SUBSTR(MAX(PAT_CODE),2,3)+1) FROM PATIENT),\r\n"
				+ "     ?,     \r\n"
				+ "     ?,     \r\n"
				+ "     ?,     \r\n"
				+ "     ?,     \r\n"
				+ "     ?,     \r\n"
				+ "     ?      \r\n"
				+ ") ", vo.getPatName(), vo.getPatAddr(), vo.getPatId(), vo.getPatPhone(), vo.getPatPw());
	}
	
	
	
	
	
	
	

}
