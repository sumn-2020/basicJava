package Exercise20220826.Exercise2;

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
		return "도형의 종류: 원, 둘레: " + perimeter() + "cm, 넓이 :" + area() + "cm²";
	}
}
