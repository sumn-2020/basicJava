package package07;

public class DmbCellPhone extends CellPhone {

	// 필드
	int channel;
	// 부모로부터 상속받아서 선언해 줄 필요 없음
	// String model;
	// String color;

	// 생성자
	public DmbCellPhone(String model, String color, int channel) {
		//super(model, color); // this 나 자신(제일 상단에 있는 필드) / super : 부모 생성자 호출 (Cellphone(){}이라는 생성자 호출) - 생략가능 
		super();
		this.model = model; // Cellphone클래스로부터 상속받은 필드 // 일단 자식 에 있는 model을 검색한 후 없으면 부모에 있는 model검색
		this.color = color; // Cellphone클래스로부터 상속받은 필드
		this.channel = channel;
	}
	
	//자식객체 생성자 : super가 생략되어있음 

	// 메소드
	void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다.");
	}

	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다.");
	}

	void turnOffDmb() {
		System.out.println("DMB방송수신을 멈춥니다.");
	}

}
