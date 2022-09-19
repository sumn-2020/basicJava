package hospital.notice;

import java.sql.Date;

public class NoticeVO {
	private String noticeCode; //공지사항 번호
	private String noticeSub; //제목
	private String noticeNote; //내용
	private Date noticeDate; //등록일자
	private String adminCode; //관리자코드
	private String adminName; // 관리자이름
	
	public NoticeVO() {
	}
	public NoticeVO(String noticeCode) {
		this.noticeCode=noticeCode;
	}
	
	public NoticeVO(String noticeSub, String noticeNote, String adminCode, String noticeCode) {
		this.noticeSub=noticeSub;
		this.noticeNote=noticeNote;
		this.adminCode=adminCode;
		this.noticeCode=noticeCode;
	}

	public NoticeVO(String noticeSub, String noticeNote) {
		this.noticeSub=noticeSub;
		this.noticeNote=noticeNote;
	}
	public NoticeVO(String noticeSub, String noticeNote, String adminCode) {
		this.noticeSub=noticeSub;
		this.noticeNote=noticeNote;
		this.adminCode = adminCode;
	}


	public NoticeVO(String noticeCode, String noticeSub, String noticeNote, Date noticeDate, String adminName) {
		this.noticeCode = noticeCode;
		this.noticeSub = noticeSub;
		this.noticeNote = noticeNote;
		this.noticeDate = noticeDate;
		this.adminName = adminName;
	}



	public NoticeVO(String noticeCode, String noticeSub, String noticeNote, Date noticeDate, String adminCode,String adminName) {
		this.noticeCode = noticeCode;
		this.noticeSub = noticeSub;
		this.noticeNote = noticeNote;
		this.noticeDate = noticeDate;
		this.adminCode = adminCode;
		this.adminName = adminName;
	}



	public String getNoticeCode() {
		return noticeCode;
	}



	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}



	public String getNoticeSub() {
		return noticeSub;
	}



	public void setNoticeSub(String noticeSub) {
		this.noticeSub = noticeSub;
	}



	public String getNoticeNote() {
		return noticeNote;
	}



	public void setNoticeNote(String noticeNote) {
		this.noticeNote = noticeNote;
	}



	public Date getNoticeDate() {
		return noticeDate;
	}



	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}



	public String getAdminCode() {
		return adminCode;
	}



	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}



	public String getAdminName() {
		return adminName;
	}
 
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public void invalidate() {
		this.noticeCode = null;
		this.noticeSub = null;
		this.noticeNote =null;
		this.noticeDate=null;
		this.adminCode = null;
		this.adminName = null;
		
	}
	
}
