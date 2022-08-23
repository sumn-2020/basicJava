package exercise20220823;

public class Circle {
	double radius; // 반지름
	double x; // x좌표
	double y; // y좌표

	Circle() { // default 생성자

	}

	// 각 필드의 setter getter
	// y의 getter setter
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// x의 getter setter
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	// radius의 getter setter
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius < 0) {
			this.radius = 0;
			return;
		} else {
			this.radius = radius;
		}
	}

	// getArea
	double getArea() { // 원의 넓이를 계산해서 반환 (반지름)×(반지름)×(원주율)
		double result = radius * radius * Math.PI;
		return result;

	}

}
