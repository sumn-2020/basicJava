package project01.common;

import java.util.Scanner;

public enum HomeMenu {
	
	//*** enum ***
	HOME(-1, "1.로그인|2.회원가입|3.공지사항|0.종료\n메뉴를 선택하세요: "),
	QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),
	LOGOUT(9, "로그아웃 되었습니다!\n"),
	
	//로그인1
	LOGIN(1, "아이디와 비밀번호를 입력하세요.\n"),
	PATIENT(11, "111.예약페이지|112.마이페이지|113.문의게시판|9.로그아웃 \n메뉴를 선택하세요: "),
	DOCTOR(12, "121. 예약조회|9.로그아웃\n메뉴를 선택하세요: "),
	ADMINISTOR(13, "131. 공지사항관리|132. 문의 게시판 답변|9.로그아웃\n메뉴를 선택하세요: "),
	
	JOIN(2, "회원가입에 필요한 정보를 입력합니다.\n");
	
	
	//필드와 생성자
	private final int menu;
	private final String menuString;
	HomeMenu(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}
	//getter
	public int getMenu() {
		return menu;
	}
	public String getMenuString() {
		return menuString;
	}

	//메뉴 선택, 이상한 메뉴 선택시 MenuNotFoundException 에러 출력
	public static HomeMenu findMenu(int number) throws MenuNotFoundException {
		for(HomeMenu menu : values()) {
			if(menu.getMenu() == number) {
					return menu;
			}
		}
		throw new MenuNotFoundException("선택하신 메뉴가 없습니다."); 
	}
	
	//ScannerUtil받아오기
	public void display(Scanner scanner) {}
	
	

}
