package kr.or.ddit.basic;

public class T08ThreadPriorityTest {
	public static void main(String[] args) {

		System.out.println("최대 우선순위 : " + Thread.MAX_PRIORITY);
		System.out.println("최소 우선순위 : " + Thread.MIN_PRIORITY);
		System.out.println("보통 우선순위 : " + Thread.NORM_PRIORITY);

		Thread[] ths = new Thread[] { 
				new ThreadTest1(), 
				new ThreadTest1(), 
				new ThreadTest1(), 
				new ThreadTest1(),
				new ThreadTest1(),  //대문자 출력하는 스레드 만들기 
				new ThreadTest2()  //소문자 출력하는 스레드 만들기
		};

		// 스타트 전에 설정해둘거 해두기 : 우선순위는 start()메서드 호출전에 설정해야 한다.
		for (int i = 0; i < ths.length; i++) {
			if (i == 5) {
				ths[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				ths[i].setPriority(Thread.MIN_PRIORITY);
			}
		}

		// 우선순위 출력
		for (Thread th : ths) {
			System.out.println(th.getName() + "의 우선순위: " + th.getPriority());
			//th.getName() 현재 스레드 이름 출력
		}

		for (Thread th : ths) {
			th.start();
			//6개의 스레드 가지고 와서 출력
		}

		for (Thread th : ths) {
			try {
				th.join(); //모든 스레드가 종료될때까지 메인스레드는 기다렸다가 젤 마지막에 종료됨 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

// 대문자를 출력하는 스레드 
class ThreadTest1 extends Thread {
	@Override
	public void run() {

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);

			// 아무것도 하지 않는 반복문(시간 때우기 용)
			for (int i = 1; i <= 1000000000; i++) {

			}
		}
	}
}

//소문자를 출력하는 스레드 
class ThreadTest2 extends Thread {
	@Override
	public void run() {

		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(ch);

			// 아무것도 하지 않는 반복문(시간 때우기 용)
			for (int i = 1; i <= 1000000000; i++) {

			}
		}
	}
}



