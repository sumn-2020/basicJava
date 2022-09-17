package project01.join;

import project01.common.PatientVO;

public class JoinService {

	// 싱글톤
	private static JoinService instance = new JoinService();
	private JoinService() {}
	public static JoinService getInstance() {
		return instance;
	}

	// dao 싱글톤 호출
	private JoinDAO dao = JoinDAO.getInstance();

	// 회원가입 - 입력정보 저장
	public int join(PatientVO vo) {
		return dao.join(vo);
	}

	//회원찾기
	public PatientVO findUser(String patId) {
		return null;
	}

	

}
