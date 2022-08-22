package access.package2;

import practice.A;

public class C {
	public C() {
		A a = new A();

		//다른 패키지에 있기 때문에 public에만 접근가능하고 default private에는 접근 불가능 
		a.field1 = 1;
		a.method1(); 
	}
}
