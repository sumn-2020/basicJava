<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- % 안에는 자바소스를 넣을수 있음 -->
<%
	List<MemberVO> memList = (List<MemberVO>) request.getAttribute("memList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>

		<%
		int memSize = memList.size();
		if (memSize > 0) {
			for (int i = 0; i < memSize; i++) {
		%>
		<!--  tr태그가 memSize만큼 만들어짐  -->
		<tr>
			<%-- <td><% out.print(memList.get(i).getMemId()); %></td> --%>
			<td><%=memList.get(i).getMemId()%></td>
			<td><a href="detail.do?memId=<%=memList.get(i).getMemId()%>"><%=memList.get(i).getMemName()%></a></td>
			<td><%=memList.get(i).getMemTel()%></td>
			<td><%=memList.get(i).getMemAddr()%></td>
			<td></td>
			<td></td>
		</tr>
		<%
			}
		} else {
		%>
		<tr>
			<td colspan="4">조회된 데이터가 없습니다.</td>
		</tr>
		<%
			}
		%>

		<tr align="center">
			<td colspan="4"><a href="insert.do">[회원 등록]</a></td>
		</tr>

	</table>
	

</body>
</html>