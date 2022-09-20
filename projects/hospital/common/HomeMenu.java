package hospital.common;

import java.util.Scanner;

public enum HomeMenu {
	HOME(-1, "1.로그인\t2.회원가입\t3.공지사항\t0.프로그램 종료\n메뉴를 선택하세요: "),
	CHOOSELOGIN(1, "로그인할 사용자를 정하십시오.\n11.환자로그인\t12.의사로그인\t13.관리자로그인"),
    QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),
    PATLOGIN(11, "[환자 로그인]\n아이디와 비밀번호를 입력하세요.\n"),
    DOCLOGIN(12, "[의사 로그인]\n아이디와 비밀번호를 입력하세요.\n"),
    ADMLOGIN(13, "[관리자 로그인]\n아이디와 비밀번호를 입력하세요.\n"),
    JOIN(2, "회원가입에 필요한 정보를 입력합니다.\n"),
    NOTICE(3, "31.공지사항 목록확인\t32.확인할 공지사항 번호입력\t0.종료\n메뉴를 선택하세요: "),
    ALLNOTICE(31, "[공지사항 목록]"),
    SELNOTICE(32,"공지사항 번호입력: "),
    NOTICE_CHECK(61,"611.목록조회\t612.등록\t613.수정\t614.삭제\t0.종료"),
    ADMIN_NOTICE(611,"[공지사항 목록]"),
    INSERT_NOTICE(612,"제목과 내용을 입력해주세요."),
    UPDATE_NOTICE(613, "수정할 게시물 번호를 입력하세요."),
    DELETE_NOTICE(614, "삭제할 게시물 번호를 입력하세요."),
   
    PATIENT(4, "41.예약\t42.마이페이지\t43.문의사항\t44.로그아웃\n메뉴를 선택하세요: "),
    APPOINTMENT(41,"411.예약조회\t412.예약등록\t413.예약변경\t414.예약삭제"),
    SELAPPOINTMENT(411,"예약 조회할 환자의 번호를 입력하세요: "),
    UPDATEAPPOINTMENT(413, "예약을 변경합니다."),
    DELAPPOINTMENT(414,"예약 취소할 환자의 번호를 입력하세요: "),
    DOCTOR(5, "1.예약조회\t4.로그아웃\n메뉴를 선택하세요: "),
    SELDOCAPPOINTMENT(71, "예약 조회할 의사의 번호를 입력하세요: "),
    ADMIN(6, "61.공지사항 관리\t62.예약관리\t63.문의게시판답변\n"),
    MYPAGE(42, "51.개인정보확인\t52.개인정보수정\t53.패스워드변경\t1.이전메뉴\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    LOGOUT(9, "로그아웃 되었습니다!\n"),
    CUSTOMER_INFO(51, "개인정보 확인\n"),
    CUSTOMER_MODIFY_INFO(52, "521.이름\t522.주소\t523.휴대전화번호\t5.이전메뉴\n수정할 항목을 선택하세요: "),
    MODIFY_NAME(521, "이름 수정\n변경할 이름을 입력하세요: "),
 
    QNA(43, "431. 문의 목록조회\t432.확인할 문의 번호입력\t433.문의작성\t435.삭제\t0.종료\n메뉴를 선택하세요: "),
    ALLQNA(431, "[문의 목록]"),
    SELQNA(432,"문의 번호입력: "),
    INSERT_QNA(433, "문의글 작성"),
    UPDATE_QNA(434, "문의글 수정"),
    DELETE_QNA(435, "삭제할 게시물 번호를 입력하세요." ),
    
    QNA_ADMIN(63, "631.문의조회\t632.확인할 문의 번호입력\t633.답변달기\t634.문의삭제\t6.뒤로가기"),
    ALLQNA_ADMIN(631,"[문의 목록] "),
    SELQNA_ADMIN(632,"문의 번호입력: "),
    INSERT_QNA_ADMIN(632, "문의글 작성"),
    QNA_REPLY(633,"답변할 게시물 번호를 입력하세요. "),
    DELETEQNA_ADMIN(634, "삭제할 게시물 번호를 입력하세요.")
    
    ;

    private final int menu;
    private final String menuString;

    HomeMenu(int menu, String menuString) {
        this.menu = menu;
        this.menuString = menuString;
    }

    public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }

    public static HomeMenu findMenu(int number) throws MenuNotFoundException {
        for (HomeMenu menu: values()) {
            if (menu.getMenu() == number) {
                return menu;
            }
        }
        throw new MenuNotFoundException("잘못된 선택입니다.");
    }
    public void display(Scanner scanner) {

    }
}
