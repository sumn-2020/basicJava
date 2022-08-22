package access.package1;

public class B {
	public B() {
		A a = new A();
		
		//같은 패키지 내에 있기 때문에 default접근제한자와 public 접근제한자에만 접근가능하고
		//private에는 접근이 불가능함 
		a.field1 = 1;
		a.field2 = 2;
		a.method1();
		a.method2();
	}
}
