package hospital.notice;

import java.sql.Date;

public class NoticeVO {
	private String noticeCode;
	private String noticeSub;
	private String noticeNote;
	private Date noticeDate;
	private String adminCode;
	
	public NoticeVO() {
	}

	

	public NoticeVO(String noticeCode, String noticeSub, String noticeNote, Date noticeDate) {
		this.noticeCode = noticeCode;
		this.noticeSub = noticeSub;
		this.noticeNote = noticeNote;
		this.noticeDate = noticeDate;
	}



	public NoticeVO(String noticeCode, String noticeSub, String noticeNote, Date noticeDate, String adminCode) {
		this.noticeCode = noticeCode;
		this.noticeSub = noticeSub;
		this.noticeNote = noticeNote;
		this.noticeDate = noticeDate;
		this.adminCode = adminCode;
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
	
	
}
