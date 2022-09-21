package hospital;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import hospital.adminSign.AdminSignController;
import hospital.appointment.AppointmentController;
import hospital.appointment.AppointmentVO;
import hospital.common.HomeMenu;
import hospital.common.ScannerUtil;
import hospital.docSign.DocSignController;
import hospital.join.AdminVO;
import hospital.join.DoctorVO;
import hospital.join.JoinController;
import hospital.join.PatientVO;
import hospital.notice.NoticeController;
import hospital.notice.NoticeVO;
import hospital.patSign.PatSignController;
import hospital.qna.QnaController;
import hospital.qna.QnaVO;
import hospital.reply.ReplyController;
import hospital.reply.ReplyVO;

public class HospitalView {
    private static HospitalView instance = new HospitalView();
    private HospitalView() {}
    public static HospitalView getInstance() {
        return instance;
    }
    
    private Scanner scanner = ScannerUtil.scanner();
    private PatientVO patientSession = new PatientVO();
    private AdminVO adminSeission = new AdminVO();
    private AppointmentVO appointSession = new AppointmentVO();

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
    
    
    
    // 환자 회원가입
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
    	String patCode = "";
    	number = controller.join(new PatientVO(name, addr, phone, reg, id, pw));
    	if(number == HomeMenu.HOME.getMenu()) {
    		System.out.println("회원가입이 완료되었습니다. 로그인 해주세요.");
    	} else {
    		System.out.println("회원가입 실패! 다시 하십시오.");
    		number = HomeMenu.JOIN.getMenu();
    	}
    	return number;
    }
    
    //환자 로그인
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

    //의사 로그인
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

    //관리자 로그인
    public int login3(AdminSignController controller) {
    	int number;
    	System.out.print("아이디 : ");
    	String id = scanner.next();
    	System.out.print("비밀번호: ");
    	String pw = scanner.next();
    	AdminVO vo = controller.signIn(new AdminVO(id, pw));
    	if(vo!=null) {
    		adminSeission.setAdminCode(vo.getAdminCode());
    		System.out.println(vo.getAdminName() + "님 로그인 되었습니다.");
    		number = HomeMenu.ADMIN.getMenu();
    	} else {
    		System.out.println("로그인 정보가 일치하지 않습니다.");
    		number = HomeMenu.HOME.getMenu();
    	}
    	return number;
    }

    //개인정보조회
    public int getPatientInfo(JoinController controller) {
    	PatientVO patient = controller.findPatUser();
    	System.out.printf("아이디: %s\n", patient.getpatId());
    	System.out.printf("이름: %s\n", patient.getpatName());
    	System.out.printf("주소: %s\n", patient.getpatAddr());
    	System.out.printf("전화번호: %s\n", patient.getpatPhone());
    	return HomeMenu.MYPAGE.getMenu();
    }



    //개인정보수정
    public int modifyInfo(JoinController controller, HomeMenu menu) {
    	scanner.nextLine();
    	int resultName = controller.modifyInfo(scanner.nextLine(), menu);
    	if (resultName == 1) {
    		System.out.println("정상적으로 수정되었습니다.");
    	}
    	return HomeMenu.MYPAGE.getMenu();
    }
    
    //비밀번호변경
    public int changePassword(JoinController controller) {
    	scanner.nextLine();
    	String newPassword = scanner.nextLine();
    	System.out.print("비밀번호 확인을 위해 다시 한번 입력해주세요: ");
    	String confirmPassword = scanner.nextLine();
    	if (newPassword.equals(confirmPassword)) {
    		controller.modifyPassword(confirmPassword);
    		System.out.println("비밀번호가 변경되었습니다.");
    	} else {
    		System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다.");
    	}
    	return HomeMenu.MYPAGE.getMenu();
    }


    
    //공지사항 전체목록
    public int getNoticeList(NoticeController controller) {
    	controller.selectNoticeList().forEach(NoticeVO ->{
    		System.out.printf("%s\t%s\t%s\t\n",NoticeVO.getNoticeCode(), NoticeVO.getNoticeSub(), NoticeVO.getNoticeDate());
    	});
    	return HomeMenu.NOTICE.getMenu(); 
    }
    //공지사항 선택
    public int searchNotice(NoticeController controller) {
    	String searchWord = scanner.next();
    	controller.selectNoticeList2(searchWord).forEach(NoticeVO->{
    		System.out.printf("%s\t%s\t%s\t%s\n","제목: "+NoticeVO.getNoticeSub()+"\n"+"등록일: ",NoticeVO.getNoticeDate(),"관리자: "+NoticeVO.getAdminName()+"\n내용 : \n",NoticeVO.getNoticeNote()+"\n");
    	});
    	return HomeMenu.NOTICE.getMenu();
    }


    // 공지사항 등록
    public int insertNotice(NoticeController controller) {
    	int number;
    	System.out.print("제목: ");
    	String sub = scanner.next(); 
    	System.out.println();
    	System.out.println("내용: "); 
    	String note = scanner.next();
    	number = controller.insertNotice(new NoticeVO(sub, note, adminSeission.getAdminCode())); 
    	System.out.println("게시물 [" + sub + "] 이(가) 등록되었습니다.");
    	number = HomeMenu.NOTICE_CHECK.getMenu();
    	System.out.println();
    	return number;
    }
    //공지 수정
    public int updateNotice(NoticeController controller) {
    	int number;
    	number=HomeMenu.UPDATE_NOTICE.getMenu();
    	String code = scanner.next();
    	System.out.println("제목 : ");
    	String sub= scanner.next();
    	System.out.println("내용 : ");
    	String note= scanner.next();
    	number = controller.updateNotice(new NoticeVO(sub, note, adminSeission.getAdminCode(),code)); 
    	System.out.println("수정되었습니다.");
    	number = HomeMenu.NOTICE_CHECK.getMenu();
    	return number;
    }
    //공지 삭제
    public int deleteNotice(NoticeController controller) {
    	int number;
    	number= HomeMenu.DELETE_NOTICE.getMenu();
    	String code = scanner.next();
    	number = controller.deleteNotice(new NoticeVO(code));
    	System.out.println("삭제되었습니다.");
    	number = HomeMenu.NOTICE_CHECK.getMenu();
    	return number;
    }

    //관리자 공지사항 목록 
    public int getAdmNoticeList(NoticeController controller) {
    	controller.selectNoticeList().forEach(NoticeVO ->{
    		System.out.printf("%s\t%s\t%s\t\n",NoticeVO.getNoticeCode(), NoticeVO.getNoticeSub(), NoticeVO.getNoticeDate());
    	});
    	return HomeMenu.NOTICE_CHECK.getMenu(); 
    }

    
    
    //환자예약 조회
