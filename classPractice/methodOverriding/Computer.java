package methodOverriding;

public class Computer extends Calcuator {

	@Override
	public double areaCircle(double radius) {

		System.out.println(super.name); // 필드를 호출할 경우

		super.areaCircle(radius); // 자식이 부모 메소드를 호출할 수 있음
		// return 받으려면 double areaCircle = super.areaCircle(radius)이렇게 받을 수 있는 변수가
		// 선언되어있어야 됨. 선언 안되어있으면 return값 못받음

		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * radius * radius;
	}

}
