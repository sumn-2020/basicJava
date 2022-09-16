

//내용물이 변하지 않고 마치 상수처럼 사용되는 값들을 리스트로 묶어놓고 사용하는 것
public enum Day {
	MON("워룡일"),
	TUE("화요일"),
	WED("수요일"),
	THU("목요일"),
	FRI("금요일"),
	SAT("토요일"),
	SUN("이룡일");
	
	private final String label;
	
	Day(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
