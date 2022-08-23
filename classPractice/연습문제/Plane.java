package exercise20220823;

public class Plane {

	// 필드
	private String manufacture; // 제작사
	private String model; // 비행기 모델명
	private int maxNumberOfPassengers; // 최대 승객 수
	private static int numberOfPlanes;
	// 지금까지 생성된 비행기 객체의 수, 정적변수로 선언, 객체가 생성될 때마다 생성자에서 증가시켜 줌

	// 생성자
	public Plane() { // 모든 필드를 0으로 초기화
		numberOfPlanes++;
	}

	public Plane(String manufacture, String model, int maxNumberOfPassengers) {
		this.manufacture = manufacture;
		this.model = model;
		this.maxNumberOfPassengers = maxNumberOfPassengers;
		numberOfPlanes++;
	}

	// 각 필드의 getter setter
	// getManufacture getter setter
	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	// getModel getter setter
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;

	}

	// getMaxNumberOfPassengers getter setter
	public int getMaxNumberOfPassengers() {
		return maxNumberOfPassengers;
	}

	public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
		if (maxNumberOfPassengers < 0) {
			this.maxNumberOfPassengers = 0;
		} else {
			this.maxNumberOfPassengers = maxNumberOfPassengers;
		}
	}

	// getNumberOfPlanes의 값 반환하는 정적 메소드
	public static int getNumberOfPlanes() {
		return numberOfPlanes;
	}

}
