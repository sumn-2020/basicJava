package hospital.appointment;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;

public class AppointmentDAO {
	private static AppointmentDAO instance = new AppointmentDAO();
	public static AppointmentDAO getInstance() {
		return instance;
	}
	private AppointmentDAO() {}
	
	private JdbcTemplate template = HospitalApplication.getTemplate();
	
	// 환자예약조회
	public List<AppointmentVO> selectAppointment(String patCode) {
		return template.query("SELECT A.RES_CODE,\r\n"
				+ "		   A.RES_DATE,\r\n"
				+ "       B.PAT_NAME,\r\n"
				+ "       D.DEPT_NAME,\r\n"
				+ "       C.DOC_NAME\r\n"
				+ "  FROM RESERVATION A, PATIENT B, DOCTOR C, DEPARTMENT D\r\n"
				+ " WHERE A.PAT_CODE = B.PAT_CODE\r\n"
				+ "   AND A.DOC_CODE = C.DOC_CODE\r\n"
				+ "   AND C.DEPT_CODE = D.DEPT_CODE\r\n"
				+ "   AND A.PAT_CODE = ?\r\n", new BeanPropertyRowMapper(AppointmentVO.class), patCode);
	}
	
	// 예약등록
	public int insertAppointment(AppointmentVO vo) {
		return template.update("INSERT INTO RESERVATION (\r\n"
				+ "    RES_CODE,\r\n"
				+ "    RES_DATE, \r\n"
				+ "    PAT_CODE,\r\n"
				+ "    DOC_CODE,\r\n"
				+ "    RES_MEMO\r\n"
				+ ") VALUES (\r\n"
				+ "    (SELECT **'R'||TO_CHAR(SUBSTR(MAX(RES_CODE),2,3)+1) FROM RESERVATION)**,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?,\r\n"
				+ "    ?\r\n"
				+ ")", null, vo.getPatCode(), vo.getDocCode(), vo.getResMemo());
	}
	
	//예약취소
	public int deleteAppointment(String patCode) {
		return template.update("DELETE \r\n"
				+ "  FROM RESERVATION\r\n"
				+ " WHERE PAT_CODE = ?\r\n", patCode);
	}
	
	//예약변경
	public int updateAppointment(Date resDate, String docCode, String patCode) {
		return template.update("UPDATE RESERVATION\r\n"
				+ "   SET RES_DATE = ?,\r\n"
				+ "       DOC_CODE = ?\r\n"
				+ " WHERE PAT_CODE = ?\r\n", resDate,docCode,patCode);
	}
	
	//의사 예약조회
	
	public List<AppointmentVO> selectDocAppointment(String docCode) {
		return template.query("SELECT B.DOC_NAME, \r\n"
				+ "       A.RES_CODE,\r\n"
				+ "       A.RES_DATE, \r\n"
				+ "       C.PAT_NAME, \r\n"
				+ "       A.RES_MEMO\r\n"
				+ "  FROM RESERVATION A, DOCTOR B, PATIENT C\r\n"
				+ " WHERE A.DOC_CODE = B.DOC_CODE\r\n"
				+ "   AND A.PAT_CODE = C.PAT_CODE \r\n"
				+ "   AND B.DOC_CODE = ?", new BeanPropertyRowMapper(AppointmentVO.class), docCode);
	}
	
}
