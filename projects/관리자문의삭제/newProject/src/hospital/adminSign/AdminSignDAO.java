package hospital.adminSign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;
import hospital.join.AdminVO;
import hospital.join.DoctorVO;
import hospital.join.PatientVO;

public class AdminSignDAO {
	private static AdminSignDAO instance = new AdminSignDAO();
	public static AdminSignDAO getInstance() {
		return instance;
	}
	
	private AdminSignDAO() {}
	
	private JdbcTemplate template = HospitalApplication.getTemplate();
	//관리자로그인
	public AdminVO findAdmUser(AdminVO vo) {
		try {
			return template.queryForObject("\r\n"
					+ "SELECT ADMIN_CODE,\r\n"
					+ "       ADMIN_NAME,\r\n"
					+ "       ADMIN_ID,\r\n"
					+ "       ADMIN_PW\r\n"
					+ "  FROM ADMIN\r\n"
					+ " WHERE ADMIN_ID = ?\r\n"
					+ "   AND ADMIN_PW = ?", new BeanPropertyRowMapper<>(AdminVO.class), vo.getAdminId(), vo.getAdminPw());
		} catch (DataAccessException e) {
			return null;
		}
	}
}
