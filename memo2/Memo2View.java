package memo2;

import java.sql.SQLException;
import java.util.List;

//MVC(Model : Service(요청처리) / DAO(DB연동), View : View(사용자화면), Controller : Controller(사용자의 요청받음))
public class Memo2View {
	private static Memo2View instance = new Memo2View();
	private Memo2View() {}
	public  static Memo2View getInstance() {
		return instance;
	}
	
	Memo2Controller memo2Controller = Memo2Controller.getInstance();
	
	//첫화면
	public void init() {
		System.out.println("1.목록|2.메모|3.등록|4.수정|5.삭제| 0.종료");
		System.out.print("메뉴를 입력하세요 : ");
	}
	
	//MEMO 테이블의 목록을 DB에서 가져와서(C -> S -> D -> DB) 사용자에게 보여주자(View)
	public void viewMemos() throws SQLException {
		List<Memo2VO> list = this.memo2Controller.getMemos();
		for(Memo2VO vo : list) {
			System.out.println(vo.toString());
		}
	}
}







