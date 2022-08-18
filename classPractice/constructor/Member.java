package classPractice.constructor;

public class Member {

	// 필드(=속성)
	String name;
	String id;
	String password;
	int age;

	// 생성자 (기본 생성자는 눈에 보이지 않지만 항상 숨겨져있다)
	Member() {

	}

	Member(String n) { // MemberExample.java에서 "이순신"을 받아와서
		name = n; // 상단에 있는 속성에 대입
	}

	Member(String n, String i) { // MemberExample.java에서 "이순신", "이클립스"를 받아와서
		name = n; // 상단에 있는 name 속성에 대입
		id = i; // 상단에 있는 id 속성에 대입
	}

}
