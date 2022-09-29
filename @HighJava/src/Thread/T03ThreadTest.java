package kr.or.ddit.basic;


/**
 * 스레드 수행시간 체크해보기
 *
 */
public class T03ThreadTest {
	public static void main(String[] args) {
		
		
		
		Thread th = new Thread(new MyRunner()); //메인스레드가 th 만든 후 
		
		//UTC(Universal Time Coordinated 협정 세계 표준시)를 사용하여 1970년 1월 1일 0시 0분0초를 기준으로 경과한 시간을 밀리세컨드(1/1000초) 단위로 나타낸다.
		long startTime = System.currentTimeMillis();
		
		th.start(); //th 스레드 시작 

		try {
			//현재 실행중인 스레드에서 작업중인 스레드(지금은 th스레드)가 종료될때까지 기다린다.
			th.join();//메인스레드가 th스레드와 조인한 , th스레드작업이 종료될때까지 기다렸다가 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis(); //메인스레드가 이거 실행 
		System.out.println("경과시간 : " + (endTime - startTime));
		
	}
}


//1~1000000000까지의 합계를 구하는 스레드 클래스
class MyRunner implements Runnable {
	@Override
	public void run() {
		long sum = 0;
		for (int i = 1; i < 1000000000; i++) {
			sum += 1;
		}
		System.out.println("합계: " + sum);
	}
}