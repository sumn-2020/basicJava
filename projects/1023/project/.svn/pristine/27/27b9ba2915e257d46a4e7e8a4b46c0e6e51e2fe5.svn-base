package hospital.docSign;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;
import hospital.join.DoctorVO;
import hospital.join.PatientVO;

public class DocSignController {
	private static DocSignController instance = new DocSignController();
	public static DocSignController getInstance() {
		return instance;
	}
	
	private DocSignController() {}
	
	private DocSignService service = DocSignService.getInstance();
	
	private DoctorVO session = HospitalApplication.getSession2();
	
	public DoctorVO signIn(DoctorVO vo) {
		DoctorVO doctor = service.findDocUser(vo);
		if(doctor == null) {
			return null;
		}
		session.setDocCode(doctor.getDocCode());
		session.setDocName(doctor.getDocName());
		return doctor;
	}
	public int signOut() {
		session.invalidate();
		return HomeMenu.HOME.getMenu();
	}
}
