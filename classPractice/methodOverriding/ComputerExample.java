package methodOverriding;

public class ComputerExample {
	public static void main(String[] args) {

		Calcuator calcuator = new Calcuator();
		System.out.println(calcuator.areaCircle(10));

		System.out.println();

		Computer computer = new Computer();
		System.out.println(computer.areaCircle(10));
	}
}
