package instanceOfPackage;

public class Driver {

	public void drive(Vehicle vehicle) { // Taxi vehicle, Bus vehicle도 될 수 있으나 => Vehicle을 선언해두고 Vehicle을 상속받은 Taxi와 Bus도 같이 쓸수 있음
		vehicle.run();
	}

}
