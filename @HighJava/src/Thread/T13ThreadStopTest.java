package kr.or.ddit.basic;

public class T13ThreadStopTest {
	public static void main(String[] args) {

		/*
		ThreadStopEx1 th1 = new ThreadStopEx1();
		th1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		th1.setStop(true);
		*/
		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th2.interrupt(); //메인스레드가 th2스레드한테 interrupt걸었음

	}
}

class ThreadStopEx1 extends Thread {

	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {

		while (!stop) {
			System.out.println("스레드 처리중..");
		}
		System.out.println("자원 정리 중..");
		System.out.println("실행 종료");
	}
}

/**
 * interrupt()메서드를 이용하여 스레드를 멈추는 방법
 */
class ThreadStopEx2 extends Thread {
	@Override
	public void run() {
		
		// 방법1 : sleep()메서드나 join()메서드 등을 사용했을 때
		// interrupt()메서드를 호출하면 interruptedException이 발생한다.
		/*
		try {
			while (true) {
				System.out.println("스레드 처리중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException ex) {
			
		}
		*/
		
		//방법2 : 인터럽트가 걸렸는지 검사하는 방법
		while(true) {
			System.out.println("스레드 처리 중");
			
			//검사방법1 => 스레드의 인스턴스 객체용 메서드를 이용하는 방법
			/*
			if(this.isInterrupted()) { //인터럽트가 걸렸냐?  걸렸으면 true, 외부에서 인터럽트 한번도 안걸었으면 false
				System.out.println("인스턴스용 isInterrupted()");
				break; //인터럽트 걸렸으면 while문 빠져나가기
			}
			*/
			
			//검사방법2 => 스레드의 정적 메스드를 이용하는 방법
			if(Thread.interrupted()) {
				System.out.println("정적메서드 interrupted()");
				break;
			}
			
		}
		
		System.out.println("자원정리중");
		System.out.println("실행종료");

	}
}
