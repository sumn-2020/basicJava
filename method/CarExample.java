package classPractice.method;

public class CarExample {
	public static void main(String[] args) {

		Car car = new Car();
		car.setGas(5); // car이라는 클래스 속에 있는 메소드 중에서 setGas메소드에게 5라는 인수를 넘겨줌

		boolean gasState = car.isLeftGas(); // isLeftGas라는 메소드를 불러와서 gasState라는 변수에 넣고
		if (gasState) { // gasState(isLftGas메소드 실행 후 이게 참일경우)
			System.out.println("출발합니다");
			car.run(); // run메소드 출력
		}

		if (car.isLeftGas()) { // isLeftGas가 참이면
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요");
		}

	}
}
