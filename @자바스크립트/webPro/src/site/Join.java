package site;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join")
public class Join extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Join() {

		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doPost(req, resp);
		System.out.println("================접근==============");

		// 결과를 처리하고 응답데이터를 담은 객체를 view페이지로 보내줘야 함
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/test/join.jsp");
		disp.forward(req, resp);

	}

}
