package memo;

import java.util.Scanner;

public class MemoApplication {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		// 화면에 호출할 뷰 호출
		MemoView view = new MemoView();
		// 첫번째 메뉴 보여줌
		view.init();

		int menu = Integer.parseInt(scanner.nextLine());
		switch (menu) {
		case 1: // 메뉴가 1이면
			view.viewMemos(new MemoController()); // MemoController에 있는 getMemos를 호출해서 반환시켜줌
			break;
		default:
			break;
		}

	}
}
