package hospital.appointment;

import java.sql.Date;
import java.util.List;

import hospital.HospitalApplication;

public class AppointmentController {
	private static AppointmentController instance = new AppointmentController();
	public static AppointmentController getInstance() {
		return instance;
	}
	private AppointmentController() {}
	
	private AppointmentService service = AppointmentService.getInstance();
	private AppointmentVO session = HospitalApplication.getSession5();
	
	public AppointmentController(AppointmentService service) {
		this.service = service;
	}
	
	public List<AppointmentVO> selectAppointment(String patCode) {
		return service.selectAppointment(patCode);
	}
	
	public int insertAppointment(AppointmentVO vo) {
		return service.insertAppointment(vo);
	}
	
	public int deleteAppointment(String patCode) {
		return service.deleteAppointment(patCode);
	}
	
	public int updateAppointment(Date resDate, String docCode, String patCode) {
		return service.updateAppointment(resDate,docCode,patCode);
	}
	
	public List<AppointmentVO> selectDocAppointment(String docCode) {
		return service.selectAppointment(docCode);
	}
}
