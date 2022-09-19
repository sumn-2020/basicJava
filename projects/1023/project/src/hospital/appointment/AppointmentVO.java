package hospital.appointment;

import java.sql.Date;

import hospital.join.DoctorVO;

public class AppointmentVO {
	private String resCode;
	private Date resDate;
	private String patCode;
	private String docCode;
	private String resMemo;
	private String patName;
	private String deptName;
	private String docName;
	
	public AppointmentVO() {
	}

	
	public AppointmentVO(String resCode, Date resDate, String patName, String deptName, String docName) {
		this.resCode = resCode;
		this.resDate = resDate;
		this.patName = patName;
		this.deptName = deptName;
		this.docName = docName;
	}

	
	public AppointmentVO(String resCode, Date resDate, String patCode, String docCode, String resMemo, String patName,
			String deptName, String docName) {
		this.resCode = resCode;
		this.resDate = resDate;
		this.patCode = patCode;
		this.docCode = docCode;
		this.resMemo = resMemo;
		this.patName = patName;
		this.deptName = deptName;
		this.docName = docName;
	}


	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getResMemo() {
		return resMemo;
	}

	public void setResMemo(String resMemo) {
		this.resMemo = resMemo;
	}


	public String getPatName() {
		return patName;
	}


	public void setPatName(String patName) {
		this.patName = patName;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	
	
	
}
