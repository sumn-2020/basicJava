package hospital.appointment;

import java.sql.Date;
import java.util.List;

public class AppointmentService {
	private static AppointmentService instance = new AppointmentService();
	public static AppointmentService getInstance() {
		return instance;
	}
	private AppointmentService() {}
	
	private AppointmentDAO dao = AppointmentDAO.getInstance();
	//환자예약조회
//	public List<AppointmentVO> selectAppointment(String patCode) {
//		return dao.selectAppointment(patCode);
//	}
	public List<AppointmentVO> findAppointment(String patCode) {
	return dao.findAppointment(patCode);
}
	
	
	//예약등록
	public int insertAppointment(AppointmentVO vo) {
		return dao.insertAppointment(vo);
	}
	//예약취소
	public int deleteAppointment(String patCode) {
		return dao.deleteAppointment(patCode);
	}
	//예약변경
	public int updateAppointment(Date resDate, String docCode, String patCode) {
		return dao.updateAppointment(resDate,docCode,patCode);
	}
	//의사예약조회
	public List<AppointmentVO> selectDocAppointment(String docCode) {
		return dao.selectDocAppointment(docCode);
	}
	
}
