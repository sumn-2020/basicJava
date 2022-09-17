package project01.sign;

import project01.join.AdminVO;
import project01.join.DoctorVO;
import project01.join.PatientVO;

public class SignService {

	// service 싱글톤
	private static SignService instance = new SignService();

	private SignService() {
	}

	public static SignService getInstance() {
		return instance;
	}

	// *** DAO 싱글톤 호출 ***
	private SignDAO dao = SignDAO.getInstance();

	// 환자
	public PatientVO findUser(PatientVO vo) {
		return dao.findUser(vo);
	}

	// 의사
	public DoctorVO findDoctor(DoctorVO vo) {
		return dao.findDoctor(vo);
	}

	// 관리자
	public AdminVO findAdministor(AdminVO vo) {
		return dao.findAdministor(vo);
	}

}
