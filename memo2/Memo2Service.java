package memo2;

import java.sql.SQLException;
import java.util.List;

//controller와 DAO의 연결고리
public class Memo2Service {
	//싱글톤 선언(ppp)
	private static Memo2Service instance = new Memo2Service();
	private Memo2Service() {}
	public  static Memo2Service getInstance() {
		return instance;
	}
	
	//싱글톤으로 객체 생성
	Memo2DAO memo2DAO = Memo2DAO.getInstance();
	
	//MEMO 테이블의 목록을 가져옴
	public List<Memo2VO> getMemos() throws SQLException{
		return this.memo2DAO.getMemos();
	}
}
