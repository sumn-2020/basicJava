package hospital.reply;

import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;
import hospital.qna.QnaDAO;
import hospital.qna.QnaVO;

public class ReplyDAO {

	// 싱글톤
	private static ReplyDAO instance = new ReplyDAO();
	private ReplyDAO() {}
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	// jdbc 템플릿 가져오기
	private JdbcTemplate template = HospitalApplication.getTemplate();

	
	//qna 답변 - 관리자
//	public int insertReply(ReplyVO vo)  {
//		return template.update("INSERT INTO REPLY (\r\n"
//				+ "    QNA_CODE, \r\n"
//				+ "    REPLY_NOTE, \r\n"
//				+ "    ADMIN_CODE \r\n"
//				+ " ) VALUES( \r\n"
//				+ "    ?,   \r\n"
//				+ "    ?,   \r\n"
//				+ "    ?   \r\n"
//				+ ")  ", vo.getQnaCode(), vo.getReplyNote(), vo.getAdminCode());
//	}
	
	
	//qna 답변 - 관리자
	public int selectReply(ReplyVO vo)  {
		return template.update("INSERT INTO REPLY (\r\n"
				+ "    QNA_CODE, \r\n"
				+ "    REPLY_NOTE, \r\n"
				+ "    ADMIN_CODE \r\n"
				+ " ) VALUES( \r\n"
				+ "    ?,   \r\n"
				+ "    ?,   \r\n"
				+ "    ?   \r\n"
				+ ")  ", vo.getQnaCode(), vo.getReplyNote(), vo.getAdminCode());
	}
	
	//qna 답변 - 관리자
	public int insertReply(ReplyVO vo) {
		//ReplyVO [qnaCode=Q105, replyNote=내용, replyDate=null, adminCode=A001]
		//System.out.println("insertReply->vo : " + vo.toString());
		
		return template.update("INSERT INTO REPLY (\r\n"
				+ "    QNA_CODE,\r\n"
				+ "    REPLY_NOTE,\r\n"
				+ "    REPLY_DATE,\r\n"
				+ "    ADMIN_CODE\r\n"
				+ ") VALUES (\r\n"
				+ "   ?,\r\n"
				+ "    ?,  \r\n"
				+ "    SYSDATE,  \r\n"
				+ "    ?   \r\n"
				+ ") ", vo.getQnaCode(), vo.getReplyNote(), vo.getAdminCode());
		
	}
	
	
}
