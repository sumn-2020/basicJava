package hospital.join;

public class PatientVO {
	private String patCode;
	private String patName;
	private String patAddr;
	private String patPhone;
	private String patReg;
	private String patId;
	private String patPw;
	
	public PatientVO() {
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



	public String getpatCode() {
		return patCode;
	}


	public void setpatCode(String patCode) {
		this.patCode = patCode;
	}


	public String getpatName() {
		return patName;
	}


	public void setpatName(String patName) {
		this.patName = patName;
	}


	public String getpatAddr() {
		return patAddr;
	}


	public void setpatAddr(String patAddr) {
		this.patAddr = patAddr;
	}


	public String getpatPhone() {
		return patPhone;
	}


	public void setpatPhone(String patPhone) {
		this.patPhone = patPhone;
	}


	public String getpatReg() {
		return patReg;
	}


	public void setpatReg(String patReg) {
		this.patReg = patReg;
	}

	public String getpatId() {
		return patId;
	}


	public void setpatId(String patId) {
		this.patId = patId;
	}


	public String getpatPw() {
		return patPw;
	}


	public void setpatPw(String patPw) {
		this.patPw = patPw;
	}
	
	public void invalidate() {
		this.patCode = null;
		this.patName = null;
		this.patAddr = null;
		this.patPhone = null;
		this.patReg = null;
		this.patId = null;
		this.patPw = null;
	}
	
	
}
