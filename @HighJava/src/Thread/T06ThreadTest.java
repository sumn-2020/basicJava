package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T06ThreadTest {

	/*
	 * 입력여부를 확인하기 위한 변수 선언 (모든 스레드에서 공통으로 사용할 변수)
	 * 
	 */

	public static boolean inputCheck = false;

	public static void main(String[] args) {

		Thread th1 = new DataInput();
		th1.start();

		Thread th2 = new CountDown();
		th2.start();

	}

}

/**
 * 데이터를 입력을 받는 스레드 클래스
 *
 */
class DataInput extends Thread {
	@Override
	public void run() {

		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println("입력한 값은 " + str + "입니다.");

		T06ThreadTest.inputCheck = true;

	}
}

/**
 * 카운트다운 처리를 하는 스레드 클래스
 */
class CountDown extends Thread {

	@Override
	public void run() {

		for (int i = 10; i >= 1; i--) {

			if (T06ThreadTest.inputCheck == true) {
				return; //입력하면 프로그램 종료됨
			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다. - 메인스레드부터 종료
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");

		System.exit(0);// 프로그램 강제 종료. -> 입력 안했을 경우 카운트다운 종료되면 스레드 강제종료
	}
}
