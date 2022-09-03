package practice.nestedClass;

import practice.nestedClass.OuterClass.InnerClass;
import practice.nestedClass.OuterClass.StaticInnerClass;

public class OuterClassExample {
	public static void main(String[] args) {

		OuterClass outerClass = new OuterClass();

		// inner 클래스 객체 생성
		InnerClass inner = outerClass.new InnerClass();
		inner.setInnerField(100);
		System.out.println(inner.getInnnerField());

		// static 객체 생성
		StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
		staticInner.setStaticInnerField(200);
		System.out.println(staticInner.getStaticInnerField());

	}
}
