package memo2;

import java.sql.SQLException;
import java.util.List;

import memo.MemoController;
import memo.MemoVO;

public class Memo2Controller {
	//싱글톤선언(ppp)
	private static Memo2Controller instance = new Memo2Controller();
	private Memo2Controller() {}
	public  static Memo2Controller getInstance() {
		return instance;
	}
	
	//싱글톤객체 생성 => 메모리에 한 번만 객체 생성
	Memo2Service memo2Service = Memo2Service.getInstance();
	
	//MEMO 테이블의 목록을 가져옴
	public List<Memo2VO> getMemos() throws SQLException{
		return this.memo2Service.getMemos();
	}
}
