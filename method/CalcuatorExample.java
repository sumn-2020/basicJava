package classPractice.method;

public class CalcuatorExample {
	public static void main(String[] args) {
		Calcuator calcuator = new Calcuator();

		calcuator.powerOn(); // void는 system.out.println안써도 출력됨

		int result = calcuator.plus(5, 6); // calcuator클래스 내부에 있는 메소드들 중에서 plus 메소드로 인수(5,6)를 보낸 후 메소드 내부에서 계산처리한 후 그 값을
											// 리턴받아서 result변수에 집어 넣음
		System.out.println(result);

		double result2 = calcuator.divide(30, 5);
		System.out.println(result2);

		calcuator.powerOff(); // void 메소드는 그냥 값 바로 가져옴

	}
}
