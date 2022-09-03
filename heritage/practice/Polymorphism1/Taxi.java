package practice.Polymorphism1;

public class Taxi extends Vehicle {
	@Override 
	public void run() { //Vehicle vehicle = new Taxi(); ->자동타입변환 (자동타입변환될 경우 부모클래스거 들고오는게 원칙이지만, 상속받은 자식클래스에서 재정의되면 자식 클래스거 들고옴)
		System.out.println("택시가 달립니다.");
	}
}
