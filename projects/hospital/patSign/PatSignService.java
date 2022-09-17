package hospital.patSign;

import hospital.join.PatientVO;

public class PatSignService {
	private static PatSignService instance = new PatSignService();
	public static PatSignService getInstance() {
		return instance;
	}
	
	private PatSignService() {}
	
	private PatSignDAO dao = PatSignDAO.getInstance();
	
	public PatientVO findUser(PatientVO vo) {
		return dao.findUser(vo);
	}
}
