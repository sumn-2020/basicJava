<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//JDBC를 사용해서 DB정보 가져오기 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "JHS", "java");
	Statement stmt = conn.createStatement();
	
	String usrId = request.getParameter("usrId");
	String usrPw = request.getParameter("usrPw");
	String sql = "select mem_id from member where mem_id='" +  usrId  + "' and mem_pass = '" + usrPw + "'";
	
	ResultSet rs = stmt.executeQuery(sql); 
	//System.out.print(rs.next());//rs에 들어오는 데이터를 한줄씩  boolean값으로 값의 유무를 확인

	if(rs.next()) {
%>
		{"rst":"ok"} <%-- 자바 소스 내부에 있어서는 안됨 %밖에 있어야 함 --%>
<%
	}else {
%>		
		{"rst":"fail"} <%-- 자바 소스 내부에 있어서는 안됨 %밖에 있어야 함 --%>
<%		
	}
%>	
	

