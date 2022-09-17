package project01.join;

import java.util.Scanner;

import project01.common.HomeMenu;
import project01.common.PatientVO;
import project01.common.ScannerUtil;

public class JoinView {

	private Scanner scanner = ScannerUtil.scanner();
	
	// 싱글톤
	private static JoinView instance = new JoinView();
	private JoinView() {
	}
	public static JoinView getInstance() {
		return instance;
	}


	//회원가입
	public int join(JoinController controller) {
		int number;
		
		System.out.print("이름 : " );
		String patName = scanner.next();
		System.out.print("전화번호 : ");
		String patPhone = scanner.next();		
		System.out.print("주민번호 : ");
		String patReg = scanner.next();		
		System.out.print("주소 : ");
		String patAddr = scanner.next();		
		System.out.print("아이디 : ");
		String patId = scanner.next();		
		System.out.print("비밀번호 : ");
		String patPw = scanner.next();		

		number = controller.join(new PatientVO(patName, patPhone, patReg, patAddr, patId, patPw));
		if(number == HomeMenu.HOME.getMenu()) {
			System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
		}else {
			System.out.print("회원가입실패! 다시 회원가입을 하시겠습니까? ");
			String inputFlag = scanner.nextLine();
			System.out.println("y 또는 n을 입력 : " + inputFlag);
			if(inputFlag.equalsIgnoreCase("y")) { //equalsIgnoreCase : 대소문자 구분안함
				System.out.println();
				number = HomeMenu.JOIN.getMenu();
			}else {
				System.out.println();
				number = HomeMenu.HOME.getMenu();
			}
		}
		return number;
	}

}
