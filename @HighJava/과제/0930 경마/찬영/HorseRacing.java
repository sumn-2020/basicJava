package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseRacing {

	

	public static void main(String[] args) {
		List<Horse> list = new ArrayList<>();

		list.add(new Horse("0번"));
		list.add(new Horse("1번"));
		list.add(new Horse("2번"));
		list.add(new Horse("3번"));
		list.add(new Horse("4번"));
		list.add(new Horse("5번"));
		list.add(new Horse("6번"));
		list.add(new Horse("7번"));
		list.add(new Horse("8번"));
		list.add(new Horse("9번"));
		
		Race state = new Race(list); // 말 위치 출력 스레드 생성
		
		for (Horse horse : list) { // foreach문으로 모든 말 스레드 실행 (10개스레드)
			horse.start();
		}
		state.start();

		for (Horse hs : list) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Collections.sort(list);
		System.out.println("경기끝 ....");
		System.out.println("======================================================");
		System.out.println();
		System.out.println(" 경기 결과 ");
		
		for(Horse h : list) {
			System.out.println(h);
		}
		
	}
}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; // class외부에서 사용할 현재순위 (정적) 
	
	private String name1; // 말이름
	private int rank; // 랭크
	private int location; // 위치

	public Horse(String name) {
		this.name1 = name;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name) {
		this.name1 = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
	

	@Override
	public String toString() {
		return name1 + " 경마" + "는 " + rank + "등 입니다.";
	}

	@Override
	public void run() {
		for(int i = 1; i<=50; i++) {
			location = i; //i는 말의 현재위치로 저장한다.

			try { // 말이 달리는 속도 조절(랜덤)
				Thread.sleep((int) (Math.random() * 400)); //for문을 돌릴 때마다 난수를 새로 생성하므로 딜레이되는 시간은 매번 다르다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		rank = ++Horse.currentRank; // 골인한  경마 순으로 랭크가 증감 , for문을 벗어나면 말의 position은 50이 됨. ⇒ 골인
	}
	
	@Override
	public int compareTo(Horse hor) {
		return Integer.compare(this.getRank(), hor.getRank()); // Integer에 이미 정의된 compare메서드를 사용
	}
}

class Race extends Thread{ // 말의 위치를 출력하는 스레드
	private List<Horse> horses;

	public Race(List<Horse> list) {
		this.horses = list;
	}
	
	@Override
	public void run() {
		while(true) {
			if(Horse.currentRank == horses.size()) { // currentRank와 hs.size()가 같아지면 while문 종료
				break;
			}
			
			for(int i=1; i<=10; i++) {
				System.out.println();
			}
			
			for(Horse h : horses) { // List에 있는 말이 foreach문 내부의 동작을 실행함
				System.out.print(h.getName1()+" : ");
				for(int j = 1; j <= 50; j++) {
					if(h.getLocation() == j) {
						System.out.print(">"); // 1~50까지 -를 출력하고 말의 현재 위치는 >를 출력
					}
					else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			
			// while문을 도는 시간 조절
			try {
				Thread.sleep(200); // 0.2 초마다 말위치 출력
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
