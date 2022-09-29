import java.util.Random;

import javax.swing.JOptionPane;

public class RockSissorsPaper {

	public static boolean inputCheck = false;
	public static String you = ""; // 사용자의 가위바위보가 저장될 변수

	public static void main(String[] args) {

		String[] a = { "가위", "바위", "보" };
		Random random = new Random();
		int index = random.nextInt(2) + 1; // 0~2사이의 난수 만들기
		String computer = a[index];
		

		CountDown th2 = new CountDown();
		th2.start();
		
		Thread th1 = new DataInput();
		th1.start();
		
		try {
			th1.join(); // 입력이 끝날때까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		//결과판정
		String result = "";
		if (you.equals(computer)) {
			result = "비김";
		}else if (you.equals("가위") && computer.equals("바위")
				|| you.equals("바위") && computer.equals("보")
				|| you.equals("보") && computer.equals("가위")) {
			
			result = "컴퓨터 승리. you lost";
			
		}else {
			result = "you 승리";
		}
		
		//결과출력
		System.out.println("컴퓨터 : " + computer);
		System.out.println("you: " + you);
		System.out.println("결과 : " + result);

	}
}

/**
 * 데이터를 입력을 받는 스레드 클래스
 *
 */
class DataInput extends Thread {
	@Override
	public void run() {

		
		String inputData ="";
		
		do {
			inputData = JOptionPane.showInputDialog("가위바위보를 입력하세요");
		}while (!inputData.equals("가위") && !inputData.equals("바위") && !inputData.equals("보"));

		RockSissorsPaper.inputCheck = true; // 입력이 완료됨을 알려주는 변수값을 변경한다.
		RockSissorsPaper.you = inputData;  //  입력값 설정

	}
}

class CountDown extends Thread {
	@Override
	public void run() {

		for (int i = 10; i >= 1; i--) {

			if (RockSissorsPaper.inputCheck == true) {
				return;
			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);

	}
}