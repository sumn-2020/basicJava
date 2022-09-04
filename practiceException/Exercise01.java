package practiceException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("어떤 수로 나누시겠습니까?");
				int a = scanner.nextInt();
				System.out.println("어떤 수로 나누시겠습니까?");
				int b = scanner.nextInt();

				System.out.println(a / b);

			} catch (InputMismatchException e) {
				System.out.println("정수가 아닙니다.");
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}

	}
}
