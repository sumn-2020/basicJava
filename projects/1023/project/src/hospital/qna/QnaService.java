package hospital.qna;

import java.util.List;

import hospital.join.AdminVO;
import hospital.join.PatientVO;
import hospital.notice.NoticeVO;
import hospital.reply.ReplyVO;

public class QnaService {
	
	//싱글톤
	private static QnaService instance = new QnaService(); 
	private QnaService() {}
	public static QnaService getInstance() {
		return instance;
	}
	
	//dao 싱글톤 불러오기
	private QnaDAO dao = QnaDAO.getInstance();
	

	//qna 전체목록
	public List<QnaVO> findAll() {
		return dao.findAll();
	}
	// 확인할 공지
	public List<QnaVO> findQnaId(String qnaId) {
		return dao.findQnaId(qnaId);
	}

	//qna 등록 정보 가져오기 
	public int insertQna(QnaVO vo) {
		return dao.insertQna(vo);
	}
	
	// qna 삭제
	public int deleteQna(QnaVO vo) {
		return dao.deleteQna(vo);
	}


}
