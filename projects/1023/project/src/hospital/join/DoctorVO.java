package hospital.join;

public class DoctorVO {
	private String docCode;
	private String docName;
	private String deptCode;
	private String docOff;
	private String docLocation;
	private String docId;
	private String docPw;
	
	public DoctorVO() {
	}

	public DoctorVO(String docId, String docPw) {
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
	
	public void invalidate() {
		this.docCode = null;
		this.docName = null;
		this.deptCode = null;
		this.docOff = null;
		this.docLocation = null;
		this.docId = null;
		this.docPw = null;
	}
}
