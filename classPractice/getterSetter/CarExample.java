package getterSetter;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();

		// 잘못된 속도 변경
		car.setSpeed(-50);
		System.out.println("현재속도: " + car.getSpeed());

		// 올바른 속도변경
		car.setSpeed(60);
		System.out.println(car.getSpeed());

		if (!car.isStop()) { //isStop값을 불러옴 isStop에 들어있는 return 값은 false => !false니까 true!!
			car.setStop(true); //setStop에 true넣어서 setStop 실행 
		}
		System.out.println(car.isStop());

	}
}
