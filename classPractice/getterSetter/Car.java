package getterSetter;

public class Car {

	// 필드 - 필드는 private로 막고 getter와 setter을 통해서 접근할 수있도록 한다.
	private int speed; //int의 default값 0
	private boolean stop; //boolean의 default값 false

	// 메소드 - 메소드에 public을 사용하여 getter setter을 사용하면서 상단데 private로 간접적으로 접근
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {// 1 스피드를 외부에서 가져와서 매개변수에 담고
		if (speed < 0) {// speed가 0보다 작으면
			this.speed = 0; // speed = 0
			return;
		} else {
			this.speed = speed; // speed가 0보다 크면 private int speed에 그 수를 담고 getSpeed 메소드로 가서 speed 값 출력
		}
	}

	public boolean isStop() {
		return stop; //boolean의 default값 false
	}

	public void setStop(boolean stop) { //true를 받는다 
		this.stop = stop; //this.stop = true => 상단에 있는 stop변수로 true 값이 들어감 
		this.speed = 0;
	}

	
	//setter는 값을 입력할때 쓰이는 거고
	//getter는 값을 출력할 때 쓰임 
}
