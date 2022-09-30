package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T11DisplayCharacterTest {

	/*
	 * 3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데 
	 * 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
	 */

	static int currRank = 1;// 현재의 순위 정보

	public static void main(String[] args) {

		List<DisplayCharacter> disCharList = new ArrayList<DisplayCharacter>();
		disCharList.add(new DisplayCharacter("홍길동"));
		disCharList.add(new DisplayCharacter("이순신"));
		disCharList.add(new DisplayCharacter("강감찬"));

		// 스레드 세개 start 시켜주기
		for (Thread th : disCharList) {
			th.start();
		}

		// 스레드 세개 다 돌아갈때까지 기다리기
		for (Thread th : disCharList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 다 돌아간 스레드 세개를 순서대로 정렬 시키기
		Collections.sort(disCharList);

		System.out.println("경기끝");
		System.out.println("---------------------");
		System.out.println("경기결과");
		System.out.println();
		System.out.println("=====================");
		System.out.println("순위\t:\t이름");
		System.out.println("---------------------");

		for (DisplayCharacter dc : disCharList) {
			System.out.println(dc.getRank() + "\t:\t" + dc.getName());
		}

	}
}

//알파벳 대문자 출력하는 스레드
class DisplayCharacter extends Thread implements Comparable<DisplayCharacter> {

	private String name;
	private int rank;

	public DisplayCharacter(String name) {
		super(name); //Thread(String name) 속에 있는 name을 상속받아와서 이름 출력 // 이거 설정안하면  thread0, thread1,  thread2 ... 이런식으로 임의적으로 이름 출력됨 
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력문자 : " + ch);

			// sleep() 시간을 200~500 사이의 난수로 한다
			try {
				Thread.sleep((int) (Math.random() * 301 + 200)); // 300 + 200 = 500사이의 랜덤한 수
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(name + "출력 끝");

		setRank(T11DisplayCharacterTest.currRank++); // 랭크 값 들고와서 +1 씩 더하기

	}

	// Comparable
	@Override
	public int compareTo(DisplayCharacter o) {
		return new Integer(this.getRank()).compareTo(o.getRank()); // 현재 rank(this.getRank())와 받아온 DisplayCharacter o의
																	// 랭크 값을 비교
	}

}
