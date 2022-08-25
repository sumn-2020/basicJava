package methodOverriding;

public class SupersonicAirplaneExample {
	public static void main(String[] args) {

		SupersonicAirplane sa = new SupersonicAirplane();

		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		sa.fly();
		sa.land();

	}
}
