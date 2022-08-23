package exercise20220823;

public class Time {

	// 필드
	private int hour; // 0~23까지의 값
	private int minute; // 0~59까지의 값
	private int second; // 0~59까지의 값

	// 생성자
	public Time() { // default 생성자, 모든 필드를 0으로 초기화한다.
	}

	public Time(int hour, int minute, int second) { // 인자로 전달된 값으로 해당 필드를 초기화하고, 유효범위를 벗어나는 값이 전달되면 해당 필드를 0으로 초기화한다.
		if (hour <= 0 && hour > 23) {
			this.hour = 0;
		} else {
			this.hour = hour;
		}

		if (hour <= 0 && minute > 59) {
			this.minute = 0;
		} else {
			this.minute = minute;
		}

		if (hour <= 0 && second > 59) {
			this.second = 0;
		} else {
			this.second = second;
		}
	}

	// 메소드
	public String toString() { // Time객체의 상태(현재 필드들의 값)를 문자열로 반환
		String result = String.format("%02d:%02d:%02d", hour, minute, second);
		return result;
	}

}
