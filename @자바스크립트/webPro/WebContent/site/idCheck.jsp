<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <%
 
 	String uId = request.getParameter("userId");
 	Class.forName("oracle.jdbc.driver.OracleDriver");
 	String url = "jdbc:oracle:thin:@localhost:1521:xe";
 	Connection conn = DriverManager.getConnection(url, "JHS", "java");
 	//conn.createStatement();
 	Statement stmt = conn.createStatement();
 	String sql = "select mem_id from member where mem_id = '" + uId + "'";
 	//stmt.executeQuery(sql);
	ResultSet rs = stmt.executeQuery(sql);
	
 	if(rs.next()) {
 		//결과가 조회되었을 때 id 사용불가
%>
		<%-- 문자열 주석을 사용 시 다음과 같이 표기해야 서버쪽 에서(500)가 발생하지 않음  --%>
 		{
	 		"code": "no", 
	 		"msg":"사용불가"
 		}
<% 	}else {
 		//결과가 조회되지 않을을때 id 사용가능
%>
	 	{
		 	"key": "ok", 
		 	"msg":"사용가능"
	 	}
	 	
<%	 		
 	}
 %>   
    
    