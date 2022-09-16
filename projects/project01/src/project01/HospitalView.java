package project01;

import java.util.Scanner;

import project01.common.HomeMenu;
import project01.common.ScannerUtil;
import project01.join.PatientVO;
import project01.sign.SignController;

public class HospitalView {
	
	//싱글톤
	private static HospitalView instance = new HospitalView();
	private HospitalView() {}
	public static HospitalView getInstance() {
		return instance;
	}
	
	//scanner 불러오기 - 메모리 아끼기 위해서 
	private Scanner scanner = ScannerUtil.scanner();
	
	//첫화면
	public int init() {
		System.out.println("다사랑 병원에 오신 것을 환영합니다!");
		System.out.println();
		System.out.println(HomeMenu.HOME.getMenuString()); //enum : 홈 메뉴 출력
		return scanner.nextInt();
	}
	//메뉴 입력 숫자 
	public int getMenu() {
		return scanner.nextInt();
	}	
	
	
	//로그인 
	public int login(SignController controller) {
		int number;
		System.out.print("아이디: ");
		String userId = scanner.next();
		System.out.print("비밀번호 :");
		String userPw = scanner.next();
		
		PatientVO vo = controller.signIn(new PatientVO(userId, userPw));
		if(vo != null) {
			System.out.println(vo.getPatName() + "님 로그인되었습니다.");
			number = HomeMenu.PATIENT.getMenu();
		}else {
			System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}
	
	
	
	
	
	
	
}
