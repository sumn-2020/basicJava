package practice.Polymorphism1;

public class DriverExample {
	public static void main(String[] args) {
		
		
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus); //Driver 클래스의 drive메소드 매개변수 안으로 new Bus()객체 전달
		//출력 : 버스가 달립니다. 
		
		driver.drive(taxi);//Driver 클래스 속의 drive메소드 매개변수 안으로  new Taxi() 객체 전달됨 
		//출력: 택시가 달립니다. 
		
	}
}
