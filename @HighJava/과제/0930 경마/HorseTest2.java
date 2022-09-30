package assian;
/*
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

public class HorseTest2 {
	public static void main(String[] args) {

//		Thread[] ths = new Thread[] { new Horse()};
//
//		for (Thread th : ths) {
//			th.start();
//		}
//
//		for (Thread th : ths) {
//			try {
//				th.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		Thread horse = new Horse2();
		horse.start();

	}
}

class Horse2 extends Thread {
	@Override
	public void run() {

		// 50경기 뛰기
		for (int i = 1; i <= 50; i++) {
			
			System.out.println(i + "번째 말: ");
			
			//라인 
			for (int k = 0; k < i; k++) {
				System.out.print("-");
			}
			System.out.print(">");
			for (int k = 49; k > i; k--) {
				System.out.print("-");
			}
			System.out.println();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
