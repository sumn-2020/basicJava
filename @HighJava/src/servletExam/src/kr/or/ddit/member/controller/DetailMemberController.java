package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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


@WebServlet("/member/detail.do")
public class DetailMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 값 조회
		String memId = req.getParameter("memId");
		
		// 서비스객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = memService.getMember(memId);
		
		if(mv.getAtchFileId() > 0) { //첨부파일이 존재하면..
			
			// 첨부파일 목록 조회
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			AtchFileVO atchFileVO = new AtchFileVO();
			atchFileVO.setAtchFileId(mv.getAtchFileId());
			
			List<AtchFileVO> atchFileList =  fileService.getAtchFilList(atchFileVO);
			
			req.setAttribute("atchFileList", atchFileList);

			
		}
		
		req.setAttribute("mv", mv);
		
		//JSP에게 포워딩 처리(앞단 그림그리는건 니가 해라라고 던지는거)
		req.getRequestDispatcher("/WEB-INF/views/member/detail.jsp").forward(req, resp);
		
		
		
		
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
