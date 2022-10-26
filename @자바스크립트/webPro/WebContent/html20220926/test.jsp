<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

jsp 페이지<br>


<%
	
	//해당기호 안쪽에 자바코드를 입력할 수 있어요
	String userId = request.getParameter("id");
	String userPw = request.getParameter("pw");

%>

아이디는 <%=userId%><br>
비밀번호는<%=userPw %>이군요


