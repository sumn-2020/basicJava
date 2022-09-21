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
	
	public PatientVO findPatUser(String patId) {
		return dao.findPatUser(patId);
	}

	public int join(PatientVO vo) {
		return dao.join(vo);
	}

	public int modifyInfo(PatientVO vo, HomeMenu menu) {
		int result = 0;
		switch (menu) {
		case MODIFY_NAME:
			result = dao.modifyName(vo);
			break;
		case MODIFY_ADDRESS:
			result = dao.modifyAddress(vo);
			break;
		case MODIFY_PHONE:
			result = dao.modifyPhone(vo);
			break;
		}
		return result;
	}

	public int modifyPassword(PatientVO vo) {
		return dao.modifyPassword(vo);
	}

}
