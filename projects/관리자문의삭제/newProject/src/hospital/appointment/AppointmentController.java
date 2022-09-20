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
	//예약조회(세부조회)
	public List<AppointmentVO> selectAppointment(String patCode) {
		return service.selectAppointment(patCode);
	}
	//예약등록
	public int insertAppointment(AppointmentVO vo) {
		return service.insertAppointment(vo);
	}
	//예약삭제
	public int deleteAppointment(String patCode) {
		return service.deleteAppointment(patCode);
	}
	//예약변경
	public int updateAppointment(Date resDate, String docCode, String patCode) {
		return service.updateAppointment(resDate,docCode,patCode);
	}
	//의사예약조회
	public List<AppointmentVO> selectDocAppointment(String docCode) {
		return service.selectDocAppointment(docCode);
	}
}
