package chapter09;

import chapter09.OuterClass.InnterClass;
import chapter09.OuterClass.StaticInnerClass;

public class OuterExample {
	public static void main(String[] args) {
		OuterClass outter = new OuterClass();
		InnterClass inner = outter.new InnterClass(); //outer속에 들어있는 클래스인 inner클래스를 호출 
		//InnterClass inner = new OuterClass().new InnterClass();
		inner.setInnerField(100);
		System.out.println(inner.getInnerField());
		
		StaticInnerClass staticInner = new OuterClass.StaticInnerClass(); // OuterClass안에 있는 StaticInnerClass 클래스 호출 
		staticInner.setStaticInnerField(200);
		System.out.println(staticInner.getStaticInnerField());
	}
}
