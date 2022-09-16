package project01.sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import project01.HospitalApplication;
import project01.join.PatientVO;

public class SignDAO {
	
	//싱글톤
	private static SignDAO instance = new SignDAO();
	private SignDAO() {}
	public static SignDAO getInstance() {
		return instance;
	}
	
	//HospitalApplication에 있는 db 접속 정보 가져오기 
	private JdbcTemplate template = HospitalApplication.getTemplate();
	
	//PatientVO 필드를 매개변수로 받아와서 
	public PatientVO findUser(PatientVO vo) {
		try {
			return template.queryForObject("SELECT PAT_CODE,\r\n"
					+ "       PAT_NAME,\r\n"
					+ "       PAT_ADDR,\r\n"
					+ "       PAT_PHONE,\r\n"
					+ "       PAT_REG,\r\n"
					+ "       PAT_ID,\r\n"
					+ "       PAT_PW\r\n"
					+ "  FROM PATIENT\r\n"
					+ " WHERE PAT_ID = ? \r\n"
					+ "   AND PAT_PW = ? ", new BeanPropertyRowMapper<>(PatientVO.class), vo.getPatId(), vo.getPatPw());
		} catch (DataAccessException e) {
			return null;
		}
	}
}
