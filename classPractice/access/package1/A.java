package access.package1;

public class A {
	public int field1; 
	int field2;
	private int field3;
	
	public A() { //같은 패키지 같은 클래스 안에 존재 하고있을 땐 public이든 private든 다 접근할 수 있다. 
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	}
	
	public void method1() {
	}
	void method2() {
	}
	private void method3() {
	}
}
