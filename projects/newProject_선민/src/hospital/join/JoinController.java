package hospital.join;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;

public class JoinController {
	private static JoinController instance = new JoinController();
	public static JoinController getInstance() {
		return instance;
	}
	private JoinController() {}
	
	private JoinService service = JoinService.getInstance();
	private PatientVO session = HospitalApplication.getSession();

	public JoinController(JoinService service) {
		this.service = service;
	}
	
	public PatientVO findPatUser() {
		session = HospitalApplication.getSession();
		return service.findPatUser(session.getpatId());
	}


	public int join(PatientVO vo) {
		try {
			if (service.join(vo) == 1) {
				return HomeMenu.HOME.getMenu();
			}
		} catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생했습니다.");
			return HomeMenu.HOME.getMenu();
		}
		return HomeMenu.HOME.getMenu();
	}

	public int modifyInfo(String modifyData, HomeMenu menu) {
		PatientVO vo = new PatientVO();
		vo.setpatId(session.getpatId());
		switch (menu) {
		case MODIFY_NAME:
			vo.setpatName(modifyData);
			break;
		case MODIFY_ADDRESS:
			vo.setpatAddr(modifyData);
			break;
		case MODIFY_PHONE:
			vo.setpatPhone(modifyData);
			break;
		}
		return service.modifyInfo(vo, menu);
	}

	public int modifyPassword(String password) {
		PatientVO vo = new PatientVO();
		vo.setpatId(session.getpatId());
		vo.setpatPw(password);
		return service.modifyPassword(vo);
	}

}
