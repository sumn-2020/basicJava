package package07;

public class DmbCellPhoneExample {
	public static void main(String[] args) {

		// DmbCellPhone 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);

		// CellPhone 클래스로부터 상속받은 필드
		System.out.println(dmbCellPhone.model);
		System.out.println(dmbCellPhone.color);

		// DmbCellPhone클래스의 필드
		System.out.println(dmbCellPhone.channel);

		// Cellphone클래스로부터 상속받은 메소드 호출
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoid("안녕하세요 홍길동입니다.");
		dmbCellPhone.sendVoice("예 반갑습니다");
		dmbCellPhone.hangUp();

		// DmbCellPhone 클래스의 메소드 호출
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();

	}
}
