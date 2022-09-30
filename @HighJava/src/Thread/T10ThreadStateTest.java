package kr.or.ddit.basic;

/**
 * 스레드의 상태를 출력하는 예제
 */

public class T10ThreadStateTest {

	/*
	 * <스레드의 상태>
	 * 
	 * - NEW : 스레드가 생성되고 아직 start()가 호출되지 않은 상태 - RUNNABLE: 실행 중 또는 실행 가능한 상태 -
	 * BLOCKED : 동기화 블럭에 의해서 일시정지된 상태(LOCK이 풀릴때까지 기다리는 상태) - WAITING, TIMED_WAITING:
	 * 스레드의 작업이 종료되지는 않았지만 실행 가능하지는 않은 일시정지 상태(TIMED_WAITING은 시간이 지정된 경우) -
	 * TERMINATED : 스레드의 작업이 종료된 상태
	 * 
	 */
	public static void main(String[] args) {
		
		Thread targetThread = new TargetThread();
		StatePrintThread spt = new StatePrintThread(targetThread);
		
		spt.start();
		

	}
}

class TargetThread extends Thread {
	@Override
	public void run() {

		for (long i = 1; i <= 1000000000L; i++) {
		} // 시간때우기용
		try {
			Thread.sleep(1500); // 1.5초동안 잠들었다가
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		for (long i = 1; i <= 1000000000L; i++) {
		} // 시간때우기용

	}
}

/**
 * 스레드의 상태를 출력하는 스레드 클래스(이 클래스도 스레드로 작성)
 *
 */
class StatePrintThread extends Thread {

	private Thread targetThread; // 모니터링 대상 스레드 객체

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {

		while (true) {
			// Thread의 상태정보 가져오기
			Thread.State state = this.targetThread.getState();
			System.out.println("타켓 스레드의 상태값: " + state);

			// NEW상태인지 검사
			if (state == Thread.State.NEW) {
				targetThread.start();
			}

			// 타켓 스레드가 종료상태인지 검사
			if (state == Thread.State.TERMINATED) {
				break;
			}

			try {
				Thread.sleep(500);//0.5
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
