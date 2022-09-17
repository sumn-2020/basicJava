package hospital.qna;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;

public class QnaDAO {

	// 싱글톤
	private static QnaDAO instance = new QnaDAO();

	private QnaDAO() {
	}

	public static QnaDAO getInstance() {
		return instance;
	}

	// jdbc 템플릿 가져오기
	private JdbcTemplate template = HospitalApplication.getTemplate();

	

	// Q&A 작성
	public List<QnaDAO> QnaWrite(int patId) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO QNA (\r\n" + "    QNA_CODE,\r\n" + "    QNA_SUB,\r\n" + "    QNA_NOTE,\r\n"
				+ "    PAT_CODE\r\n" + ") VALUES (\r\n"
				+ "    (SELECT 'Q'||TO_CHAR(SUBSTR(MAX(QNA_CODE),2,3)+1) FROM QNA),\r\n" + "    ?,  \r\n"
				+ "    ?,   \r\n" + "    ?   '\r\n" + ") ");
		return template.query(builder.toString(), new BeanPropertyRowMapper<>(QnaDAO.class), patId);
	}
	
	
	
	
}
