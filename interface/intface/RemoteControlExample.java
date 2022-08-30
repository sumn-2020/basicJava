package chapter08.intface;

public class RemoteControlExample {
	public static void main(String[] args) {
		//new RemoteControl(); //인터페이스는 객체 생성 불가 
		
		RemoteControl control = new Television(); //실제 동작은 Television이 하고있지만, 보고있는건 RemoteContorol을 보고 있음 
		control.turnOn();
		control.setVolume(5);
		
		System.out.println();
		
		control = new Audio(); //실제 동작을 Television에서 Audio로 변경 
		control.turnOn();
		control.turnOff();
		control.setVolume(10);
		
		System.out.println();
		
		Television tv = new Television();
		RemoteControl control2 = tv;
		Searchable searchable = tv;
		control2.turnOn();
		control2.setVolume(7);
		tv.search("홍길동");
	}
}
