package assian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * 
 * T11참고
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간중간에 각 말들의 위치를 >로 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수를 기준으로 정렬하여 출력한다.

 */

public class HorseTest {

	static int currRank = 1; // 현재의 순위 정보

	public static void main(String[] args) {

		List<Horse> horse = new ArrayList<Horse>();
		horse.add(new Horse("1번째 말"));
		horse.add(new Horse("2번째 말"));
		horse.add(new Horse("3번째 말"));
		horse.add(new Horse("4번째 말"));
		horse.add(new Horse("5번째 말"));
		horse.add(new Horse("6번째 말"));
		horse.add(new Horse("7번째 말"));
		horse.add(new Horse("8번째 말"));
		horse.add(new Horse("9번째 말"));
		horse.add(new Horse("10번째 말"));

		// 스레드 세개 start 시켜주기
		for (Thread th : horse) {
			th.start();
		}

		// 스레드 세개 다 돌아갈때까지 기다리기
		for (Thread th : horse) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 다 돌아간 스레드 세개를 순서대로 정렬 시키기
		Collections.sort(horse);

		System.out.println();
		System.out.println();
		System.out.println("경기끝");
		System.out.println("---------------------");
		System.out.println("경기결과");
		System.out.println("=====================");
		System.out.println("순위 \t : \t이름");
		System.out.println("---------------------");

		for (Horse horse2 : horse) {
			System.out.println(horse2.getRank() + "\t:\t" + horse2.getName());
		}

	}
}

class Horse extends Thread implements Comparable<Horse> {

	private String name;
	private int rank;

	public Horse(String name) {
		super(name);
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	// 1. 스레드 만들기
	@Override
	public void run() {

		for (int i = 1; i <= 50; i++) { // 경기 횟수

			System.out.println(name);
			// 라인
			for (int k = 0; k < i; k++) {
				System.out.print("-");
			}
			System.out.print(">");
			for (int k = 49; k > i; k--) {
				System.out.print("-");
			}

			try {
//				Random random = new Random();
//				int a = random.nextInt(49) + 1;
//				Thread.sleep(a);
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println();
		System.out.println(name + " 끝");
		System.out.println();

		// 랭크 값 계산 : 랭크 값 들고와서 +1 씩 더하기
		setRank(HorseTest.currRank++);

	}

	// 정렬
	@Override
	public int compareTo(Horse o) {
		return new Integer(this.getRank()).compareTo(o.getRank());
	}

}
