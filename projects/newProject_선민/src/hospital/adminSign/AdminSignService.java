package hospital.adminSign;

import hospital.join.AdminVO;

public class AdminSignService {
	private static AdminSignService instance = new AdminSignService();
	public static AdminSignService getInstance() {
		return instance;
	}
	
	private AdminSignService() {}
	
	private AdminSignDAO dao = AdminSignDAO.getInstance();
	//관리자로그인
	public AdminVO findAdmUser(AdminVO vo) {
		return dao.findAdmUser(vo);
	}
}
