package kr.or.ddit.basic;

import java.io.Serializable;

public class Service implements Serializable {

	@PrintAnnotation // 선언한 annotation 호출
	public void method1() throws Exception {
		System.out.println("메서드1에서 출력됨");
	}

	@PrintAnnotation(value = "%")
	public void method2() {
		System.out.println("메서드2에서 출력됨");
	}

	@PrintAnnotation(value = "#", count = 25)
	public void method3() {
		System.out.println("메서드3에서 출력됨");
	}

}
