package methodOverriding;

public class SupersonicAirplane extends Sairplane {
	public static final int NORNAL = 1;
	public static final int SUPERSONIC = 2;

	public int flyMode = NORNAL;

	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		} else {
			super.fly();
		}
	}
}
