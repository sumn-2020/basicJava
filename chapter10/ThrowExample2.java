package chapter10;

import java.util.Random;
import java.util.Scanner;

public class ThrowExample2 {
	public static void main(String[] args) {

		Random random = new Random();
		int answer = random.nextInt(100) + 1;

		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			try {
				System.out.print("1부터 100 사이의 정수 중 하나를 선택하세요: ");
				int userInput = scanner.nextInt();

				if (answer > userInput) {

					throw new LessNumberException("작은 수를 입력하였습니다.");

				} else if (answer < userInput) {

					throw new GreaterNumberException("큰 수를 입력하였습니다.");

				} else {
					System.out.println("정답입니다.");
					break;
				}
			} catch (LessNumberException | GreaterNumberException e) { //두개를 하나로 묶을 수 있음 
				System.out.println(e.getMessage());
			} 
			
		}


		System.out.println("게임을 종료합니다.");

	}

}
