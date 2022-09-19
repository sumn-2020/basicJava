package hospital.qna;

public class QnaVO {
	private String qnaCode;
	private String qnaSub;
	private String qnaNote;
	private String qnaDate;
	private String patCode;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QnaVO [qnaCode=");
		builder.append(qnaCode);
		builder.append(", qnaSub=");
		builder.append(qnaSub);
		builder.append(", qnaNote=");
		builder.append(qnaNote);
		builder.append(", qnaDate=");
		builder.append(qnaDate);
		builder.append(", patCode=");
		builder.append(patCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
