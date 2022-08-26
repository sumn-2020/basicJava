package abstractPackage;

public class FileDownloadServlet extends  HttpServlet { // HttpServlet 상속받아서 HttpServlet에 있는 service 사용 

	@Override
	public void service() {
		System.out.println("파일 다운로드합니다.");
	}

}
