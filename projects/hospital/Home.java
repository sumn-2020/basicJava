package hospital;

import hospital.adminSign.AdminSignController;
import hospital.common.HomeMenu;
import hospital.common.MenuNotFoundException;
import hospital.docSign.DocSignController;
import hospital.join.*;
import hospital.notice.NoticeController;
import hospital.patSign.PatSignController;

public class Home {
	private HospitalView view = HospitalView.getInstance();
	private JoinController joinController = JoinController.getInstance();
	private PatSignController signController = PatSignController.getInstance();
	private DocSignController docsignController = DocSignController.getInstance();
	private AdminSignController adminSignController = AdminSignController.getInstance();
	private NoticeController noticeController = NoticeController.getInstance();
	
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
						case SELNOTICE:
							number = view.searchNotice(noticeController);
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
