package project01.join;

public class DoctorVO {
	private String docCode;
	private String docName;
	private String deptCode;
	private String docOff;
	private String docLocation;
	private String docId;
	private String docPw;

	public DoctorVO() {
		// TODO Auto-generated constructor stub
	}

	public DoctorVO(String docId, String docPw) {
		this.docId = docId;
		this.docPw = docPw;
	}
	
	

	public DoctorVO(String docCode, String docName, String deptCode, String docOff, String docLocation, String docId,
			String docPw) {
		this.docCode = docCode;
		this.docName = docName;
		this.deptCode = deptCode;
		this.docOff = docOff;
		this.docLocation = docLocation;
		this.docId = docId;
		this.docPw = docPw;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDocOff() {
		return docOff;
	}

	public void setDocOff(String docOff) {
		this.docOff = docOff;
	}

	public String getDocLocation() {
		return docLocation;
	}

	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocPw() {
		return docPw;
	}

	public void setDocPw(String docPw) {
		this.docPw = docPw;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("DoctorVO{");
		builder.append("docCode=").append(docCode).append('\'');
		builder.append(", docName=").append(docName).append('\'');
		builder.append(", deptCode=").append(deptCode).append('\'');
		builder.append(", docOff=").append(docOff).append('\'');
		builder.append(", docLocation=").append(docLocation).append('\'');
		builder.append(", docId=").append(docId).append('\'');
		builder.append(", docPw=").append(docPw).append('\'');
		builder.append("}");
		return builder.toString();
	}


}
