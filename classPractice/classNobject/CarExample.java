package classPractice.classNobject;

public class CarExample {
	public static void main(String[] args) {
		
		//객체를 이용하여 여러대의 차를 만들 수 있음 
		Car car1 = new Car();
		System.out.println(car1.company);
		System.out.println(car1.model);
		car1.color = "검정";
		System.out.println(car1.color);
		System.out.println(car1.speed); //default된 값을 초기화 시키지 않고 그대로 출력할 경우 default값 그대로 나옴.
			
		Car car2 = new Car();
		car2.model = "기아자동차"; //새로운 값을 넣으면 값이 새롭게 초기화 됨 
		System.out.println(car2.model);

		
	}
}
