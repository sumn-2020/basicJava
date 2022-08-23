package exercise20220823;

public class Car {

	// 필드
	private double speed;
	private String color;
	private static final double MAX_SPEED = 200;

	// 생성자
	Car() {
	}

	Car(String color) {
		this.color = color;
	}

	// getter setter
	// color
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// speed
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	// 메소드
	boolean speedUp(double speed) {
		// 속력을 높이거나 내리는 메소드
		// 목표 속도가 0보다 작거나 최대 속력을 넘으면 "현재 속도를 그대로 유지하고" false값을 반환
		// 그렇지 않으면 "전달인자(speed)의 값만큼 속도를 변경"하고 true를 반환
		if (speed < 0 || speed > MAX_SPEED) {
			return false; // 현재 속도를 유지
		} else {
			this.speed = this.speed + speed; // 전달받은 인자만큼 속도를 더해서 변수에 넣기
			return true;
		}
	}

	static double getMaxSpeed() {
		// 최대 속력값을 반환하는 정적메소드
		return MAX_SPEED;
	}

}
