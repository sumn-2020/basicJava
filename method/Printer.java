package classPractice.method;

public class Printer {

	// static 키워드를 붙이면 자바는 메모리 할당을 딱 한번만 하게 되어 메모리 사용에 이점이 있다.
	static void println(String name) {
		System.out.println(name);
	}

	void println(boolean b) { //외부에서 b를 받아와서 출력
		System.out.println(b);
	}

	void println(double d) {
		System.out.println(d);
	}

	void println(int i) {
		System.out.println(i);
	}

}
