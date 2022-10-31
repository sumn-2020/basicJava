package webProServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

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

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		// url규칙(ASCII로 표현)에 맞게 한글을 인코딩해줘야 함
		// URLEncoder URLDecoder
		String keywd =  URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		System.out.println("============" + keywd + "============");

//		Request.get("요청주소를 우리껄로 바꿈").execute().returnContent();
		String returnStr = Request.get("https://news.google.com/rss/search?q=" + keywd + "&hl=ko&gl=KR&ceid=KR:ko")
		.execute()
		.returnContent()
		.asString(); //스트링 형태로 반환
		
		PrintWriter out = response.getWriter();
		out.print(returnStr); //요청받은 곳으로 출력
		

	}

}
