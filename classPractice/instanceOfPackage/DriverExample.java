package instanceOfPackage;

public class DriverExample {
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		driver.drive(new Bus()); // Vehicle vehicle = new Bus(); => new Bus()가 Driver에 있는 public void drive(Vehicle vehicle){} 에서 Vehicle vehicle이라는 매개변수에 들어감 
		driver.drive(new Taxi()); // Vehicle vehicle = new Taxi();
		driver.drive(new Vehicle()); // Vehicle vehicle = new Vehicle();
		
		
	}
} 
