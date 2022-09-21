package hospital.qna;

public class QnaVO {
	private String qnaCode;
	private String qnaSub;
	private String qnaNote;
	private String qnaDate;
	private String patCode;
	private String patName;
	private String replyNote; // 답변내용

	public QnaVO() {
	}

	public QnaVO(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public QnaVO(String qnaSub, String qnaNote) {
		this.qnaSub = qnaSub;
		this.qnaNote = qnaNote;
	}

	public QnaVO(String qnaCode, String qnaSub, String qnaNote, String qnaDate, String patCode) {
		this.qnaCode = qnaCode;
		this.qnaSub = qnaSub;
		this.qnaNote = qnaNote;
		this.qnaDate = qnaDate;
		this.patCode = patCode;
	}


	public String getReplyNote() {
		return replyNote == null ? "답변없음" : replyNote;
	}

	public void setReplyNote(String replyNote) {
		this.replyNote = replyNote;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getQnaSub() {
		return qnaSub;
	}

	public void setQnaSub(String qnaSub) {
		this.qnaSub = qnaSub;
	}

	public String getQnaNote() {
		return qnaNote;
	}

	public void setQnaNote(String qnaNote) {
		this.qnaNote = qnaNote;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public void invalidate() {
		this.qnaCode = null;
		this.qnaSub = null;
		this.qnaNote = null;
		this.qnaDate = null;
		this.patCode = null;
	}
}
