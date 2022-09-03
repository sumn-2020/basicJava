package practice.Polymorphism1;

public class Driver {

	public void drive(Vehicle vehicle) { 
		//new Bus()객체가 매개변수로 넘겨짐 :  Vehicle vehicle = new Bus(); -> 자동타입변환 (자동타입변환: 부모 클래스에만 접근가능, 단 재정의되었을 때는 자식클래스거 호출)
		// 이 경우 버스 클래스에서 재정의 되었기 때문에 Bus 클래스 속 메소드 실행 
		vehicle.run(); // 
	}
		
}
