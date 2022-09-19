package hospital.join;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import hospital.HospitalApplication;

public class JoinDAO {
	private static JoinDAO instance = new JoinDAO();
	public static JoinDAO getInstance() {
		return instance;
	}
	private JoinDAO() {}
	
	private JdbcTemplate template = HospitalApplication.getTemplate();
	
//	public PatientVO findPatient(String code) {
//		return template.queryForObject("SELECT PAT_CODE, PATNAME, PAT_ADDR, PAT_PHONE, PAT_REG, PAT_ID, PAT_PW, PAT_HIREDATE FROM PATIENT WHERE PAT_ID = ?", new BeanPropertyRowMapper<>(PatientVO.class), code);
//	}
	
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
				+ "     ?,\r\n"
				+ "     ?,\r\n"
				+ "     ?,\r\n"
				+ "     ?, \r\n"
				+ "     ?,\r\n"
				+ "     ? \r\n"
				+ ")", vo.getpatName(), vo.getpatAddr(), vo.getpatPhone(), vo.getpatReg(), vo.getpatId(), vo.getpatPw());
	}
	
	public int modifyName(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_NAME = ?\r\n"
				+ " WHERE PAT_CODE = ?",
				vo.getpatName(), vo.getpatId());
	}
	
	
}
