package abstractPackage;

public class LoginServlet extends  HttpServlet { // HttpServlet 상속받아서 HttpServlet에 있는 service 사용 

	@Override
	public void service() {
		System.out.println("로그인합니다.");
	}
}
