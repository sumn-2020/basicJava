package kr.or.ddit.basic;


public class T09ThreadDaemonTest {
	public static void main(String[] args) {

		AutoSaveThread autoSave = new AutoSaveThread();
		
		//multithread할 때 데몬스레드가 유용함 
		//데몬스레드를 사용하면 multi thread 중에서 종료 안된 것이 있을수도 있는 가능성에서 벗어날 수 있음 
		
		//AutoSaveThread를 데몬스레드로 설정하기 (start()호출전에 설정할 것!)
		autoSave.setDaemon(true); //데몬스레드로 설정할거면 true, 그냥 일반스레드로 쓸거면 false
		autoSave.start();

		try {
			for (int i = 1; i <= 20; i++) {
				System.out.println("작업" + i);
				Thread.sleep(1000); 
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		System.out.println("메인스레드 종료");

	}
}

/**
 * 자동 저장 기능 제공하는 스레드 (3초에 한번씩 저장하기)
 *
 */
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업내용을 저장합니다.");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);// 3초동안 잠들었다 깨어나서
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			save(); // 자동저장기능 실행 (3초에 한번씩 영원히 실행)
		}
	}

}
