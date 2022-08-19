package classPractice.method;

public class Calcuator {

	// 메소드1
	void powerOn() { // void는 return값 없음.
		System.out.println("전원을 켭니다.");
	}

	// 메소드2
	int plus(int x, int y) { // 외부에서 x와 y 인수를 받아와서
		int result = x + y; // 계산을 하고
		return result; // 계산한 값을 return 해줌
	}

	// 메소드 3
	double divide(int x, int y) { // 정수타입인 x와 y값을 받아와서
		double result = (double) x / (double) y; // double타입으로 변환한후 x와 y값을 나눈 후
		return result;// 그 값을 리턴 해줌
	}

	// 메소드 4
	void powerOff() {
		System.out.println("전원을끕니다.");
	}

}
