package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T06ServletSessionTest extends HttpServlet{
	/*
	 세션(HttpSession)객체에 대하여..
	 
	 - 세션을 통해서 사용자(웹브라우저)별로 구분하여 정보를 관리할 수 있다.
	 	(세션ID 이용)
	 - 쿠키를 사용할 때보다 보안이 향상된다. (서버에 정보가 저장되기 때문에)
	 
	 - 세션객체를 가져오는 방법
	 	HttpSession session = request.getSession(boolean값)
	 	boolean값 : true인 경우 => 세션객체가 존재하지 않으면 새로 생성. (기존에 만들어진 세션이 없을 경우)
	 			   false인 경우 => 세션객체가 존재하지 않으면 null리턴 (기존에 만들어진 세션이 이미 존재할 경우)

	- 세션 삭제 처리 방법
	  1. invalidate()메서드 호출
	  2. setMaxInactiveInterval(int interval) 호출
	  	 = 일정시간(초) 동안 요청이 없으면 세션객체 삭제됨
	  3. web.xml에  <session-config> 설정하기 (분 단위)

		쿠키: 각 클라이언트들의 브라우저에 정보를 저장하기 때문에 서버에 따로 데이터를 저장할 필요 없음 하지만 보안 취약 
			한 요청이 끝나면 쿠키는 종료됨 
		세션: 브라우저가 종료될때까지는 세션 유지  / 사용자별 하나의 세션만 제공됨 

	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//세션을 가져오는데 없으면 새로 생성한다.
		HttpSession session = req.getSession(true);
		
		// 생성시간 가져오기 
		Date createTime = new Date(session.getCreationTime());
		
		//마지막 접근시간 가져오기
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String title = "재방문을 환영합니다.";
		int visitCnt = 0; //방문횟수
		String userId = "SEM"; //사용자 ID
		
		if(session.isNew()) { //새로만든 세션인지..
			title = "처음 방문을 환영합니다.";
			session.setAttribute("userId", userId);
		}else {
			visitCnt = (int) session.getAttribute("visitCnt");
			visitCnt++; //방문횟수 추가
			userId = (String) session.getAttribute("userId");
		}
		session.setAttribute("visitCnt", visitCnt); // 사용자별 한개씩 만들어줌. 브라우저 종료되기 전까지는 세션 누적됨
		
		//세션 삭제 
//		session.invalidate(); // 1번째 방법
//		session.setMaxInactiveInterval(30); //2번째 방법: 30초 뒤에 세션 삭제됨
		
		
		
		
		/////////////////////////////////////////////////////
		
		//응답시작....
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>" + title 
				+ "</title></head>"
				+ "<body>"
				+ "<h1 align=\"center\">" + title + "</h1>"
				+ "<h2 align =\"center\">세션정보</h2>"
				+ "<table border=\"1\" align=\"center\">"
				+ "<tr bgcolor=\"orange\">"
				+ "<th>구분</th><th>값</th><tr>"
				+ "<tr><td>세션ID</td><td>" 
				+ session.getId() + "</td></tr>"
				+ "<tr><td>생성시간</td><td>" 
				+ createTime + "</td></tr>"
				+ "<tr><td>마지막접근시간/td><td>" 
				+ lastAccessTime + "</td></tr>"
				+ "<tr><td>UserID</td><td>" 
				+ userId + "</td></tr>"
				+ "<tr><td>방문횟수</td><td>" 
				+ visitCnt + "</td></tr>"
				+"</body></html>"
		);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
}
