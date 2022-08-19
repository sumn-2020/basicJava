package classPractice.constructor;

public class Member {
	String name;
	String id;
	String password;
	int age;
	
	Member(){	
	}
	
	Member(String n) { //MemberExample.java에 있는 "이순신"을 받아와서 넣어줌 
		name = n; //name은 상단에 있는 최고 상단에 있는 name변수 받아오고, n은 매개변수에 있는 String n을 받음 
	}
	
	Member(String n, String i) {
		name = n;
		id = i;
	}
	
	
}
