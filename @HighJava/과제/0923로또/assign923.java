package assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class assign923 {
	public static void main(String[] args) {

		// 1) 로또번호를 출력 : 로또를 구매할 때 구매할 금액을 입력,입력한 금액에 맞게 로또번호를 출력
		// 2) 거스름돈 출력: 로또 한장의 금액은 1000원, 거스름돈도 계산하여 출력

		Scanner scanner = new Scanner(System.in);

		System.out.println("==========================");
		System.out.println(" Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================");
		int menu = scanner.nextInt();
		System.out.println("메뉴선택 : " + menu);

		System.out.println("Lotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		int money = scanner.nextInt();
		System.out.println("금액 입력 : " + money);
		System.out.println();

		System.out.println("행운의 로또번호는 아래와 같습니다.");

		int times = money / 1000;
		System.out.println();
		for (int i = 1; i < times+1; i++) {
			System.out.println("로또번호" + i + ": " + lottoNumbers());
		}

		int rest = (money % 1000);
		System.out.println();
		System.out.println("받은 금액은 " + money + " 거스름돈은 " + rest + "원입니다.");
	}

	static String lottoNumbers() {
		Set<Integer> set = new HashSet<Integer>();

		while (set.size() != 6) {
			set.add((int) (Math.random() * 45 + 1));
		}

		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		return list.toString();
	}
}
