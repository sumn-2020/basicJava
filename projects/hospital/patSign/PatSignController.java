package hospital.patSign;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;
import hospital.join.PatientVO;

public class PatSignController {
	private static PatSignController instance = new PatSignController();
	public static PatSignController getInstance() {
		return instance;
	}
	
	private PatSignController() {}
	
	private PatSignService service = PatSignService.getInstance();
	
	private PatientVO session = HospitalApplication.getSession();
	//환자로그인
	public PatientVO signIn(PatientVO vo) {
		PatientVO patient = service.findPatient(vo);
		if(patient == null) {
			return null;
		}
		session.setpatId(patient.getpatId());
		session.setpatCode(patient.getpatCode());
		session.setpatName(patient.getpatName());
		return patient;
	}
	public int signOut() {
		session.invalidate();
		return HomeMenu.HOME.getMenu();
	}
}
