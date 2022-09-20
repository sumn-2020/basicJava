package hospital.docSign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;
import hospital.join.DoctorVO;
import hospital.join.PatientVO;

public class DocSignDAO {
	private static DocSignDAO instance = new DocSignDAO();
	public static DocSignDAO getInstance() {
		return instance;
	}
	
	private DocSignDAO() {}
	
	private JdbcTemplate template = HospitalApplication.getTemplate();
	//의사로그인
	public DoctorVO findDocUser(DoctorVO vo) {
		try {
			return template.queryForObject("SELECT DOC_CODE,\r\n"
					+ "       DOC_NAME,\r\n"
					+ "       DEPT_CODE,\r\n"
					+ "       DOC_OFF,\r\n"
					+ "       DOC_LOCATION,\r\n"
					+ "       DOC_ID,\r\n"
					+ "       DOC_PW\r\n"
					+ "  FROM DOCTOR\r\n"
					+ " WHERE DOC_ID = ?\r\n"
					+ "   AND DOC_PW = ?", new BeanPropertyRowMapper<>(DoctorVO.class), vo.getDocId(), vo.getDocPw());
		} catch (DataAccessException e) {
			return null;
		}
	}
}
