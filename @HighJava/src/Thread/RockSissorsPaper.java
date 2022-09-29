import java.util.Random;

import javax.swing.JOptionPane;

public class RockSissorsPaper {

	public static boolean inputCheck = false;

	public static void main(String[] args) {

		Thread th1 = new DataInput();
		th1.start();

		CountDown th2 = new CountDown();
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

		String[] a = { "가위", "바위", "보" };

		Random random = new Random();
		//int computer = random.nextInt();
		String computer = a[random.nextInt(a.length)]; //배열을 String으로 변경 
		
		String you = JOptionPane.showInputDialog("가위바위보입력");
		String result = "";
		

		if (you.equals(computer)) {
			System.out.println("you : " + you);
			System.out.println("computer: " + computer);
			result = "결과:  비김";
		}else if (you.equals("가위") && computer.equals("바위")
				|| you.equals("바위") && computer.equals("보")
				|| you.equals("보") && computer.equals("가위")) {
			
			System.out.println("you : " + you);
			System.out.println("computer: " + computer);
			result = "결과:  컴퓨터 승리";
			
		}else {
			System.out.println("you : " + you);
			System.out.println("computer: " + computer);
			result = "결과: you 승리";
		}
		System.out.println(result);


		RockSissorsPaper.inputCheck = true;

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