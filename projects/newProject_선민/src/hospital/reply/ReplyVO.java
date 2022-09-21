package hospital.reply;

import java.sql.Date;

public class ReplyVO {
	private String qnaCode;
	private String qnaSub; // 글제목
	private String qnaDate; // 작성일
	private String qnaNote; // 문의글
	private String replyNote; // 답변내용
	private Date replyDate;
	private String adminCode; // 관리자코드
	private String patCode; // 환자코드
	private String patName; 

	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public void setQnaSub(String qnaSub) {
		this.qnaSub = qnaSub;
	}

	public ReplyVO(String replyNote) {
		this.replyNote = replyNote;
	}

	public ReplyVO(String qnaCode, String replyNote) {
		this.qnaCode = qnaCode;
		this.replyNote = replyNote;
	}

	public ReplyVO(String qnaCode, String replyNote, String adminCode) {
		this.qnaCode = qnaCode;
		this.replyNote = replyNote;
		this.adminCode = adminCode;
	}
	

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getQnaNote() {
		return qnaNote;
	}

	public void setQnaNote(String qnaNote) {
		this.qnaNote = qnaNote;
	}

	public String getQnaSub() {
		return qnaSub;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getReplyNote() {
		return replyNote == null ? "답변없음" : replyNote;
	}

	public void setReplyNote(String replyNote) {
		this.replyNote = replyNote;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyVO [qnaCode=");
		builder.append(qnaCode);
		builder.append(", replyNote=");
		builder.append(replyNote);
		builder.append(", replyDate=");
		builder.append(replyDate);
		builder.append(", adminCode=");
		builder.append(adminCode);
		builder.append("]");
		return builder.toString();
	}

}
