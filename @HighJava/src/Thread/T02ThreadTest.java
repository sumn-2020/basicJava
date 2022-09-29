package kr.or.ddit.basic;

/**
 * 멀티스레드 프로그램 생성예제
 */

public class T02ThreadTest {
	public static void main(String[] args) {

		// 방법1: Thread 클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출한다.
		Thread th1 = new MyThread1();
		th1.start();

		// 방법2: Runnable인터페이스를 구현한 class의 인스턴스를 생성한 후 이 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의
		// 파라미터로 넘겨준다.
		// 이렇게 생성된 인스턴스의 start()메서드를 호출한다.
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();

		// 방법3 : 익명클래스를 이용하는 방법
		// Runnable 인터페이스를 구현한 익명클래스를 Thread 인스턴스를 생성할 때 매개변수로 넘겨준다.
		Thread th3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("@");

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
		});
		th3.start();

	}
}

class MyThread1 extends Thread {

	// 별표 찍는거는 MyThread1이 하고있는거임, 메인스레드는 죽었음
	@Override
	public void run() {

		for (int i = 1; i <= 200; i++) {
			System.out.print("*");

			try {
				// Thread.sleep(시간) => 주어진 시간만큼 잠시 멈춘다.
				// 시간은 밀리세컨드 단위이다.
				// (즉, 1000ms = 1초)
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}

class MyThread2 implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 200; i++) {
			System.out.print("$");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
