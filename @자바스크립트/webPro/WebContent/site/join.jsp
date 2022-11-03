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

</head>
<body>

	<!-- id중복체크, 주소 api, 정규식패턴을 적용해서 validation -->

	<div class="col-sm-8">
		<h4>회원가입</h4>
		<hr>
		<form class="form-horizontal" method="post" onsubmit="return false;">
			<div class="form-group">
				<label for="id" class="control-label col-sm-2">아이디</label> <span
					class="sp"></span>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="id"
						placeholder="Enter id" name="mem_id">
				</div>
				<div class="col-sm-6" style="text-align: left;">
					<button type="button" class="btn btn-success btn-sm" id="idChk">중복검사</button>
					<span id="disp"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="pass" class="control-label col-sm-2">비밀번호</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pass"
						name="mem_pass">
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="control-label col-sm-2">이름</label> <span
					class="sp"></span>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name" name="mem_name">
				</div>
			</div>

			<div class="form-group">
				<label for="bir" class="control-label col-sm-2">생년월일</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="bir" name="mem_bir">
					<span class="sp"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="hp" class="control-label col-sm-2">연락처</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="hp" name="mem_hp"
						placeholder="010-0000-0000">
				</div>
				<span class="sp"></span>
			</div>

			<div class="form-group">
				<label for="mail" class="control-label col-sm-2">이메일</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" id="mail" name="mem_mail">
				</div>
				<span class="sp"></span>
			</div>

			<div class="form-group">
				<label for="add1" class="control-label col-sm-2">우편번호</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="postAddr"
						name="mem_add1">
				</div>
				<div class="col-sm-2">
					<button type="button" id="addrBtn" class="btn btn-info btn-sm">주소검색</button>
				</div>
			</div>

			<div class="form-group">
				<label for="add1" class="control-label col-sm-2">주소</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="addr1" name="mem_add1">
				</div>
			</div>

			<div class="form-group">
				<label for="add2" class="control-label col-sm-2">상세주소</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="addr2" name="mem_add2">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button class="btn btn-default">가입하기</button>
					<span id="joinspan"></span>
				</div>
			</div>
		</form>
	</div>



	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	//$('#idChk').on('click', function() {}
	$('#id').on('keyup', function() {
		
		var v_id = $('#id').val();
		var v_disp = $('#disp');
		
		v_disp.text("");
		//console.log(v_id.trim().length); //앞뒤공백 제거 
		if(!v_id.trim().length) return; //공백이 있으면 아래 내용을 실행하지 않겠다
		
		$.ajax({
			type:'post',
			url: '<%= request.getContextPath()%>/site/idCheck.jsp',
			data: {userId : v_id.trim()} ,
			dataType: 'json',
			success: function(rst) {
				//console.log(rst);
				if(rst.code == "ok"){
					v_disp.text(rst.msg).css('color','green');
				}else {
					v_disp.text(rst.msg).css('color','red');
				}
			},
			error: function(xhr) {
				alert(xhr.status);
			}
		});
		
		
	});
	
	
	
	
	$('#addrBtn').on('click', function() {
		new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postAddr").value = data.zonecode;
                document.getElementById("addr1").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
	});
	
	
	</script>



</body>
</html>