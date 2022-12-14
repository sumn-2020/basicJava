package hospital;

import hospital.adminSign.AdminSignController;
import hospital.appointment.AppointmentController;
import hospital.common.HomeMenu;
import hospital.common.MenuNotFoundException;
import hospital.docSign.DocSignController;
import hospital.join.JoinController;
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
//					case SELAPPOINTMENT:
//						number = view.searchAppointment(appointController);
//						break;
					case MYAPPOINTMENT:
						number = view.findAppointment(appointController);
						break;
					case INSERTAPPOINTMENT:
						number = view.insertAppointment(appointController);
						break;
					case UPDATEAPPOINTMENT:
						number = view.updateAppointment(appointController);
						break;
//					case DELAPPOINTMENT:
//						number = view.deleteAppointment(appointController);
//						break;
					case DELETEAPPOINTMENT:
						number = view.deleteAppointment(appointController);
						break;
					case DOCTORAPPOINTMENT:
						number = view.searchDocAppointment(appointController);
						break;
					case NOTICE_CHECK: //????????????
						number = view.getMenu();
						break;
					case INSERT_NOTICE: //????????????
						number = view.insertNotice(noticeController);
						number = view.getAdmNoticeList(noticeController);
						break;
					case UPDATE_NOTICE: //????????????
						number = view.getNoticeList(noticeController);
						number = view.updateNotice(noticeController);
						number = view.getAdmNoticeList(noticeController);
						break;
					case DELETE_NOTICE: //????????????
						number = view.getNoticeList(noticeController);
						number = view.deleteNotice(noticeController);
						number = view.getAdmNoticeList(noticeController);
						break;
						
						//*** qna - ?????? ***
					case ALLQNA: 
						number = view.getQnaList(qnaController);
						break;
					case SELQNA	://??????
						number = view.getQnaList(qnaController);
						number = view.searchQna(qnaController);
						break;
	                case INSERT_QNA : //??????
	                      number = view.insertQna(qnaController);
	                      break;
	                case DELETE_QNA://??????
	                	 number = view.deleteQna(qnaController);
	                	 break;  
	                //*** qna - ????????? ***  
	                case ALLQNA_ADMIN:
	                	number = view.getQnaListAdmin(qnaController);
						break;
					case SELQNA_ADMIN:
						number = view.getQnaListAdmin(qnaController);
						number = view.searchReplyAdmin(replyController);
						break;	 
	                case QNA_REPLY: //????????????
	                	number = view.getQnaListAdmin(qnaController);
	                	number = view.replyQna(replyController);
	                	break;
					case LOGOUT:
						number = signController.signOut();
						break;   
					case MYPAGE:
					case CUSTOMER_MODIFY_INFO:   
						number = view.getMenu();
						break;
					case CUSTOMER_INFO:
						number = view.getPatientInfo(joinController);
						break;
					case MODIFY_NAME:
					case MODIFY_ADDRESS:
					case MODIFY_PHONE:   
						number = view.modifyInfo(joinController, menu);
						break;
					case MODIFY_PASSWORD:
						number = view.changePassword(joinController);
						break;
					case QUIT:
						break loop;
					}
				} catch (MenuNotFoundException e) {
		               System.out.println();
		               System.out.println(e.getMessage());
		               System.out.println();
		               home(view.init());
		            } 
				System.out.println();
			}
	}
}

