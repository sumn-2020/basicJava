package hospital.adminSign;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;
import hospital.join.AdminVO;
import hospital.join.DoctorVO;
import hospital.join.PatientVO;

public class AdminSignController {
	private static AdminSignController instance = new AdminSignController();
	public static AdminSignController getInstance() {
		return instance;
	}
	
	private AdminSignController() {}
	
	private AdminSignService service = AdminSignService.getInstance();
	
	private AdminVO session = HospitalApplication.getSession3();
	
	public AdminVO signIn(AdminVO vo) {
		AdminVO admin = service.findAdmUser(vo);
		if(admin == null) {
			return null;
		}
		session.setAdminCode(admin.getAdminCode());
		session.setAdminName(admin.getAdminName());
		return admin;
	}
	public int signOut() {
		session.invalidate();
		return HomeMenu.HOME.getMenu();
	}
}
