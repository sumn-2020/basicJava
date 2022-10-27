package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T05ServletCookieTest extends HttpServlet {
	
	
	// 다른 메소드가 있긴 하지만 "브라우저"를 통해서 서버쪽으로 요청하는 방법은 아래 두개 메소드만 사용할 수 있음
	// a링크 : get방식
	// form: post방식 
	// get, post방식 차이점: body의 존재 유무 => get은 body있고, post는 없음 (doQuery?있고 없고)
	
	
	/*
	 	쿠키정보를 다루기 위한 예제
	 	(웹서버와 브라우저는 애플리케이션에서 사용중인 필요한 값을 쿠키를 이용하여 상태정보를 유지함)
	 	
	 	 1. 구성요소 
	 	 - 이름
	 	 - 값 
	 	 - 유효시간(초) - 클라이언트(브라우저)에 박아둠
	 	 - 도메인 : ex) www.somehost.com, .somhost.com
	 	 - 경로: 쿠키를 공유할 기준경로(도메인 이후부분으로 디렉토리 수준)
	 	    => 지정하지 않으면 실행한 URL의 경로부분으로 지정됨 
	 	    
	 	 2. 동작방식
	 	 - 쿠키생성단계 : 생성한 쿠리르 응답데이터의 헤더에 저장하여 웹브라우저에 저장한다.
	 	 - 쿠키저장단계 : 브라우저는 응답데이터에 포함된 쿠키를 쿠키저장소에 보관한다. 
	 	 - 쿠키전송단계 : 브라우저는 저장한 쿠키를 요청이 있을때마다 웹서버에 전송한다.(삭제되기 전까지..)
	 	 웹서버는 브라우저가 전송한 쿠키를 사용해 필요한 작업을 수행한다.
	 	 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//setCookieExam(req,resp); //쿠키 생성 예제
		//readCookieExam(req,resp); //쿠키 정보 읽기 예제
		deleteCookieExam(req, resp); //쿠키정보 삭제 예제
		
	}
	
	//쿠키삭제하는 메소드
	private void deleteCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		/*
		 	사용중이 쿠키정보를 삭제하는 방법
		 	
		 	1. 사용중인 쿠키정보를 이용하여 쿠키 객체를 생성한다.
		 	2. 쿠키객체의 최대지속시간을 0으로 설정한다.
		 	3. 설정한 쿠키객체를 응답헤더에 추가하여 전송한다.
		  
		 */
		
		// 현재 도메인에서 사용중인 쿠키정보 배열 가져오기
		Cookie[] cookies = req.getCookies();
		
		///////////////////////////////////////
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title  = "쿠키정보 삭제 예제";
		
		out.println("<html><head><title>" + title 
				 + "</title></head>"
				 + "<body>");
		
		if(cookies != null) {
			out.println("<h2>" + title + "</h2>");
			
			for (Cookie cookie : cookies) {
				
				if(cookie.getName().equals("userId")){
					//쿠키삭제하기
					cookie.setMaxAge(0);
					
					resp.addCookie(cookie);
					
					out.print("삭제한 쿠키: " + cookie.getName() + "<br>");
				}
				out.print("쿠키이름: " + cookie.getName() + "<br>");
				out.print("쿠키값: " + cookie.getValue() + "<br>");
			}
		}else {
			out.print("<h2>쿠키정보가 없습니다.</h2>");
		}
		out.print("</body></html>");
		
		
	}


	//쿠키 정보 읽어오는 메소드
	private void readCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// 현재 도메인에서 사용중인 쿠키정보 배열 가져오기
		Cookie[] cookies = req.getCookies();
		
		///////////////////////////////////////
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title  = "쿠키정보 읽기 예제";
		
		out.println("<html><head><title>" + title 
				 + "</title></head>"
				 + "<body>");
		
		if(cookies != null) {
			out.println("<h2>" + title + "</h2>");
			
			for (Cookie cookie : cookies) {
				out.print("name : " + cookie.getName() + "<br>");
				out.print("value : " + cookie.getValue() + "<br>");
				out.print("<hr>");
			}
		}else {
			out.print("<h2>쿠키정보가 없습니다.</h2>");
		}
		out.print("</body></html>");
		
		
	}

	
	//쿠키 생성하는 메소드
	private void setCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		//쿠키객체 생성하기
		// 사용불가문자(공백, []()=, "/?@:;) => RFC2965
		// 쿠키값은 사용불가 문자를 제외한 나머지 출력가능한 아스키 문자만 사용 가능함.
		// 이외의 값(예를들면 한글)을 사용시에는 URLEncoder.encode() 사용하여 인코딩 처리를 해준다. 
		Cookie userId = new Cookie("userId", req.getParameter("userId"));
		Cookie name = new Cookie("name", req.getParameter("name"));
		
		// 쿠키 최대 지속시간 설정하기(초단위)
		// 지정하지 않으면 웹브라우저 종료시 쿠키정보는 삭제된다.
		userId.setMaxAge(60*60*24); //60초 * 60초 * 24 => 하루동안 유지 
		// 자바스크립트 통한 직접 접근방지
		userId.setHttpOnly(true); 
		
		name.setMaxAge(60*60*48); //이틀동안 유지 
		
		// 응답헤더에 쿠키 추가
		resp.addCookie(userId); //내가 만든 쿠키 객체를 브라우저에 추가 (개발자도구 network에서 "set-Cookie" 만들어주는 메소드)
		resp.addCookie(name);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title = "쿠키설정 예제";
		
		out.println("<html><head><title>" + title 
				+ "</title></head>"
				+ "<body>"
				+ "<h1 align=\"center\">" + title + "</h1>"
				+ "<ul>"
				+ "<li><b>ID</b>:" + req.getParameter("userId") + "</li>"
				+ "<li><b>이름</b>:" + req.getParameter("name") + "</li>"
				+ "</ul></body></html>");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
