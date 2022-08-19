package classPractice.constructor;

public class Member2 {
	String name;
	String id;
	String password;
	int age;
	
	Member2() {	
	}

	Member2(String name) { // 외부에서 값을 받아서 name에 넣어줌  
		this(name, null);  //클래스 내부에 있는 생성자들 중에서 매개변수가 두개인 생성자를 찾아서 
	}
	
	Member2(String name, String id) { //보통 매개변수는 불러오는 값과 동일하게 쓰는데 동일하게 쓰게되면 소스가 중복될 가능성 있음 => this사용 해서 중복성 줄이기! 
		this.name = name;  //왼쪽에 있는 this.name은 상단에 있는 name변수, 오른쪽에 있는 name은 매개변수에 있는 name받아옴 
		this.id = id;
	}
	
	
}
