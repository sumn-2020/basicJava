<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	request.setCharacterEncoding("utf-8"); //넘어오는 데이터가 깨지는거 방지
	//String name = request.getParameter("dataNameName"); //get방식 - dataNameName이름으로 된  데이터를 String 형태로 받아준다.
	String name = request.getParameter("keyyy"); //post방식
%>


<%-- 넘어온 데이터(get방식) : <%=name %> --%>
넘어온 데이터(post방식) : <%=name %>
 