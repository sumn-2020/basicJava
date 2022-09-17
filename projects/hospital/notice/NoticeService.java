package hospital.notice;

import java.util.List;

public class NoticeService {
	private static NoticeService instance = new NoticeService();
	public static NoticeService getInstance() {
		return instance;
	}
	private NoticeService() {}
	
	private NoticeDAO dao = NoticeDAO.getInstance();
	
	public List<NoticeVO> findAll(){
		return dao.findAll();
	}
	
	public List<NoticeVO> findNoticeId(String noticeId) {
		return dao.findNoticeId(noticeId);
	}
}
