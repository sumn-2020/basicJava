package webProServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ajax() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("keyyy");
		System.out.println("전달된 내용>> " + name);

		// 출력스트림PrintWriter: 서블릿으로 들어온 요청을 텍스트 형태로(html형태로) 응답하기 위한 출력 스트림
		response.setCharacterEncoding("utf-8"); // 글자 안깨지게 하기 위해서 (응답데이터 한글깨짐 처리 )
		PrintWriter out = response.getWriter();
		out.print("<h1>로보카" + name + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("keyyy"); // keyyy라는 이름으로 파라미터에 접근
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// out.print("{'key' : 'value'}"); //json object 형태의 데이터를 전달
		out.print("{\"key\" : \"" + param + "\"}"); // json object 형태의 데이터를 전달
	}

}
