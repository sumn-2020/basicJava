package hospital.notice;

import java.util.List;

public class NoticeService {
	private static NoticeService instance = new NoticeService();

	public static NoticeService getInstance() {
		return instance;
	}

	private NoticeService() {
	}

	private NoticeDAO dao = NoticeDAO.getInstance();

	//전체 공지 목록
	public List<NoticeVO> findAll() {
		return dao.findAll();
	}

	//확인할 공지
	public List<NoticeVO> findNoticeId(String noticeId) {
		return dao.findNoticeId(noticeId);
	}

	//등록
	public int insertNotice(NoticeVO vo) {
		return dao.insertNotice(vo);
	}
	// 삭제
	public int deleteNotice(NoticeVO vo) {
		return dao.deleteNotice(vo);
	}
	//수정
	public int updateNotice(NoticeVO vo) {
		return dao.updateNotice(vo);
	}
	
	
}
