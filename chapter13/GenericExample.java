package chapter13;

import java.util.List;
import chapter11.confirm.Member;
import java.util.ArrayList;

public class GenericExample {
	public static void main(String[] args) {

		List<String> arrayList = new ArrayList<String>();

		// 방법1) 각각 클래스를 따로 생성해서 각각의 클래스에서 받아온 생성자로 출력
		StringBox stringBox = new StringBox("홍길동");
		IntegerBox integerBox = new IntegerBox(100);
		MemberBox memberBox = new MemberBox(new Member("1", "a"));

		// 방법2) box라는 클래스 하나만 만들어두고 Object라는 매개변수를 쓰면 어떠한 타입도 다 넣어서 관리 할 수 있다.
		Box box1 = new Box("홍길동");
		Box box2 = new Box(100);
		Box box3 = new Box(new Member("1", "a"));
		if (box1.getValue() instanceof String) { // 하지만 이러한 방법은 단점이 있음:  box1.getValue()이 String 타입으로 캐스팅 가능한지 확인한 후
			String value1 = (String) box1.getValue();
		}

		String value = (String) box1.getValue(); // 출력시에 해당 타입으로 강제 캐스팅해야 쓸수 있음
		int value2 = (int) box2.getValue();
		Member value3 = (Member) box3.getValue();

		// 방법3 이러한 모든점들을 보완해준게 바로 "제네릭"
		Box<String> box = new Box<String>("홍길동"); // box클래스에 타입은 String이라고 지정, 내가 arguments를 넣는 순간 자동으로 타입이 지정됨
		String value4 = box.getValue();

		Box<Member> box4 = new Box<>(new Member("1", "a")); // 1.7버전부터는 <>으로 써도 무방

	}
}
