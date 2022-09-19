package hospital.patSign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;
import hospital.join.PatientVO;

public class PatSignDAO {
	private static PatSignDAO instance = new PatSignDAO();
	public static PatSignDAO getInstance() {
		return instance;
	}
	
	private PatSignDAO() {}
	
	private JdbcTemplate template = HospitalApplication.getTemplate();
	
	public PatientVO findPatient(PatientVO vo) {
		try {
			return template.queryForObject("\r\n"
					+ "SELECT PAT_CODE,\r\n"
					+ "       PAT_NAME,\r\n"
					+ "       PAT_ADDR,\r\n"
					+ "       PAT_PHONE,\r\n"
					+ "       PAT_REG,\r\n"
					+ "       PAT_ID,\r\n"
					+ "       PAT_PW\r\n"
					+ "  FROM PATIENT\r\n"
					+ " WHERE PAT_ID = ?\r\n"
					+ "   AND PAT_PW = ?", new BeanPropertyRowMapper<>(PatientVO.class), vo.getpatId(), vo.getpatPw());
		} catch (DataAccessException e) {
			return null;
		}
	}
}
