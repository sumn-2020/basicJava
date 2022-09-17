package project01.join;

import project01.HospitalApplication;
import project01.common.HomeMenu;
import project01.common.PatientVO;

public class JoinController {

	// 싱글톤
	private static JoinController instance = new JoinController();
	private JoinController() {}
	public static JoinController getInstance() {
		return instance;
	}

	// service 싱글톤 호출
	private JoinService service = JoinService.getInstance();

	
	//회원가입
	public int join(PatientVO vo) {
		try {
			if(service.join(vo) == 1) {
				return HomeMenu.HOME.getMenu();
			}
		} catch (Exception e) {
			System.out.println("알수 없는 오류가 발생하였습니다.");
			return HomeMenu.JOIN.getMenu();
		}
		return HomeMenu.HOME.getMenu();
	}
	
	
	//회원수정
    private PatientVO session = HospitalApplication.getSession();

    public JoinController(JoinService service) {
        this.service = service;
    }

    public PatientVO findPatient() {
        return service.findUser(session.getPatId());
    }

}
