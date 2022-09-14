package memo;

import java.util.Scanner;

public class MemoApplication {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		MemoController memocontroller = new MemoController();

		// 화면에 호출할 뷰 호출
		MemoView view = new MemoView();
		menu : while (true) {
			// 첫번째 메뉴 보여줌
			view.init();
			int menu = Integer.parseInt(scanner.nextLine());
			
			switch (menu) {
			case 1: // 전체메모 (메뉴가 1이면)
				view.viewMemos(memocontroller); // MemoController에 있는 getMemos를 호출해서 반환시켜줌 // 해당 목록 보여줌 
				break;
			case 2: //메모한개
				view.viewDetailMemo(memocontroller, scanner);
				break;
			case 3: //등록
				view.insertMemo(memocontroller, scanner);
				break;
			case 4: //수정
				view.updateMemo(memocontroller, scanner);
				break;
			case 5: //삭제
				view.deleteMemo(memocontroller, scanner);
				break;
			default:
				System.out.println("프로그램을 종료합니다.");
				return;//0번을 누르면 반복문 종료
				
				//System.exit(0); //0번을 누르면 반복문 종료
				//break menu;
			}
		}

	}
}
