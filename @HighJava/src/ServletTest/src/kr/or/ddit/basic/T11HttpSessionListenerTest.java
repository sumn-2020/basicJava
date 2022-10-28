package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T11HttpSessionListenerTest extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		req.setAttribute("ATTR1", "속성1");
		req.setAttribute("ATTR1", "속성11");
		req.setAttribute("ATTR2", "속성2");
		
		req.removeAttribute("ATTR1");
		
		
		//세션 destroy
		//session.invalidate();
		
		//HTTP 세션 영역내에 HttpSessionBindingListener를 구현한 
		// 객체가 바인딩 되면 호출됨 
		MySessionBindingListner bindingListner = new MySessionBindingListner();
		session.setAttribute("obj", bindingListner);
		session.removeAttribute("obj");
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
