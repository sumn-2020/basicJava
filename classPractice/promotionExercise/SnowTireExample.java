package promotionExercise;

public class SnowTireExample {
	public static void main(String[] args) {

		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire; // => Tire tire = new snowTire();

		snowTire.run();//SnowTire에 있는 run메소드 가져다 씀
		tire.run(); //SnowTire에 있는 run메소드 가져다 씀 

	}
}
