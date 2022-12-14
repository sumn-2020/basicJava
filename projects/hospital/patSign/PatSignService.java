package hospital.patSign;

import hospital.join.PatientVO;

public class PatSignService {
	private static PatSignService instance = new PatSignService();
	public static PatSignService getInstance() {
		return instance;
	}
	
	private PatSignService() {}
	
	private PatSignDAO dao = PatSignDAO.getInstance();
	//환자로그인
	public PatientVO findPatient(PatientVO vo) {
		return dao.findPatient(vo);
	}
}
