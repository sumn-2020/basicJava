package hospital.join;

public class AdminVO {
	private String adminCode;
	private String adminName;
	private String adminId;
	private String adminPw;
	
	public AdminVO() {
	}

	public AdminVO(String adminId, String adminPw) {
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	public void invalidate() {
		this.adminCode = null;
		this.adminName = null;
		this.adminId = null;
		this.adminPw = null;
	}
}
