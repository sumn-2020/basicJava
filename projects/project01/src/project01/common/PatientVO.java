package project01.common;

public class PatientVO {

	// 환자 db 컬럼 정보
	private String patCode;
	private String patName;
	private String patAddr;
	private String patPhone;
	private String patReg;
	private String patHiredate;
	private String patId;
	private String patPw;

	public PatientVO() {
	}

	public PatientVO(String patId) {
		this.patId = patId;
	}

	public PatientVO(String patId, String patPw) {
		this.patId = patId;
		this.patPw = patPw;
	}

	public PatientVO(String patName, String patAddr, String patPhone, String patReg, String patId, String patPw) {
		this.patName = patName;
		this.patAddr = patAddr;
		this.patPhone = patPhone;
		this.patReg = patReg;
		this.patId = patId;
		this.patPw = patPw;
	}

	public PatientVO(String patCode, String patName, String patAddr, String patPhone, String patReg, String patHiredate,
			String patId, String patPw) {
		this.patCode = patCode;
		this.patName = patName;
		this.patAddr = patAddr;
		this.patPhone = patPhone;
		this.patReg = patReg;
		this.patHiredate = patHiredate;
		this.patId = patId;
		this.patPw = patPw;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatAddr() {
		return patAddr;
	}

	public void setPatAddr(String patAddr) {
		this.patAddr = patAddr;
	}

	public String getPatPhone() {
		return patPhone;
	}

	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}

	public String getPatReg() {
		return patReg;
	}

	public void setPatReg(String patReg) {
		this.patReg = patReg;
	}

	public String getPatHiredate() {
		return patHiredate;
	}

	public void setPatHiredate(String patHiredate) {
		this.patHiredate = patHiredate;
	}

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getPatPw() {
		return patPw;
	}

	public void setPatPw(String patPw) {
		this.patPw = patPw;
	}

	// 정보초기화
	public void invalidate() {
		this.patCode = null;
		this.patName = null;
		this.patAddr = null;
		this.patPhone = null;
		this.patReg = null;
		this.patHiredate = null;
		this.patId = null;
		this.patPw = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("PatientVO{");
		builder.append("patCode=").append(patCode);
		builder.append(", patName=").append(patName).append('\'');
		builder.append(", patAddr=").append(patAddr).append('\'');
		builder.append(", patPhone=").append(patPhone).append('\'');
		builder.append(", patReg=").append(patReg).append('\'');
		builder.append(", patHiredate=").append(patHiredate).append('\'');
		builder.append(", patId=").append(patId).append('\'');
		builder.append(", patPw=").append(patPw).append('\'');
		builder.append("}");
		return builder.toString();
	}

}
