package project01.join;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import project01.HospitalApplication;
import project01.common.PatientVO;


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
	public PatientVO findPatient(String patId) {
		return template.queryForObject("SELECT PAT_CODE,\r\n"
				+ "       PAT_NAME,\r\n"
				+ "       PAT_ADDR,\r\n"
				+ "       PAT_PHONE,\r\n"
				+ "       PAT_REG,\r\n"
				+ "       PAT_ID,\r\n"
				+ "       PAT_PW\r\n"
				+ "  FROM PATIENT\r\n"
				+ " WHERE PAT_ID = ? \r\n ", new BeanPropertyRowMapper<>(PatientVO.class), patId);
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
				+ ") ", vo.getPatName(), vo.getPatAddr(), vo.getPatPhone(), vo.getPatReg(), vo.getPatId(),  vo.getPatPw());
	}
	
	//주소수정 
	public int modifyAddress(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_ADDR = ? \r\n"
				+ " WHERE PAT_CODE = ? ", vo.getPatAddr(), vo.getPatCode());
	}
		
	//폰번호수정
	public int modifyPhone(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_PHONE = ? \r\n"
				+ " WHERE PAT_CODE = ? ", vo.getPatPhone(), vo.getPatCode());
	}
	
	//폰번호수정
	public int modifyPassword(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_PHONE = ? \r\n"
				+ " WHERE PAT_CODE = ? ", vo.getPatPhone(), vo.getPatCode());
	}
	
	
	
	

}
