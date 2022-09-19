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
	
	//qna 전체목록 조회
	public List<QnaVO> findAll() {
		return template.query("SELECT A.QNA_CODE,\r\n"
				+ "       A.QNA_SUB,\r\n"
				+ "       B.PAT_NAME,\r\n"
				+ "       A.QNA_DATE\r\n"
				+ "  FROM QNA A, PATIENT B   \r\n"
				+ " WHERE A.PAT_CODE = B.PAT_CODE ", new BeanPropertyRowMapper<>(QnaVO.class));
	}
	public List<QnaVO> findQnaId(String qnaId) {
		return template.query("SELECT A.QNA_CODE,\r\n"
				+ "       A.QNA_SUB,\r\n"
				+ "       A.QNA_NOTE,\r\n"
				+ "       B.PAT_NAME,\r\n"
				+ "       A.QNA_DATE\r\n"
				+ "  FROM QNA A, PATIENT B   \r\n"
				+ " WHERE A.PAT_CODE = B.PAT_CODE\r\n"
				+ "   AND A.QNA_CODE = ? ", new BeanPropertyRowMapper<>(QnaVO.class), qnaId);
	}
	
	
	//qna 답변 등록
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
