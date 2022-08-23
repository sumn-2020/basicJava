package singleTon;

public class MemberServiceExample {
	public static void main(String[] args) {
		
		MemberService memberService = MemberService.getInstance();

		boolean result = memberService.login("hong", "12345");

		if (result) {
			System.out.println("로그인되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id또는password가 올바르지 않습니다.");
		}
	}

}
