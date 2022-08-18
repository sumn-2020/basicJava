package classPractice.constructor;

public class MemberExample {
	public static void main(String[] args) {

		// 객체를 생성하고 객체 안에 이순신이라는 글자를 넣으면 클래스 속에 들어있는 생성자 String n에 넘겨짐
		Member member1 = new Member("이순신");
		System.out.println(member1.name);

		System.out.println();

		// 또 다른 객체를 생성하고 객체 안에 홍길동, 이클립스라는 글자를 넣으면 클래스 속에 들어있는 생성자 String n, String i에 넘겨짐
		Member member2 = new Member("홍길동", "이클립스");
		System.out.println(member2.name);
		System.out.println(member2.id);

	}
}
