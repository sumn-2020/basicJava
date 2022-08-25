package methodOverriding;

public class Calcuator {

	public String name;

	// 메소드
	public double areaCircle(double radius) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.141592 * radius * radius;
	}

}
