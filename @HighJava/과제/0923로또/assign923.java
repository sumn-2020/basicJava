package assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class assign923 {
	public static void main(String[] args) {

		// 1) 로또번호를 출력 : 로또를 구매할 때 구매할 금액을 입력,입력한 금액에 맞게 로또번호를 출력
		// 2) 거스름돈 출력: 로또 한장의 금액은 1000원, 거스름돈도 계산하여 출력

		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("==========================");
			System.out.println(" Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			int menu = scanner.nextInt();
			System.out.println("메뉴선택 : " + menu);

			
			if(menu == 1) { //메뉴 1번 눌렀을때 
				System.out.println();
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				int money = scanner.nextInt();
				System.out.println("금액 입력 : " + money);
				System.out.println();

				System.out.println("행운의 로또번호는 아래와 같습니다.");

				int times = money / 1000; // 로또번호 출력횟수 계산 (로또 "한장"의 금액은 1000원 : 1000원에 한번 할 수 있다는 소리!)
				System.out.println();
				for (int i = 1; i < times + 1; i++) {
					System.out.println("로또번호" + i + ": " + lottoNumbers());
				}

				int rest = (money % 1000); // 거스름돈 계산 (로또 "한장"의 금액은 1000원이니까 나머지 금액을 돌려주면됨)
				System.out.println();
				System.out.println("받은 금액은 " + money + " 거스름돈은 " + rest + "원입니다.");
			}else { //메뉴 2번 눌렀을 때
				System.out.println("감사합니다.");
				break;
			}
		}
		
	}

	static String lottoNumbers() {

		// HashSet: 컬렉션 내에 값이 존재하는지 여부를 확인하는데 최적화된 자료 구
		Set<Integer> set = new HashSet<Integer>();

		while (set.size() != 6) { // set안에 랜덤한 숫자가 들어가는데 총 6개까지만 들어갈수있음. 7개 들어가면 출력X
			// set.add((int) (Math.random() * 45 + 1));
			Random random = new Random();
			int a = random.nextInt(45) + 1; // 46까지의 랜덤한 숫자들을
			set.add(a); //hashset안에 add
		}

		// set에서 random으로 넣어놓은 숫자들을 List에다가 순서대로 차곡차곡 넣기
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);// 정렬
		return list.toString();// List에 저장된 값들 출력
		
	}
}
