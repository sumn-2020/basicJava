package horse;

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

	public static void main(String[] args) {

		/*
		 * 스레드 생성
		 */
		// horse라는 ArrayList 에 Horse Thread 생성
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

		// 말 위치 출력 스레드 생성
		HorsePoint state = new HorsePoint(horse);

		/*
		 * 스레드 시작
		 */
		// 모든 말 스레드 시작 (10개 스레드)
		for (Thread th : horse) {
			th.start();
		}
		// 말 위치 스레드 시작
		state.start();

		// 스레드 세개 다 돌아갈때까지 기다리기
		for (Thread th : horse) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/*
		 * 정렬 시킨 후 출력
		 */
		// 다 돌아간 스레드들을 순서대로 정렬 시키기
		Collections.sort(horse);

		System.out.println();
		System.out.println("경기끝");
		System.out.println("---------------------");
		System.out.println("경기결과");
		System.out.println();
		System.out.println("순위  : 이름");
		System.out.println("---------------------");

		// horse라는 arrayList속에 들어있는 모든 스레드 전부 반복 실행
		for (Horse horse2 : horse) {
			System.out.println(horse2.getRank() + " : " + horse2.getName());
		}
	}
}

//말의 정보
class Horse extends Thread implements Comparable<Horse> {

	public static int currentRank = 1; // class외부에서 사용할 현재순위 (정적)

	private String name; // 말이름
	private int rank; // 랭크
	private int location; // 말들의 현재 위치

	public Horse(String name) {
		super(name);
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	// 스레드
	@Override
	public void run() {

		for (int i = 1; i <= 50; i++) { // 경기 횟수

			location = i; // i는 말의 현재위치로 저장

			// 말이 달리는 속도 (말마다 속도 다르게 랜덤하게)
			try {
//				Random random = new Random();
//				int a = random.nextInt(400);
//				Thread.sleep(a);
				Thread.sleep((int) (Math.random() * 400));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		// 랭크 값 계산 : 랭크 값 들고와서 +1 씩 더하기
		// 골인한 경마 순으로 랭크가 증감,for문을 벗어나면 말의 position은 50이 됨. ⇒ 골인
		rank = ++Horse.currentRank;

	}

	// 정렬
	@Override
	public int compareTo(Horse o) {
		return new Integer(this.getRank()).compareTo(o.getRank());
	}

}

//말의 위치를 나타내주는 스레드
class HorsePoint extends Thread {

	private List<Horse> horses; // ArrayList속에 들어있는 Horse객체 정보 전체

	public HorsePoint(List<Horse> horses) {
		this.horses = horses;
	}

	@Override
	public void run() {

		while (true) {
			if (Horse.currentRank == horses.size()) {// currentRank와 hs.size()가 같아지면 while문 종료
				break;
			}

			for (Horse horse : horses) { // ArrayList속에 들어있는 10마리의 말 전부 아래내용 반복실행
				System.out.print(horse.getName() + " : "); // Horse클래스에서 getName출력
				for (int i = 1; i <= 50; i++) {

					// 1~50까지 -를 출력하고 말의 현재 위치는 >를 출력
					if (horse.getLocation() == i) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}

			// 0.2초마다 말의 위치 출력
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}