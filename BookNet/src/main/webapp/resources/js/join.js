$(function(){
		var count = '';
	$('#idck').click(function(){
		var sid = $('#id').val();
		if(sid){
			$.ajax({
				url: '/cls/member/idck.cls',
				type: 'post',
				dataType: 'json',
				data: {
					'id': sid
				},
				success: function(data){
					var result = data["cnt"];
					if(result == 0){
						// 아이디를 사용가능한 경우
						$('#idmsg').text('*** 사용 가능한 아이디 입니다. ***');
						$('#idmsg').css('color', 'blue');
						$('#idmsg').css('display', '');
						
					} else {
						// 아이디가 사용불가능한 경우
						$('#idmsg').text('### 사용할 수 없는 아이디 입니다. ###');
						$('#idmsg').css('color', 'red');
						$('#idmsg').css('display', '');
						$('#id').val('');
						$('#id').focus();
					}
				},
				error: function(){
					alert('### 통신 실패 ###');
				}
			});
		} else {
			$('#id').focus();
			return;
		}
	});
	
	$('#submit').click(function(){
		// 데이터 무결성 검사하고
		
		$('#frm').submit();
	});
	
	
	//비밀번호 확인
	$('#confirm-password').keyup(function(){
		// 먼저 데이터 읽고
		var spw = $('#password').val();
		if(!spw){
			$('#password').focus();
		}
		var srepw = $('#confirm-password').val();
		// 데이터 비교하고
		if(spw != srepw){
			$('#repw').html('# 비밀번호가 다릅니다. #');
			$('#repw').css('color', 'red');
			$('#repw').removeClass('dnone');
		}
		if(spw == srepw){
			$('#repw').html('#사용가능한 비밀번호 입니다.');
			$('#repw').css('color','blue');
			
		}
		
	});
	
	//이메일 인증 처리
	$('#mailck').click(function(){
		$('#efrm').attr('action','/cls/member/mail.cls');
		var mail = $('#email-address').val();
		if(mail == ''){
			alert('이메일을 입력해주세요');
			return
		}
		
			$.ajax({
				url: '/cls/member/mail.cls',
				type: 'post',
				dataType: 'json',
				data: {
					'mail' : mail
				},
				success: function(obj){
					alert('인증번호가 발송되었습니다.');
					count = obj.tno;
					
				},
				error: function(){
					alert('통신에러');
				}
			});
	});
	
	//인증번호 확인
	$('#emailck').click(function(){
		var mailck = $('#email-ck').val();
		if(mailck == ''){
			alert('인증 번호를 입력하세요');
		}
		if(mailck == count){
			alert('인증이 완료되었습니다.');
		}else if(mailck != count){
			alert('인증 번호가 맞지 않습니다. 다시 입력해주세요');
			$('#email-ck').text('');
		}
	});
	
	//자기소개 100자 제한 
	$('#introduce').keyup(function(){
		var text = $(this).val();
		$('#count').html("("+text.length+"자" + " / 최대 100자)");
		if(text.length > 100){
			alert('최대 100자까지 입력 가능합니다 다시 입력하세요');
			$(this).val(text.substring(0,100));
		}
	});
});

