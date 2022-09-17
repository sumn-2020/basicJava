package project01;

import project01.common.HomeMenu;
import project01.common.MenuNotFoundException;
import project01.join.JoinController;
import project01.join.JoinView;
import project01.sign.SignController;
import project01.sign.SignView;

public class Home {
	
	//컨트롤러 속 싱글톤 가져오기 
	private SignController signController = SignController.getInstance(); //로그인, 로그아웃 컨트롤러 불러오기
	private JoinController joinController = JoinController.getInstance(); //회원가입 컨트롤

	// view 파일 속 싱글톤 가져오기
	private SignView viewSign = SignView.getInstance();
	private JoinView viewJoin = JoinView.getInstance();

	public void initialize() {
		home(viewSign.init()); //home 메소드 호출 
	}

	private void home(int number)  {
		loop:
		while(true) {
			try {
				HomeMenu menu = HomeMenu.findMenu(number); //메뉴 번호 출력 반복
				System.out.print(menu.getMenuString()); // 메뉴명 출력 반복 

				switch(menu) {
					case HOME:
					case PATIENT: //환자일경우
					case DOCTOR: //의사일경우
					case ADMINISTOR: //관리자일경우
						number = viewSign.getMenu(); //해당 메뉴 선택  
						break;
					case JOIN:
						number = viewJoin.join(joinController);
						break;
					case LOGIN:
						number = viewSign.login(signController);
						break;
					case LOGOUT:
						number = signController.signout();
						break;
					case QUIT:
						break loop;
				}
			} catch (MenuNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.print(HomeMenu.HOME.getMenuString());
			}
			System.out.println();
		}
	}
}
