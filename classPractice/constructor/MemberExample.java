package classPractice.constructor;

public class MemberExample {
	public static void main(String[] args) {
		
		
		Member member1 = new Member("이순신");
		System.out.println(member1.name); //member 클래스 내부에 있는 member생성자에있는 name을 호출
		
		System.out.println();
		
		Member member2 = new Member("홍길동","별명"); //member클래스 내부에 있는 생성자 중 매개변수가 두 개인 생성자를 찾아서 매개변수에 넘겨줌 
		System.out.println(member2.name); //member생성자에 있는 name 호출  
		System.out.println(member2.id); //member생성자에 있는 id호출
		
		
		
		
		
	}
}
