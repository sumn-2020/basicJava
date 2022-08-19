package classPractice.method;

public class MemberServiceExample {
	public static void main(String[] args) {
		
		
		MemberService memberService = new MemberService();
		
		boolean result = memberService.login("hong", "12345"); //각각의 값들을 login 메소드로 넘겨서 메소드내부에서 처리 후 값을 반환받아와서 result 변수에다가 넣어둔다.
		
		if(result) { //login 메소드에서 받아온 값이 true면 
			System.out.println("로그인되었습니다"); //로그인되었습니다. 출력
			memberService.logout("hong"); //logout 메소드로 hong 이라는 인수를 보내서 logout 메소드 실행
		}else {//login메소드에서 받아온 값이 false면 
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
		
	}
}
