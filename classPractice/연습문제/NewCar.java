package exercise20220823;

public class NewCar {

	// 필드
	private double speed; // 현재속도
	private String color;
	private static final double MAX_SPEED = killoToMile(200.0);

	// 생성자
	public NewCar() {

	}

	public NewCar(String color) {
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
		return mileToKilo(speed);
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	// 메소드
	static double getMaxSpeed() {
		return mileToKilo(MAX_SPEED);
	}

	// 추가
	boolean speedUp(double speed) {
		if (killoToMile(speed) < 0 || killoToMile(speed) > MAX_SPEED) {
			return false;
		} else {
			this.speed = this.speed + killoToMile(speed);
			return true;
		}
	}

	private static double killoToMile(double distance) {
		return distance / 1.6;
	}

	private static double mileToKilo(double distance) {
		return distance * 1.6;
	}

}
