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
	
	public List<AppointmentVO> selectAppointment(String patCode) {
		return dao.selectAppointment(patCode);
	}
	
	public int insertAppointment(AppointmentVO vo) {
		return dao.insertAppointment(vo);
	}
	
	public int deleteAppointment(String patCode) {
		return dao.deleteAppointment(patCode);
	}
	
	public int updateAppointment(Date resDate, String docCode, String patCode) {
		return dao.updateAppointment(resDate,docCode,patCode);
	}
	
	public List<AppointmentVO> selectDocAppointment(String docCode) {
		return dao.selectAppointment(docCode);
	}
	
}
