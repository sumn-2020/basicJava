<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
.container-fluid {
	width: 40%;
	margin: 30% auto;
}

.row {
	border: 4px solid lightgray;
	padding: 10px;
}
</style>


</head>
<body>



	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<input id="userId" class="form-control">
			</div>
			<div class="col-xs-12">
				<input id="userPw" type="password" class="form-control">
			</div>
			<div class="col-xs-12">
				<input id="loginBtn" type="button" value="로그인"
					class="btn btn-primary  col-xs-12">
			</div>
			<div class="col-xs-12">
				<a href="/Join">회원가입하기</a>
			</div>
		</div>
	</div>

	<script>
	
		// id=loginBtn인 버튼에 클릭이벤트를 부여
		// 이벤트 실행시 ajax통신으로 loadTest.jsp의 결과를 받아 콘솔에 찍기
		// loadTest.jsp 경로 => 1027폴더 참고

		var v_btn = document.querySelector('#loginBtn');
		
		
		v_btn.addEventListener('click', function() {
			
			var v_uId = document.querySelector('#userId').value;
			var v_uPw = document.querySelector('#userPw').value; // 1027폴더에 있는 loadTest.jsp에 있는 String usrId = request.getParameter("usrId"); 이거랑 동일해야됨 
			
			//jsp에서 백틱을 사용해서 변수 처리시 적용안됨 주의 => jsp에서는 백틱 사용안됨 
			var data = "usrId=" + v_uId + "&usrPw=" + v_uPw;
			
			
			
			var req = new XMLHttpRequest();
			req.open('post','../1027/loadTest.jsp', true);
			req.onreadystatechange = function() {
				if(req.readyState == 4 && req.status == 200) {
					//console.log(req.responseText);
					var jsObj = JSON.parse(req.responseText);
					if(jsObj.rst == "ok") {
						//성공시 페이지 이동
						location.replace("/index.do");
//						location.href = "위치경로지정"
						
					}else {
						//실패시 현재페이지 머무르기 
						location.reload();
						
						
						
					}
				}
			}
			req.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
			req.send(data);
		});

	</script>

</body>
</html>