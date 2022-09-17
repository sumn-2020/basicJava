package hospital.notice;

import java.util.List;

import hospital.HospitalApplication;
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
	
	public List<NoticeVO> selectNoticeList(){
		return service.findAll();
	}
	
	public List<NoticeVO> selectNoticeList2(String id){
		return service.findNoticeId(id);
	}
	
	
	
}
