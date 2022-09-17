package hospital.docSign;

import hospital.join.DoctorVO;

public class DocSignService {
	private static DocSignService instance = new DocSignService();
	public static DocSignService getInstance() {
		return instance;
	}
	
	private DocSignService() {}
	
	private DocSignDAO dao = DocSignDAO.getInstance();
	
	public DoctorVO findDocUser(DoctorVO vo) {
		return dao.findDocUser(vo);
	}
}
