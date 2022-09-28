package assign;

public class assign0927 {

	// 문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
	// (단, enum 객체 생성시 반지름을 이용하도록 정의하시오.)

	/*
	 * 예) 행성의 반지름(KM): 수성(2439), 금성(6052), 지구(6371), 성(3390), 목성(69911), 토성(58232),
	 * 천왕성(25362), 해왕성(24622)
	 * 
	 */
	
	// 데이터값을 임의로 지정한 열거형 객체 선언
	// 데이터값을 정해줄 경우에는 생성자를 만들어서 괄호속의 값이 변수에 저장되도록 한다.
	public enum Planet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);

		// 괄호속의 값이 저장될 변수 선언
		private int km;

		// 생성자 만들기(열거형의 생성자는 제어자가 묵시적으로 'private'이다.)
		Planet(int data) {
			this.km = data;
		}

		// 값을 반환하는 메서드(Setter)
		public int getKm() {
			return this.km;
		}

	};

	public static void main(String[] args) {
		
//		Planet pp = Planet.valueOf("수성");
//		System.out.println(pp.name()); //열거형 상수의 이름을 문자열로 반환한다. 
//		System.out.println(pp.ordinal()); //열거형 상수가 정의된 순서값을 반환한다.(기본적으로 0부터 시작) 
//		System.out.println(pp.getKm()); //지정된 열거형에서 '열거형상수이름'과 일치하는 열거형상수를 반환한다.
//		System.out.println("===================================");
		
		// 열거형이름.values() => 데이터를 배열로 리턴함
		Planet[] planetArr = Planet.values();
		for (Planet p : planetArr) {
			System.out.println(p.name() + ":" + p.getKm() + "Km");
		}
	}
}
