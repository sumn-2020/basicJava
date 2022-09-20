package hospital.reply;

import java.util.List;

import hospital.qna.QnaDAO;
import hospital.qna.QnaVO;

public class ReplyService {
	
	
	//싱글톤
	private static ReplyService instance = new ReplyService(); 
	private ReplyService() {}
	public static ReplyService getInstance() {
		return instance;
	}
	
	//dao 싱글톤 불러오기
	private ReplyDAO dao = ReplyDAO.getInstance();
	
	//qna 전체목록
	public List<ReplyVO> findAllReply() {
//		return dao.findAllReply();
		return null;
	}
	// 확인할 공지
	public List<QnaVO> findQnaId(String qnaId) {
//		return dao.findQnaId(qnaId);
		return null;
	}
	

	
	
	//qna 답변 - 관리자
	public int insertReply(ReplyVO vo) {
		return dao.insertReply(vo);
	}

	// 확인할 답변
	public List<ReplyVO> findReplyId(String qnaId) {
		return dao.findReplyId(qnaId);
	}

	// 삭제
	public int deleteReply(ReplyVO vo) {
		return dao.deleteReply(vo);
	}
	
	
	
	
	
	
}
