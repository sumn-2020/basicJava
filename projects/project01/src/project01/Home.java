package project01;

import project01.common.HomeMenu;
import project01.common.MenuNotFoundException;
import project01.sign.SignController;

public class Home {
	
	private SignController signController = SignController.getInstance(); //로그인, 로그아웃 컨트롤러 불러오기 

	// view 파일 속 싱글톤 가져오기
	private HospitalView view = HospitalView.getInstance();

	public void initialize() {
		home(view.init()); //home 메소드 호출 
	}

	private void home(int number)  {
		loop:
		while(true) {
			try {
				HomeMenu menu = HomeMenu.findMenu(number); //메뉴 번호 출력 반복
				System.out.print(menu.getMenuString()); // 메뉴명 출력 반복 
				switch(menu) {
					case HOME:
					case PATIENT:
					case DOCTOR:
					case ADMINISTOR:
						number = view.getMenu(); //해당 메뉴 선택  
						break;
					case LOGIN:
						number = view.login(signController);
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
