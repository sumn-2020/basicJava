package hospital.appointment;

import java.sql.Date;

import hospital.join.DoctorVO;

public class AppointmentVO {
	private String resCode;
	private Date resDate;
	private String patCode;
	private String docCode;
	private String resMemo;
	
	
	public AppointmentVO() {
	}

	public AppointmentVO(String resCode, Date resDate, String patCode, String docCode, String resMemo) {
		this.resCode = resCode;
		this.resDate = resDate;
		this.patCode = patCode;
		this.docCode = docCode;
		this.resMemo = resMemo;
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
	
	
	
	
}
