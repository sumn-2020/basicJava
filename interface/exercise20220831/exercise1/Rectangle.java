package exercise20220831.exercise1;

public class Rectangle extends Shape{
	//필드
	private double width;
	private double height;
	
	//생성자
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	//메소드
	@Override
	public double area() { //도형의 넓이 반환 : 가로 * 세로 
		return width * height;
	}
	@Override
	public double perimeter() {//둘레를 반환 : (가로 * 2) + (세로 * 2)
		return (width + height) * 2;
	}
	@Override
	public String toString() {
		return String.format("도형의 종류: 사각형, 둘레: %.2fcm, 넓이: %.2fcm²" ,perimeter(), area());
		
	}
}
