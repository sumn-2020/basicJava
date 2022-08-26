package abstractPackage;

public class HttpServletExample {
	
	public static void main(String[] args) {
		
		// 1) method(매개변수) 형태를 가진 메소드를 찾아서 이동 
		method(new LoginServlet()); //로그인합니다.
		method(new FileDownloadServlet()); //파일 다운로드합니다.
	}
	
	public static void method(HttpServlet servlet) {
		servlet.service();
		//  2) HttpServlet servlet = new LoginServlet(); => LoginServlet클래스 안에 있는 service메소드 가져다 씀
		//  3) HttpServlet servlet = new FileDownloadServlet(); => FileDownloadServlet클래스 안에 있는 service메소드 가져다 씀
	}
	
}
