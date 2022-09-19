package hospital.reply;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;
import hospital.join.AdminVO;
import hospital.qna.QnaVO;


public class ReplyController {
	//싱글톤 
	private static ReplyController instance = new ReplyController();
	private ReplyController() {}
	public static ReplyController getInstance() {
		return instance;
	}
	
	//QnaService 싱글톤 불러오기 
	private ReplyService service = ReplyService.getInstance();
	//db 에서 관리자 정보 가져오기 
	private AdminVO session3 = HospitalApplication.getSession3();
	

	//reply 등록 정보 가져오기 
	public int insertQna(ReplyVO vo) {
		session3 = HospitalApplication.getSession3();
		vo.setAdminCode(session3.getAdminCode());
		try {
			if(service.insertReply(vo) == 1) {
				return HomeMenu.QNA.getMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("알 수 없는 오류가 발생했습니다.");
			return HomeMenu.HOME.getMenu();
		}
		return HomeMenu.QNA_CHECK.getMenu();
	}

	//qna 답변
	public int insertReply(ReplyVO vo) {
		return service.insertReply(vo);
	}
}
