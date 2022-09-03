package practice.Polymorphism2;

public class ChildExample {
	public static void main(String[] args) {
		
		Parent parent = new Child(); //자동타입변환
		parent.field1 = "data1"; //Parent클래스 속 field1에 data1 넣기
		parent.method1(); //Parent클래스 속 method1메소드 접근/ 출력 : Parent-method1()
		parent.method2(); //Parent클래스 속 method2메소드 접근/ 출력 : Parent-method2()
		
		//parent.field2 = "data2"; //Parent클래스 속 field2필드에 넣기 => 근데 Parent 클래스에 해당 필드가 없어서 오류 
		//parent.method3();
		
		
		Child child = (Child) parent;//parent를 Child타입으로 강제변환해서 Child 클래스 속에 있는 field2, method3사용할 수 잇음 
		child.field2 = "yyy";
		child.method3();
		
		
		
	}
}
