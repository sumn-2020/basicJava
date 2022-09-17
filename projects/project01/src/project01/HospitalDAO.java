package project01;

public class HospitalDAO {

	// 싱글톤
	private static HospitalDAO instance;

	private HospitalDAO() {
	}

	public static HospitalDAO getInstance() {
		return instance;
	}

}
