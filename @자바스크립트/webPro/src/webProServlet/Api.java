package webProServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.fluent.Request;


@WebServlet("/Api") //톰캣에서 contenxt root를 /로 맞출것! 
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Api() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Request.get("요청주소를 우리껄로 바꿈").execute().returnContent();
		String returnStr = Request.get("https://moneys.mt.co.kr/news/mwView.php?no=2022102710451371440")
		.execute().returnContent()
		.asString(); //스트링 형태로 반환
		
		PrintWriter out = response.getWriter();
		out.print(returnStr); //요청받은 곳으로 출력
		

	}

}
