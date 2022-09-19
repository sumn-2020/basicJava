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
		return template.query("SELECT\r\n"
				+ "    a.notice_code,\r\n"
				+ "    a.notice_sub,\r\n"
				+ "    a.notice_date,\r\n"
				+ "    b.admin_name\r\n"
				+ "FROM\r\n"
				+ "    notice a,\r\n"
				+ "    admin b\r\n"
				+ "WHERE\r\n"
				+ "    a.admin_code = b.admin_code", new BeanPropertyRowMapper<>(NoticeVO.class));
	}
	
	public List<NoticeVO> findNoticeId(String noticeId) {
		return template.query("SELECT\r\n"
				+ "    a.notice_sub,\r\n"
				+ "    a.notice_note,\r\n"
				+ "    a.notice_date,\r\n"
				+ "    b.admin_name\r\n"
				+ "FROM\r\n"
				+ "    notice a,\r\n"
				+ "    admin b\r\n"
				+ "WHERE\r\n"
				+ "    a.admin_code = b.admin_code\r\n"
				+ "    AND   a.notice_code = ?", new BeanPropertyRowMapper<>(NoticeVO.class), noticeId);
	}
	//공지사항 등록(관리자)
		public int insertNotice(NoticeVO vo) {
 			return template.update("INSERT\r\n"
					+ "INTO notice (\r\n"
					+ "        notice_code,\r\n"
					+ "        notice_sub,\r\n"
					+ "        notice_note,\r\n"
					+ "        admin_code\r\n"
					+ "    )\r\n"
					+ "VALUES ( (\r\n"
					+ "    SELECT\r\n"
					+ "        'N'\r\n"
					+ "        || TO_CHAR(substr(MAX(notice_code),2,3) + 1)\r\n"
					+ "    FROM\r\n"
					+ "        notice\r\n"
					+ "),"
					+ "     ?,\r\n"
					+ "     ?,\r\n"   
					+ "     ?)", vo.getNoticeSub(), vo.getNoticeNote(), vo.getAdminCode());
		}
		//공지사항 삭제(관리자)
		public int deleteNotice(NoticeVO vo) {
			return template.update("DELETE FROM notice WHERE notice_code = ?", vo.getNoticeCode());
		}

		
		// 공지사항 수정(관리자)
		public int updateNotice(NoticeVO vo) {
			return template.update("UPDATE NOTICE\r\n" + 
					"   SET NOTICE_SUB   = ?\r\n" + 
					"	   ,NOTICE_NOTE = ?\r\n" + 
					"       ,NOTICE_DATE = SYSDATE\r\n" + 
					"	   ,ADMIN_CODE  = ?\r\n" + 
					" WHERE NOTICE_CODE  = ?", vo.getNoticeSub(), vo.getNoticeNote(),vo.getAdminCode(),vo.getNoticeCode());
		}
		
}
