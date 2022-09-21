package hospital.reply;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	
	//qna 전체목록 조회- 환자 
//	public List<QnaVO> findAll() {
//		return template.query("SELECT A.QNA_CODE,\r\n"
//				+ "       A.QNA_SUB,\r\n"
//				+ "       B.PAT_NAME,\r\n"
//				+ "       A.QNA_DATE\r\n"
//				+ "  FROM QNA A, PATIENT B   \r\n"
//				+ " WHERE A.PAT_CODE = B.PAT_CODE ", new BeanPropertyRowMapper<>(QnaVO.class));
//	}
//	
	
	public List<ReplyVO> findReplyId(String ReplyId) {
		return template.query("SELECT A.QNA_CODE,\r\n"
				+ "       A.QNA_SUB,\r\n"
				+ "       A.QNA_NOTE,\r\n"
				+ "       B.PAT_NAME,\r\n"
				+ "       A.QNA_DATE,\r\n"
				+ "       C.REPLY_NOTE,\r\n"
				+ "       C.REPLY_DATE\r\n"
				+ "  FROM QNA A \r\n"
				+ "  INNER JOIN PATIENT B ON (A.PAT_CODE = B.PAT_CODE AND A.QNA_CODE = ?)  \r\n"
				+ "  LEFT OUTER JOIN REPLY C ON (A.QNA_CODE = C.QNA_CODE)   ", new BeanPropertyRowMapper<>(ReplyVO.class), ReplyId);
	}
	
	
	
	
	
	
}