//    public int searchAppointment(AppointmentController controller) {
//    	System.out.println("확인할 환자의 코드를 입력하세요: ");
//    	String searchWord = scanner.next();
//    	
////    	List<AppointmentVO> appointmentVOList = controller.selectAppointment(searchWord);
////    	System.out.println("appointmentVOList : " + appointmentVOList);
//    	
//    	controller.selectAppointment(searchWord).forEach(AppointmentVO->{
//    		System.out.printf("%s\t%s\t%s\t%s\t%s\n",AppointmentVO.getResCode(),AppointmentVO.getResDate(),AppointmentVO.getPatName(),AppointmentVO.getDeptName(),AppointmentVO.getDocName());
//    	});
//    	return HomeMenu.APPOINTMENT.getMenu();
//    }
    
  public int findAppointment(AppointmentController controller) {
	
	controller.findAppointment().forEach(appointmentVO->{
		System.out.printf("%s\t%s\t%s\t%s\t%s\n",appointmentVO.getResCode(),appointmentVO.getPatName(),appointmentVO.getResDate(), appointmentVO.getDeptName(),appointmentVO.getDocName());
	});
	return HomeMenu.APPOINTMENT.getMenu();
}

    
    //환자예약 등록
    public int insertAppointment(AppointmentController controller) {
    	int number;
        System.out.println();
        System.out.print("자신의 환자코드를 입력하세요: ");
        String patCode = scanner.next();
        System.out.print("원하는 의사코드를 입력하세요: ");
        String docCode = scanner.next();
        System.out.print("간단한 증상을 작성하세요: ");
        String resMemo = scanner.next();
        number = controller.insertAppointment(new AppointmentVO(null, null, patCode, docCode, resMemo)); 
        System.out.println("예약이 등록되었습니다.");
        number = HomeMenu.APPOINTMENT.getMenu();
        return number;
    }
    
    //환자예약 삭제
    public int deleteAppointment(AppointmentController controller) {
    	String code = scanner.next();
    	controller.deleteAppointment(code);
    	System.out.println("삭제되었습니다.");
    	return HomeMenu.APPOINTMENT.getMenu();
    }
    
    //환자예약 변경
    public int updateAppointment(AppointmentController controller) {
    	System.out.println("자신의 환자코드를 입력해주세요: ");
    	String patCode = scanner.next();
    	System.out.println("바꿀 날짜를 입력해주세요(yyyy-mm-dd형식): ");
    	String resDate = scanner.next();
    	System.out.println("변경하고 싶은 의사의 코드를 입력해주세요: ");
    	String docCode = scanner.next();

    	controller.updateAppointment(Date.valueOf(resDate), docCode, patCode);
    	return HomeMenu.APPOINTMENT.getMenu();
    }

    //의사예약 조회
    public int searchDocAppointment(AppointmentController controller) {
    	String searchWord = scanner.next();
    	controller.selectDocAppointment(searchWord).forEach(AppointmentVO->{
    		System.out.printf("%s\t%s\t%s\t%s\t%s",AppointmentVO.getDocName(),AppointmentVO.getResCode(),AppointmentVO.getResDate(),AppointmentVO.getPatName(),AppointmentVO.getResMemo());
    	});
    	return HomeMenu.DOCTOR.getMenu();
    }

	//*** 환자 *** 
	// qna 전체목록
	public int getQnaList(QnaController controller) {
		controller.selectQnaList().forEach(QnaVO -> {
			System.out.printf("%s\t%s\t%s\t%s\t\n", QnaVO.getQnaCode(), QnaVO.getQnaSub(), QnaVO.getQnaDate(),  QnaVO.getPatName());
		});
		return HomeMenu.QNA.getMenu();
	}
	// qna 확인할 문의 
	public int searchQna(QnaController controller) {
		String searchWord = scanner.next();
		System.out.println();
		controller.selectQnaList2(searchWord).forEach(QnaVO -> {
			System.out.printf("%s\t%s\t%s\t%s\t%s\n", "제목: " + QnaVO.getQnaSub(), "\n" + "등록일: "+ QnaVO.getQnaDate(), "\n작성자: " + QnaVO.getPatName(), 
					"\n내용 : " + QnaVO.getQnaNote(), "\n" + "답변내용: " + QnaVO.getReplyNote());
		});
		return HomeMenu.QNA.getMenu();
	}
	// qna 등록
	public int insertQna(QnaController controller) {
		int number;
		System.out.print("제목: ");
		String sub = scanner.next();
		System.out.println("내용: ");
		String note = scanner.next();

		number = controller.insertQna(new QnaVO(sub, note));
		System.out.println("문의 글이 등록되었습니다");
		number = HomeMenu.QNA.getMenu();
		return number;
	}
	// qna 삭제
	public int deleteQna(QnaController controller) {
		int number;
		number = HomeMenu.DELETE_QNA.getMenu();
		String code = scanner.next();

		number = controller.deleteQna(new QnaVO(code));
		System.out.println("삭제되었습니다.");
		number = HomeMenu.QNA.getMenu();
		return number;
	}

	
	
	//*** 관리자 *** 
	// qna 전체목록
	public int getQnaListAdmin(QnaController controller) {
		controller.selectQnaList().forEach(QnaVO -> {
			System.out.printf("%s\t%s\t%s\t%s\t\n", QnaVO.getQnaCode(), QnaVO.getQnaSub(), QnaVO.getQnaDate(),  QnaVO.getPatName());
		});
		return HomeMenu.QNA_ADMIN.getMenu();
	}


	// qna 답변(관리자)
	public int replyQna(ReplyController controller) {
		try {
			int number;
			number = HomeMenu.QNA_REPLY.getMenu(); //
			String code = scanner.next();
			//System.out.println("code : " + code);
			ReplyVO replyVO = new ReplyVO();
			replyVO.setQnaCode(code);
			replyVO.setAdminCode(HospitalApplication.getSession3().getAdminCode());
			
			scanner.nextLine();
			System.out.println("답변내용:");
			String replyNote = scanner.nextLine();
			 number = controller.insertReply(new ReplyVO(code, replyNote));
			
			System.out.println("등록되었습니다");
			number = HomeMenu.QNA_ADMIN.getMenu();
			return number;
		} catch (Exception e) {
			System.out.println("이미 답변이 존재합니다.");
		}
		return HomeMenu.QNA_ADMIN.getMenu();
	}



	// 답변 확인
	public int searchReplyAdmin(ReplyController controller) {
		String searchWord = scanner.next();
		System.out.println();
		controller.selectReplyList(searchWord).forEach(ReplyVO -> {
			System.out.printf("%s\t%s\t%s\t%s\t\n", "제목: " + ReplyVO.getQnaSub(), "\n" + "등록일: "+ ReplyVO.getQnaDate(),  
					"\n내용 : " + ReplyVO.getQnaNote(), "\n" + "답변: " + ReplyVO.getReplyNote()  + "\n");
		});
		return HomeMenu.QNA_ADMIN.getMenu();
	}




}
