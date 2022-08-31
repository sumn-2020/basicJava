package exercise20220831.exercise1;

public class Triangle extends Shape {
	//필드
	private double side; // 한 변의 길이
	
	//생성자
	public Triangle(double side) {
		this.side = side;
	}
	
	//메소드
	@Override
	public double area() { //도형의 넓이를 반환 : Math.sqrt(3) * side * side / 4
		//super.area();
		return Math.sqrt(3) * side * side / 4.0;
	}
	@Override
	public double perimeter() { //도형의 둘레 : (side + side) * 2
		//super.perimeter();
		return side * 3;
	}
	@Override
	public String toString() {
		return String.format("도형의 종류: 삼각형, 둘레: %.2fcm, 넓이: %.2fcm²", perimeter(), area());
	}
}
