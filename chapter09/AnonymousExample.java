package chapter09;

public class AnonymousExample {
	public static void main(String[] args) {
		
		new Vehicle() {
			@Override
			public void run() {
				System.out.println("자동차가 달린다.");
			}
		}.run();
		
	}
}
