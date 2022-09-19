package hospital;

import java.sql.Date;
import java.util.Scanner;

import hospital.adminSign.AdminSignController;
import hospital.appointment.AppointmentController;
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

	private HospitalView() {
	}

	public static HospitalView getInstance() {
		return instance;
	}

	private Scanner scanner = ScannerUtil.scanner();
	private AdminVO adminSeission = new AdminVO();

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
		if (number == HomeMenu.HOME.getMenu()) {
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
		if (vo != null) {
			System.out.println(vo.getpatName() + "님 로그인 되었습니다.");
			number = HomeMenu.PATIENT.getMenu();
		} else {
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
		if (vo != null) {
			System.out.println(vo.getDocName() + "님 로그인 되었습니다.");
			number = HomeMenu.DOCTOR.getMenu();
		} else {
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
		if (vo != null) {
			adminSeission.setAdminCode(vo.getAdminCode());
			System.out.println(vo.getAdminName() + "님 로그인 되었습니다.");
			number = HomeMenu.ADMIN.getMenu();
		} else {
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

	// 전체목록
	public int getNoticeList(NoticeController controller) {
		controller.selectNoticeList().forEach(NoticeVO -> {
			System.out.printf("%s\t%s\t%s\t\n", NoticeVO.getNoticeCode(), NoticeVO.getNoticeSub(),
					NoticeVO.getNoticeDate());
		});
		return HomeMenu.NOTICE.getMenu();
	}

	// 확인할 공지
	public int searchNotice(NoticeController controller) {
		String searchWord = scanner.next();
		controller.selectNoticeList2(searchWord).forEach(NoticeVO -> {
			System.out.printf("%s\t%s\t%s\t%s\n", "제목: " + NoticeVO.getNoticeSub() + "\n" + "등록일: ",
					NoticeVO.getNoticeDate(), "관리자: " + NoticeVO.getAdminName() + "\n내용 : \n",
					NoticeVO.getNoticeNote() + "\n");
		});
//    	System.out.printf("%s\t%s\t%s\t%s\n",NoticeVO.getNoticeSub(),NoticeVO.getNoticeNote(),NoticeVO.getNoticeDate(),NoticeVO.getAdminCode());
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
		System.out.println("게시물" + sub + "이(가) 등록되었습니다.");
		number = HomeMenu.NOTICE_CHECK.getMenu();
		System.out.println();
		return number;
	}

	// 공지 수정
	public int updateNotice(NoticeController controller) {
		int number;
		number = HomeMenu.UPDATE_NOTICE.getMenu();
		String code = scanner.next();
		System.out.println("제목 : ");
		String sub = scanner.next();
		System.out.println("내용 : ");
		String note = scanner.next();
		number = controller.updateNotice(new NoticeVO(sub, note, adminSeission.getAdminCode(), code));
		System.out.println("수정되었습니다.");
		number = HomeMenu.NOTICE_CHECK.getMenu();
		return number;
	}

	// 공지 삭제
	public int deleteNotice(NoticeController controller) {
		int number;
		number = HomeMenu.DELETE_NOTICE.getMenu();
		String code = scanner.next();
		number = controller.deleteNotice(new NoticeVO(code));
		System.out.println("삭제되었습니다.");
		number = HomeMenu.NOTICE_CHECK.getMenu();
		return number;
	}

	// 관리자 공지사항 목록
	public int getAdmNoticeList(NoticeController controller) {
		controller.selectNoticeList().forEach(NoticeVO -> {
			System.out.printf("%s\t%s\t%s\t\n", NoticeVO.getNoticeCode(), NoticeVO.getNoticeSub(),
					NoticeVO.getNoticeDate());
		});
		return HomeMenu.NOTICE_CHECK.getMenu();
	}

	public int searchAppointment(AppointmentController controller) {
		String searchWord = scanner.next();
		controller.selectAppointment(searchWord).forEach(AppointmentVO -> {
			System.out.printf("%s\t%s\t%s\t%s\t%s\n", AppointmentVO.getResCode(), AppointmentVO.getResDate(),
					AppointmentVO.getPatCode(), AppointmentVO.getDocCode(), AppointmentVO.getResMemo());
		});
		return HomeMenu.APPOINTMENT.getMenu();
	}

	public int insertAppointment(AppointmentController controller) {
		System.out.println();

		return HomeMenu.APPOINTMENT.getMenu();
	}

	public int deleteAppointment(AppointmentController controller) {
		String code = scanner.next();
		controller.deleteAppointment(code);
		System.out.println("삭제되었습니다.");
		return HomeMenu.APPOINTMENT.getMenu();
	}

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

	public int searchDocAppointment(AppointmentController controller) {
		String searchWord = scanner.next();
		controller.selectAppointment(searchWord).forEach(AppointmentVO -> {
			System.out.printf("%s\t%s\t%s\t%s\t%s", AppointmentVO.getResCode(), AppointmentVO.getResDate(),
					AppointmentVO.getPatCode(), AppointmentVO.getDocCode(), AppointmentVO.getResMemo());
		});
		return HomeMenu.DOCTOR.getMenu();
	}
	
	
	//*** 환자 *** 
	// qna 전체목록
	public int getQnaList(QnaController controller) {
		controller.selectQnaList().forEach(QnaVO -> {
			System.out.printf("%s\t%s\t%s\t\n", QnaVO.getQnaCode(), QnaVO.getQnaSub(), QnaVO.getQnaDate());
		});
		return HomeMenu.QNA.getMenu();
	}
	// qna 확인할 문의 
	public int searchQna(QnaController controller) {
		String searchWord = scanner.next();
		System.out.println();
		controller.selectQnaList2(searchWord).forEach(QnaVO -> {
			System.out.printf("%s\t%s\t%s\t%s\n", "제목: " + QnaVO.getQnaSub(), "\n" + "등록일: "+ QnaVO.getQnaDate(), "\n관리자: " + QnaVO.getQnaCode(), 
					"\n내용 : " + QnaVO.getQnaNote() + "\n");
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
			System.out.printf("%s\t%s\t%s\t\n", QnaVO.getQnaCode(), QnaVO.getQnaSub(), QnaVO.getQnaDate());
		});
		return HomeMenu.QNA_ADMIN.getMenu();
	}
	// qna 확인할 문의 
	public int searchQnaAdmin(QnaController controller) {
		String searchWord = scanner.next();
		System.out.println();
		controller.selectQnaList2(searchWord).forEach(QnaVO -> {
			System.out.printf("%s\t%s\t%s\t%s\n", "제목: " + QnaVO.getQnaSub(), "\n" + "등록일: "+ QnaVO.getQnaDate(), "\n관리자: " + QnaVO.getQnaCode(), 
					"\n내용 : " + QnaVO.getQnaNote() + "\n");
		});
		return HomeMenu.QNA_ADMIN.getMenu();
	}
	// qna 삭제
	public int deleteQnaAdmin(QnaController controller) {
		int number;
		number = HomeMenu.DELETEQNA_ADMIN.getMenu();
		String code = scanner.next();

		number = controller.deleteQna(new QnaVO(code));
		System.out.println("삭제되었습니다.");
		number = HomeMenu.QNA_ADMIN.getMenu();
		return number;
	}

	// qna 답변(관리자)
	public int replyQna(ReplyController controller) {
		int number;
		number = HomeMenu.QNA_REPLY.getMenu(); //
		
		String code = scanner.next();
		
		System.out.println("code : " + code);
		
		ReplyVO replyVO = new ReplyVO();
		
		replyVO.setQnaCode(code);
		replyVO.setAdminCode(HospitalApplication.getSession3().getAdminCode());
		
		scanner.nextLine();
		System.out.println("내용:");
		String replyNote = scanner.nextLine();
		
		//System.out.println("replyVO : " + replyVO.toString());
		//number = controller.insertReply(replyVO);
		//System.out.println("insert결과 : " + number);

		//replyVO.setReplyNote(replyNote);
		//String reply = replyVO.getReplyNote();
		//number = controller.insertReply(replyVO);
		 number = controller.insertReply(new ReplyVO(code, replyNote));
		//number = controller.insertReply(new QnaVO(sub, note));
		
		System.out.println("등록되었습니다");
		number = HomeMenu.QNA_ADMIN.getMenu();
		return number;
	}

}
