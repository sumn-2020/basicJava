package project01.sign;

import project01.HospitalApplication;
import project01.common.AdminVO;
import project01.common.DoctorVO;
import project01.common.HomeMenu;
import project01.common.PatientVO;

public class SignController {

	// 싱글톤
	private static SignController instance = new SignController();

	private SignController() {
	}

	public static SignController getInstance() {
		return instance;
	}

	// service 싱글톤 호출
	private SignService service = SignService.getInstance();

	// application에서 session필드 호출
	private PatientVO session = HospitalApplication.getSession();
	private DoctorVO sessionDoc = HospitalApplication.getSessionDoc();
	private AdminVO sessionAdmin = HospitalApplication.getSessionAdmin();
	
	
	// 로그인
	//환자
	public PatientVO patientSignIn(PatientVO vo) {
		// 아이디 비번에 따라 디비에 저장되어있는 회원정보 불러오기
		PatientVO patient = service.findUser(vo); 
		if (patient == null) {
			return null;
		}
		session.setPatId(patient.getPatId()); // PatientVO에서 getPatId정보 가져오기
		session.setPatName(patient.getPatName());
		return patient;
	}
	//의사
	public DoctorVO doctorSignIn(DoctorVO vo) {
		DoctorVO doctor = service.findDoctor(vo); 
		if (doctor == null) {
			return null;
		}
		sessionDoc.setDocId(doctor.getDocId()); 
		sessionDoc.setDocName(doctor.getDocName());
		return doctor;
	}
	//관리자
	public AdminVO adminSignIn(AdminVO vo) {
		AdminVO admin = service.findAdministor(vo); 
		if (admin == null) {
			return null;
		}
		sessionAdmin.setAdminId(admin.getAdminId()); 
		sessionAdmin.setAdminName(admin.getAdminName());
		return admin;
	}
	
	

	// 로그아웃
	public int signout() {
		// 세션 초기화
		session.invalidate();
		return HomeMenu.HOME.getMenu();
	}

}
