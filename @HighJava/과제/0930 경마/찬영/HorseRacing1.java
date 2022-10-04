package kr.or.ddit.basic.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
10마리의 말들이 경주하는 경마 프로그램 작성하기

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

public class HorseRacing {
	
	public static void main(String[] args) {
		
		List<Horse> horseList = new ArrayList<Horse>();
		
		horseList.add(new Horse("01번 말"));
		horseList.add(new Horse("02번 말"));
		horseList.add(new Horse("03번 말"));
		horseList.add(new Horse("04번 말"));
		horseList.add(new Horse("05번 말"));
		horseList.add(new Horse("06번 말"));
		horseList.add(new Horse("07번 말"));
		horseList.add(new Horse("08번 말"));
		horseList.add(new Horse("09번 말"));
		horseList.add(new Horse("10번 말"));
		
		Thread gs = new GameState(horseList);
		
		for(Thread th : horseList) {
			th.start();
		}
		
		gs.start();
		
		for(Thread th : horseList) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
		try {
			gs.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
		System.out.println("경기 끝...");
		System.out.println("------------------------");
		System.out.println("경기 결과");
		System.out.println();
		
		Collections.sort(horseList);
		
		for(Horse h : horseList) {
			System.out.println(h.toString());
		}
	}
}


class Horse extends Thread implements Comparable<Horse>{
	
	// 경기가 끝난 말의 등수를 정하기 위한 변수
	public static int currentRank = 0;
	
	private String name;
	private int rank;
	private int position; // 현재 위치
	 
	public Horse(String name) {
		super(name);
		this.name = name;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	// 등수의 오름차순 내부 정렬 기준
	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.getRank());
	}
	
	@Override
	public String toString() {
		return name + "은 " + rank + "등 입니다.";
	}
	
	
	@Override
	public void run() {
		// 경기 구간은 1 ~ 50 구간으로 되어 있다.
		for (int i = 1; i <= 50; i++) {
			position = i; // 말의 현재 위치를 저장한다.

			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 한 마리의 말이 경주가 끝나면 등수를 구해서 설정한다.
		currentRank++;
		this.rank = currentRank;
	}
	
}

class GameState extends Thread{
	private List<Horse> horses;

	public GameState(List<Horse> horses) {
		super();
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while (true) {
			// 모든 말들의 경기가 종료되었는지 여부 검사
			if (Horse.currentRank == horses.size()) {
				break;
			}

			for (int i = 1; i <= 15; i++) {
				System.out.println(); // 빈 줄 띄우기
			}

			for (int i = 0; i < horses.size(); i++) {
				System.out.print(horses.get(i).getName() + " : ");

				for (int j = 1; j <= 50; j++) {
					if (horses.get(i).getPosition() == j) { // 말의 현재 위치 표시
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}

				System.out.println(); // 줄바꿈
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}


