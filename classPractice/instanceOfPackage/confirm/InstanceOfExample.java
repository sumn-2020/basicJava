package instanceOfPackage.confirm;

public class InstanceOfExample {
	public static void method(Parent parent) { //Parent parent = new Child(); =>이건 강제타입변환가능 

		if (parent instanceof Child) { // Parent라는 객체가 Child의 인스턴스인가?
			Child child = (Child) parent; // Child의 인스턴스라면
		} else {
			System.out.println("강제형변환할수없음"); 
		}

		// Child child = (Child) parent; //Parent parent = new Child(); => 강제타입변환가능 
		// Parent parent = new Parent(); => Parent를 Child로 강제 캐스팅 불가능

	}

	public static void main(String[] args) {
		method(new Child()); // Child parent = new Child();
		method(new Parent()); // Child parent = new Parent();
	}
}
