package hospital.join;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;

public class JoinService {
	private static JoinService instance = new JoinService();
	public static JoinService getInstance() {
		return instance;
	}
	private JoinService() {}
	
	private JoinDAO dao = JoinDAO.getInstance();
	
	public int join(PatientVO vo) {
		return dao.join(vo);
	}
	
	public int modifyInfo(PatientVO vo, HomeMenu menu) {
		int result = 0;
		switch (menu) {
		case MODIFY_NAME:
			result = dao.modifyName(vo);
			break;
		}
		return result;
	}
}
