package hospital.qna;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;
import hospital.join.AdminVO;
import hospital.notice.NoticeVO;
import hospital.reply.ReplyVO;

public class QnaDAO {

	// 싱글톤
		private static QnaDAO instance = new QnaDAO();
		private QnaDAO() {}
		public static QnaDAO getInstance() {
			return instance;
		}

		// jdbc 템플릿 가져오기
		private JdbcTemplate template = HospitalApplication.getTemplate();

		
		//qna 전체목록 조회- 환자 
		public List<QnaVO> findAll() {
			return template.query("SELECT A.QNA_CODE,\r\n"
					+ "       A.QNA_SUB,\r\n"
					+ "       B.PAT_NAME,\r\n"
					+ "       A.QNA_DATE\r\n"
					+ "  FROM QNA A, PATIENT B   \r\n"
					+ " WHERE A.PAT_CODE = B.PAT_CODE ", new BeanPropertyRowMapper<>(QnaVO.class));
		}
		public List<QnaVO> findQnaId(String qnaId) {
			return template.query("SELECT A.QNA_CODE, \r\n"
					+ "	 A.QNA_SUB, \r\n"
					+ "	A.QNA_NOTE, \r\n"
					+ "	 B.PAT_NAME, \r\n"
					+ "	 A.QNA_DATE, \r\n"
					+ "	C.REPLY_NOTE, \r\n"
					+ "	C.REPLY_DATE \r\n"
					+ "	 FROM QNA A  \r\n"
					+ "	INNER JOIN PATIENT B ON (A.PAT_CODE = B.PAT_CODE AND A.QNA_CODE = ?)  \r\n"
					+ "	 LEFT OUTER JOIN REPLY C ON (A.QNA_CODE = C.QNA_CODE)  ", new BeanPropertyRowMapper<>(QnaVO.class), qnaId);
		}

		
		//*** 환자 *** 
		// qna 등록 
		public int insertQna(QnaVO vo) {
			return template.update("INSERT INTO QNA (\r\n"
					+ "    QNA_CODE,\r\n"
					+ "    QNA_SUB,\r\n"
					+ "    QNA_NOTE,\r\n"
					+ "    PAT_CODE\r\n"
					+ ") VALUES (\r\n"
					+ "    (SELECT 'Q'||TO_CHAR(SUBSTR(MAX(QNA_CODE),2,3)+1) FROM QNA),\r\n"
					+ "    ?,  \r\n"
					+ "    ?,  \r\n"
					+ "    ?   \r\n"
					+ ") ", vo.getQnaSub(), vo.getQnaNote(), vo.getPatCode());
		}
		
		//qna 삭제 
		public int deleteQna(QnaVO vo) {
			return template.update("DELETE FROM QNA\r\n"
					+ "   WHERE QNA_CODE = ? ", vo.getQnaCode());
		}
		
		// qna 수정
		public int updateQna(QnaVO vo) {
			return template.update("INSERT INTO QNA (\r\n"
					+ "    QNA_CODE,\r\n"
					+ "    QNA_SUB,\r\n"
					+ "    QNA_NOTE,\r\n"
					+ "    PAT_CODE\r\n"
					+ ") VALUES (\r\n"
					+ "    (SELECT 'Q'||TO_CHAR(SUBSTR(MAX(QNA_CODE),2,3)+1) FROM QNA),\r\n"
					+ "    ?,  \r\n"
					+ "    ?,  \r\n"
					+ "    ?   \r\n"
					+ ") ", vo.getQnaSub(), vo.getQnaNote(), vo.getPatCode());
		}
		
	
}
