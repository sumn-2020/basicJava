package hospital.qna;

import java.util.List;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;
import hospital.join.AdminVO;
import hospital.join.PatientVO;
import hospital.notice.NoticeVO;



public class QnaController {

	//싱글톤 
	private static QnaController instance = new QnaController();
	private QnaController() {}
	public static QnaController getInstance() {
		return instance;
	}
	
	//QnaService 싱글톤 불러오기 
	private QnaService service = QnaService.getInstance();
	//db 에서 환자정보 가져오기 
	private PatientVO session = HospitalApplication.getSession();
	


	
	//qna 등록 정보 가져오기  - 환자 
	public int insertQna(QnaVO vo) {
		session = HospitalApplication.getSession();
		vo.setPatCode(session.getpatCode());
		try {
			if(service.insertQna(vo) == 1) {
				return HomeMenu.QNA.getMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("알 수 없는 오류가 발생했습니다.");
			return HomeMenu.HOME.getMenu();
		}
		return HomeMenu.QNA_CHECK.getMenu();
	}
	

	//qna 전체목록 정보 - 관리자
	public List<QnaVO> selectQnaList() {
		return service.findAll();
	}
	// qna 삭제-관리자
	public int deleteQna(QnaVO vo) {
		return service.deleteQna(vo);
	}
	// 확인할 공지 -관리자
	public List<QnaVO> selectQnaList2(String id){
		return service.findQnaId(id);
	}
	

	

	

}
