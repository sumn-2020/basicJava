package classPractice.method;

public class MemberService {
	
	String id;
	String password;
		
	
	// 메소드
	boolean login(String id, String password) {//외부에서 id와 password값 받아옴
		if(id.equals("hong") && password.equals("12345")) { //외부에서 받아온 id와 password가 "hong"과 "12345"랑 같다면
			return true; // 참값 true 반환
		}else {
			return false; //거짓값 false 반환
		}
		
	}

	void logout(String id) { 
		System.out.println("로그아웃 되었습니다.");
	}

}
