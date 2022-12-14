package kr.or.ddit.basic;

public class T14ThreadShareDateTest {

	/*
	 * 원주율을 계산하는 스레드가 있고, 계산된 원주율을 출력하는 스레드가 있다. 원주율을 계산한 후 이 값을 출력하는 프로그램을 작성하시오.
	 * (이 때 원주율을 저장하는 객체가 필요하다.)
	 */
	public static void main(String[] args) {

		ShareData sd = new ShareData(); 
		//★스레드들의 공유객체 : 스레드들이 필요한 정보를 서로 교환하기 위해서 스레들들이 공통으로 바라볼수 있는 객체 
		//다른 스레드의 정보를 가져다 쓰기 위함 

		CalcPIThread cth = new CalcPIThread(sd);
		PrintPIThread pth = new PrintPIThread(sd);

		cth.start();
		pth.start();

	}

}

class ShareData {

	private double result; // 원주율이 저장될 변수
	volatile private boolean isOk = false; // 원주율 계산 완료여부 확인용
	
	/* 
	 * volatile 
	 * 
	 * 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다. 
	 * 즉, 값이 변경되는 즉시 변수에 적용시킨다.
	 * 멀티스레드 환경에서 하나의 변수가 완벽하게 한번에 작동하도록 보장하는 키워드 (일종의 동기화)
	 * 
	 */
	
	

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}

// 원주율 계산을 위한 스레드 클래스
class CalcPIThread extends Thread {

	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}

	@Override
	public void run() {

		/*
		 * 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ... ) * 4; 1 - 3 + 5 - 7 + 9 => 분모 0 1 2 3
		 * 4 => 분모를 2로 나눈 몫
		 */

		double sum = 0.0;
		for (int i = 1; i <= 1500000000; i += 2) {
			if (((i / 2) % 2) == 0) {
				sum += (1.0 / i);
			} else {
				sum -= (1.0 / i);
			}
		}
		sd.setResult(sum * 4);
		sd.setOk(true); // 원주율 계산이 완료되었음을 나타냄

	}

}

//계산된 원주율을 출력하는 스레드
class PrintPIThread extends Thread {
	private ShareData sd;

	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}

	@Override
	public void run() {
		while (true) {
			// 원주율 계산이 완료 될 때까지 기다린다.
			if (sd.isOk()) {
				break;
			}
		}
		System.out.println();
		System.out.println("계산된 원주율: " + sd.getResult());
		System.out.println("      PI :  " + Math.PI);
	}

}
