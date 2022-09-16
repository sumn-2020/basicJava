

public class HospitalView {
	
	//싱글톤
	private static HospitalView instance = new HospitalView();
	private HospitalView() {}
	public static HospitalView getInstance() {
		return instance;
	}

	//첫화면
	public void init() {
		System.out.println("=== 다사랑 병원에 오신 것을 환영합니다 ===");
		System.out.println();
		System.out.println("1.로그인|2.회원가입|3.공지사항|0.종료");
		System.out.print("메뉴를 입력하세요 : ");
	}

}
