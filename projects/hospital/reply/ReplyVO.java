package hospital.reply;

import java.sql.Date;

public class ReplyVO {
	private String qnaCode;
	private String replyNote; //답변내용
	private Date replyDate;
	private String adminCode; //관리자코드
	
	public ReplyVO() {
		// TODO Auto-generated constructor stub
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

	public String getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getReplyNote() {
		return replyNote;
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
