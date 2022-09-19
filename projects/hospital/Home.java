package hospital;

import hospital.adminSign.AdminSignController;
import hospital.appointment.AppointmentController;
import hospital.appointment.AppointmentVO;
import hospital.common.HomeMenu;
import hospital.common.MenuNotFoundException;
import hospital.docSign.DocSignController;
import hospital.join.*;
import hospital.notice.NoticeController;
import hospital.patSign.PatSignController;
import hospital.qna.QnaController;
import hospital.reply.ReplyController;

public class Home {
	private HospitalView view = HospitalView.getInstance();
	private JoinController joinController = JoinController.getInstance();
	private PatSignController signController = PatSignController.getInstance();
	private DocSignController docsignController = DocSignController.getInstance();
	private AdminSignController adminSignController = AdminSignController.getInstance();
	private NoticeController noticeController = NoticeController.getInstance();
	private AppointmentController appointController = AppointmentController.getInstance();
	private QnaController qnaController = QnaController.getInstance();
	private ReplyController replyController = ReplyController.getInstance();
	
	
	
	
	public void initalize() {
		home(view.init());
	}
	
	private void home(int number) {
		loop:
			while(true) {
				try {
					HomeMenu menu = HomeMenu.findMenu(number);
					System.out.println(menu.getMenuString());
					switch(menu) {
						case HOME:
						case CHOOSELOGIN:
						case PATIENT:
						case DOCTOR:
						case ADMIN:
						case NOTICE:
						case QNA:
						case QNA_ADMIN:
						case APPOINTMENT:
							number = view.getMenu();
							break;
						case JOIN:
	                        number = view.join(joinController);
	                        break;
						case PATLOGIN:
							number = view.login(signController);
							break;
						case DOCLOGIN:
							number = view.login2(docsignController);
							break;
						case ADMLOGIN:
							number = view.login3(adminSignController);
							break;
						case MYPAGE:	
						case MODIFY_NAME:
							number = view.modifyInfo(joinController, menu);
							break;
						case ALLNOTICE:
							number = view.getNoticeList(noticeController);
							break;
						case ADMIN_NOTICE:	
							number = view.getAdmNoticeList(noticeController);
							break;
						case SELNOTICE:
							number = view.getNoticeList(noticeController);
							number = view.searchNotice(noticeController);
							break;
							
						case SELAPPOINTMENT:
							number = view.searchAppointment(appointController);
							break;
						case UPDATEAPPOINTMENT:
							number = view.updateAppointment(appointController);
							break;
						case DELAPPOINTMENT:
							number = view.deleteAppointment(appointController);
							break;
						case SELDOCAPPOINTMENT:
							number = view.searchDocAppointment(appointController);
							break;
						case NOTICE_CHECK:
							number = view.getMenu();
							break;
						case INSERT_NOTICE: //등록
							number = view.insertNotice(noticeController);
							number = view.getAdmNoticeList(noticeController);
							break;
						case UPDATE_NOTICE: //수정
							number = view.getNoticeList(noticeController);
							number = view.updateNotice(noticeController);
							number = view.getAdmNoticeList(noticeController);
							break;
						case DELETE_NOTICE: //삭제
							number = view.getNoticeList(noticeController);
							number = view.deleteNotice(noticeController);
							number = view.getAdmNoticeList(noticeController);
							break;
  
						//*** qna - 환자 ***
						case ALLQNA: 
							number = view.getQnaList(qnaController);
							break;
						case SELQNA	://조회
							number = view.getQnaList(qnaController);
							number = view.searchQna(qnaController);
							break;
		                case INSERT_QNA : //등록
		                      number = view.insertQna(qnaController);
		                      break;
		                case DELETE_QNA://삭제
		                	 number = view.deleteQna(qnaController);
		                	 break;  
		                //*** qna - 관리자 ***  
		                case ALLQNA_ADMIN:
		                	number = view.getQnaListAdmin(qnaController);
							break;
						case SELQNA_ADMIN:
							number = view.getQnaListAdmin(qnaController);
							number = view.searchQnaAdmin(qnaController);
							break;	 	
		                case DELETEQNA_ADMIN : //문의삭제 
		                	  number = view.deleteQna(qnaController);
		                	  break; 
		                case QNA_REPLY: //답변
		                	number = view.getQnaListAdmin(qnaController);
		                	number = view.replyQna(replyController);
		                	break;
		                	
		                	
						case QUIT:
							break loop;
					}
				} catch (MenuNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.println(HomeMenu.HOME.getMenuString());
				}
				System.out.println();
			}
	}
}
