package exercise20220831.exercise1;

public class Circle extends Shape {
	//필드
	private double radius;
	
	//생성자
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//메소드
	@Override
	public double area() { //도형의 넓이 반환 : 반지름 * 반지름 * 원주율
		return radius * radius * Math.PI;
	}
	@Override
	public double perimeter() { //둘레를 반환 : 2 × π × 반지름
		return 2.0 * Math.PI * radius;
		
	}
	@Override
	public String toString() {
		return String.format("도형의 종류: 원, 둘레:%.2fcm, 넓이: %.2fcm²", perimeter(), area());
	}
}
