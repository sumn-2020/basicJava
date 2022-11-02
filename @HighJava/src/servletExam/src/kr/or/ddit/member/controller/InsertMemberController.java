package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.com.service.AtchFileServiceImpl;
import kr.or.ddit.com.service.IAtchFileService;
import kr.or.ddit.com.vo.AtchFileVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@MultipartConfig
@WebServlet("/member/insert.do")
public class InsertMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//파라미터값 가져오기
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		//서비스 객체 생성하기
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		IMemberService memService = MemberServiceImpl.getInstance();
		
		AtchFileVO atchFileVO = new AtchFileVO();
		
		//첨부파일 목록 저장하기(공통기능)
		atchFileVO = fileService.saveAtchFileList(req);
		
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		mv.setAtchFileId(atchFileVO.getAtchFileId());
		
		int cnt = memService.registMember(mv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
			//성공
		}else {
			msg = "실패";
			//실패
		}

		//redirect방식이기때문에 getsession을 이용해서 정보를 저장해 둬야됨 
		req.getSession().setAttribute("msg", msg);
		
		//req.getRequestDispatcher("/member/list.do").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/member/list.do"); //   = servletExam/member/list.do

		
		//forward는 요청 한번  / redirect는 한번 요청하는데 서버가 경로 지 맘대로 바꾸기 때문에 한번더 요청 해야됨 
		// 그래서 redirect 쓸 경우 req.getcontextPath() 써줘야됨 
		//getRequestDispatcher("/member/list.do")
		//sendRedirect(req.getContextPath() + "/member/list.do")
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
