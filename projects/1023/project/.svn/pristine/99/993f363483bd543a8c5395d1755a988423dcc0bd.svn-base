package hospital;

import java.util.Scanner;

import hospital.adminSign.AdminSignController;
import hospital.common.HomeMenu;
import hospital.common.ScannerUtil;
import hospital.docSign.DocSignController;
import hospital.join.AdminVO;
import hospital.join.DoctorVO;
import hospital.join.JoinController;
import hospital.join.PatientVO;
import hospital.notice.NoticeController;
import hospital.patSign.PatSignController;

public class HospitalView {
    private static HospitalView instance = new HospitalView();
    private HospitalView() {}
    public static HospitalView getInstance() {
        return instance;
    }
    
    private Scanner scanner = ScannerUtil.scanner();
    
    public int init() {
    	System.out.println("####다사랑 병원 예약 시스템입니다####");
    	System.out.print(HomeMenu.HOME.getMenuString());
    	return scanner.nextInt();
    }
    
    public int getMenu() {
    	return scanner.nextInt();
    }
    
    public int getLogin() {
    	System.out.println(HomeMenu.CHOOSELOGIN.getMenuString());
    	return scanner.nextInt();
    }
    
    public int join(JoinController controller) {
    	int number;
    	System.out.print("아이디: ");
    	String id = scanner.next();
    	System.out.print("비밀번호: ");
    	String pw = scanner.next();
    	System.out.print("이름: ");
    	String name = scanner.next();
    	System.out.print("주민번호(앞자리6자리 + 뒷자리1자리): ");
    	String reg = scanner.next();
    	System.out.print("전화번호: ");
    	String phone = scanner.next();
    	System.out.print("주소: ");
    	String addr = scanner.next();
    	number = controller.join(new PatientVO(name, addr, phone, reg, id, pw));
    	if(number == HomeMenu.HOME.getMenu()) {
    		System.out.println("회원가입이 완료되었습니다. 로그인 해주세요.");
    	} else {
    		System.out.println("회원가입 실패! 다시 하십시오.");
    		number = HomeMenu.JOIN.getMenu();
    	}
    	return number;
    }
    
    public int login(PatSignController controller) {
    	int number;
    	System.out.print("아이디 : ");
    	String id = scanner.next();
    	System.out.print("비밀번호: ");
    	String pw = scanner.next();
    	PatientVO vo = controller.signIn(new PatientVO(id, pw));
    	if(vo!=null) {
    		System.out.println(vo.getpatName() + "님 로그인 되었습니다.");
    		number = HomeMenu.PATIENT.getMenu();
    	}else {
    		System.out.println("로그인 정보가 일치하지 않습니다.");
    		number = HomeMenu.HOME.getMenu();
    	}
    	return number;
    }
    
    public int login2(DocSignController controller) {
    	int number;
    	System.out.print("아이디 : ");
    	String id = scanner.next();
    	System.out.print("비밀번호: ");
    	String pw = scanner.next();
    	DoctorVO vo = controller.signIn(new DoctorVO(id, pw));
    	if(vo!=null) {
    		System.out.println(vo.getDocName() + "님 로그인 되었습니다.");
    		number = HomeMenu.DOCTOR.getMenu();
    	}else {
    		System.out.println("로그인 정보가 일치하지 않습니다.");
    		number = HomeMenu.HOME.getMenu();
    	}
    	return number;
    }
    
    public int login3(AdminSignController controller) {
    	int number;
    	System.out.print("아이디 : ");
    	String id = scanner.next();
    	System.out.print("비밀번호: ");
    	String pw = scanner.next();
    	AdminVO vo = controller.signIn(new AdminVO(id, pw));
    	if(vo!=null) {
    		System.out.println(vo.getAdminName() + "님 로그인 되었습니다.");
    		number = HomeMenu.ADMIN.getMenu();
    	}else {
    		System.out.println("로그인 정보가 일치하지 않습니다.");
    		number = HomeMenu.HOME.getMenu();
    	}
    	return number;
    }
    
    public int modifyInfo(JoinController controller, HomeMenu menu) {
    	scanner.nextLine();
    	int resultName = controller.modifyInfo(scanner.nextLine(), menu);
    	if (resultName == 1) {
    		System.out.println("정상적으로 수정되었습니다.");
    	}
    	return HomeMenu.MYPAGE.getMenu();
    }
    
    public int getNoticeList(NoticeController controller) {
    	controller.selectNoticeList().forEach(NoticeVO ->{
    		System.out.printf("%s\t%s\t%s\t\n",NoticeVO.getNoticeCode(), NoticeVO.getNoticeSub(), NoticeVO.getNoticeDate());
    	});
    	return HomeMenu.NOTICE.getMenu();
    }
    
    public int searchNotice(NoticeController controller) {
    	String searchWord = scanner.next();
    	controller.selectNoticeList2(searchWord).forEach(NoticeVO->{
    		System.out.printf("%s\t%s\t%s\t%s\n",NoticeVO.getNoticeSub(),NoticeVO.getNoticeNote(),NoticeVO.getNoticeDate(),NoticeVO.getAdminCode());
    	});
//    	System.out.printf("%s\t%s\t%s\t%s\n",NoticeVO.getNoticeSub(),NoticeVO.getNoticeNote(),NoticeVO.getNoticeDate(),NoticeVO.getAdminCode());
    	return HomeMenu.NOTICE.getMenu();
    }
    

    
}
