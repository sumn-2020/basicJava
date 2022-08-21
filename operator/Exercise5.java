package operator;

import java.util.Scanner;

public class Exercise5 {
	public static void main(String[] args) {

		// 십의자리 이하를 버리는 코드.
		// value의 값이 356이라면 300이 나올수 있도록 하시오.

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자입력: ");
		int num = scanner.nextInt();
		int result = (num / 100) * 100;

		System.out.println(result);

	}
}
