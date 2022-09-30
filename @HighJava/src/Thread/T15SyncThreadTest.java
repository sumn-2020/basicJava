package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {

		ShareObject sObj = new ShareObject();

		WorkerThread th1 = new WorkerThread("1번 스레드", sObj);
		WorkerThread th2 = new WorkerThread("2번 스레드", sObj);
		th1.start();
		th2.start();

	}
}

//공통으로 사용할 객체
class ShareObject {
	private int sum = 0;

	synchronized public void add() {
		for (int i = 0; i < 1000000000; i++) {
		} // 시간때우기용

		int n = sum;
		n += 10;
		sum = n;

		System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);

	}
	
	//여러개의 스레드가 공유하여 작업을 진행하다보면 막 서로 쓸라고 뒤죽박죽되는데.. 
	//이걸 방지하기 위해서 synchronized하면 스레드가 줄서서 차례대로 공유스레드를 사용하게 됨 

}

//작업을 수행하는 스레드 
class WorkerThread extends Thread {
	private ShareObject sObj;

	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}

	@Override
	public void run() {

		for (int i = 0; i <= 10; i++) {
			sObj.add();
		}

	}
}
