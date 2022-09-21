package hospital.notice;

import java.util.List;

import hospital.HospitalApplication;
import hospital.common.HomeMenu;
import hospital.join.DoctorVO;

public class NoticeController {
	private static NoticeController instance = new NoticeController();
	public static NoticeController getInstance() {
		return instance;
	}
	private NoticeController() {}
	
	private NoticeService service = NoticeService.getInstance();
	private NoticeVO session = HospitalApplication.getSession4();
	
	public NoticeController(NoticeService service) {
		this.service = service;
	}
	
	//전체목록
	public List<NoticeVO> selectNoticeList(){
		return service.findAll();
	}
	//확인할 공지
	public List<NoticeVO> selectNoticeList2(String id){
		return service.findNoticeId(id);
	}
	
	//공지등록
	public int insertNotice(NoticeVO vo) {
		try {
			if (service.insertNotice(vo) == 1) { 
				return HomeMenu.ALLNOTICE.getMenu(); 
			}
		} catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생했습니다.");
			return HomeMenu.HOME.getMenu();
		}
		return HomeMenu.NOTICE_CHECK.getMenu();
    }
	
	//삭제
	public int deleteNotice(NoticeVO vo) {
		return service.deleteNotice(vo);
	}
	
	// 수정
	public int updateNotice(NoticeVO vo) {
		return service.updateNotice(vo);
	}
}
