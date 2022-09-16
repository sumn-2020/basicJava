package project01.sign;

import project01.join.PatientVO;

public class SignService {

	// service 싱글톤
	private static SignService instance = new SignService();
	private SignService() {}
	public static SignService getInstance() {
		return instance;
	}

	// DAO 싱글톤 호출
	private SignDAO dao = SignDAO.getInstance();
	public PatientVO findUser(PatientVO vo) {
		return dao.findUser(vo);
	}

}
