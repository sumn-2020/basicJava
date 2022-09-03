package practice.Polymorphism3;

public class SnowTireExample {
	public static void main(String[] args) {
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire; // 자동타입변환 => Tire tire = new snowTire();
		
		snowTire.run(); // SnowTire 클래스에 있는 run메소드 출력 => 스노우 타이어가 굴러갑니다.
		tire.run(); // Tire 클래스에 있는 run 메소드 출력 => 일반 타이어가 굴러갑니다.
		
	}
}
