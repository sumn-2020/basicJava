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

	
	public PatientVO findPatUser(String patId) {
		return template.queryForObject("SELECT PAT_CODE,\r\n"
				+ "      PAT_NAME,\r\n"
				+ "     PAT_ADDR,\r\n"
				+ "     PAT_PHONE,\r\n"
				+ "       PAT_ID, \r\n"
				+ "     PAT_PW\r\n"
				+ "  FROM PATIENT\r\n"
				+ " WHERE PAT_ID = ?\r\n", 
				new BeanPropertyRowMapper<>(PatientVO.class), patId);
	}


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
				+ " WHERE PAT_ID = ?",
				vo.getpatName(), vo.getpatId());
	}

	public int modifyAddress(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_ADDR = ?\r\n"
				+ " WHERE PAT_ID = ?",
				vo.getpatAddr(), vo.getpatId());
	}

	public int modifyPhone(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_PHONE = ?\r\n"
				+ " WHERE PAT_ID = ?",
				vo.getpatPhone(), vo.getpatId());
	}

	public int modifyPassword(PatientVO vo) {
		return template.update("UPDATE PATIENT\r\n"
				+ "   SET PAT_PW = ?\r\n"
				+ " WHERE PAT_ID = ?",
				vo.getpatPw(), vo.getpatId());
	}




}
