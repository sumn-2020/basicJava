package hospital.notice;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import hospital.HospitalApplication;

public class NoticeDAO {
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	private NoticeDAO() {}
	
	private JdbcTemplate template = HospitalApplication.getTemplate();
	
	public List<NoticeVO> findAll(){
		return template.query("SELECT A.NOTICE_CODE,\r\n"
				+ "       A.NOTICE_SUB,\r\n"
				+ "       A.NOTICE_DATE,\r\n"
				+ "       B.ADMIN_NAME\r\n"
				+ "  FROM NOTICE A, ADMIN B\r\n"
				+ " WHERE A.ADMIN_CODE = B.ADMIN_CODE", new BeanPropertyRowMapper<>(NoticeVO.class));
	}
	
	public List<NoticeVO> findNoticeId(String noticeId) {
		return template.query("SELECT A.NOTICE_SUB,\r\n"
				+ "       A.NOTICE_NOTE,\r\n"
				+ "       A.NOTICE_DATE,\r\n"
				+ "       B.ADMIN_NAME\r\n"
				+ "  FROM NOTICE A, ADMIN B\r\n"
				+ " WHERE A.ADMIN_CODE = B.ADMIN_CODE\r\n"
				+ "   AND A.NOTICE_CODE = ?", new BeanPropertyRowMapper<>(NoticeVO.class), noticeId);
	}
}
