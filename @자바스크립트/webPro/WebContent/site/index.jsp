<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>




	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="../../site/header.jsp"%>
	<%@ include file="../../site/aside1.jsp"%>



	<c:set var="joinCd" value="${sessionScope.joinCode}"></c:set>
	////<c:out value="${joinCd}"></c:out>////
	
	<c:if test="${joinCd eq 'yes'}"> <%-- joinCd에 yes라는 코드가 있다면 --%>
		 <%@ include file="./join.jsp"%> 
		 <% session.removeAttribute("joinCode"); %>
	</c:if>
	
	<c:if test="${joinCd ne 'yes'}"> <%-- joinCd에 yes라는 코드가 없다면 --%>
		<div class="col-sm-8 text-left">
			<h1>Welcome</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
				eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			</p>
			<hr>
			<h3>Test</h3>
			<p>Lorem ipsum...</p>
		</div> 
	</c:if>


		

		


	<%@ include file="../../site/aside2.jsp"%>
	<%@ include file="../../site/footer.jsp"%>

</body>
</html>

