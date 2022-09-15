package memo2;

import java.sql.SQLException;
import java.util.Scanner;

public class Memo2Application {
	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		Memo2Controller memo2Controller = Memo2Controller.getInstance();
		
		Memo2View view = Memo2View.getInstance();
		menu : while(true) {
			//첫화면
			view.init();
			int menu = Integer.parseInt(scanner.nextLine());
			
			switch(menu) {
				case 1: //전체목록
					view.viewMemos();
					break;
				default:
					System.out.println("프로그램 종료");
					return;
			}
		}
	}
}
