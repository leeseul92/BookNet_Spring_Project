// 체크박스 3개 넘게 체크하면 막는 이벤트함수

var maxChecked = 3;   // 체크 최대 개수
var totalChecked = 0; // 총 체크 수

function CountChecked(check) {
    if (check.checked)
        totalChecked += 1; // totalChecked 증가
    else
        totalChecked -= 1; // totalChecked 감소

    if (totalChecked > maxChecked) {
        alert ("관심분야 지정은 통합 최대 3개 까지만 가능합니다.");
    check.checked = false;
    totalChecked -= 1;
    }
    
}

$(function(){
		var count = '';
		//데이터 입력 여부 확인 후 데이터 넘기기
	$('#submit').click(function(){
		var id = $('#id').val();
		var pw = $('#password').val();
		var repw = $('#confirm-password').val();
		var name = $('#name').val();
		var mail = $('#email').val();
		var mailck = /^[A-Za-z0-9]+@[A-Za-z]+\.[A-Za-z]+/;
		var gen = $('#gen').val();
		var birth = $('#birthday').val();
		var check = $('#emailck').click();
		var mck = $('#mcheck').click();
		
		var noid = $('#idmsg').text('### 사용할 수 없는 아이디 입니다. ###');
		
		if(id == ''){
			alert('아이디를 입력해주세요');
			if(noid == id){
				alert('이미 가입되어 있는 아이디입니다.');
			}
		}else if( pw == ''){
			alert('비밀번호를 입력하세요');
		}else if(repw != pw){
			alert('입력한 비밀번호가 다릅니다');
		}else if(name == ''){
			alert('이름을 입력하세요');
		}else if(mail == ''){
			alert('이메일을 입력해주세요');
		}else if(!mck){
			alert('이메일 중복 버튼을 클릭해 중복여부를 확인해 주세요');		
		}else if(!mailck.test(mail)){
			alert('올바른 형태의 이메일이 아닙니다');
		}else if(!check){
			alert('이메일 인증을 진행해 주세요');
		}else if(gen == '선택하세요'){
			alert('성별을 선택하세요');
		}else if(birth == ''){
			alert('생일을 입력해 주세요');	
		}else{
			$('#frm').submit();			
		}
	});
		//아이디 중복 여부
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
	
	//이름 10자까지 제한
	$('#name').keyup(function(){
		var name = $(this).val();
		if(name.length > 11){
			alert('최대 10자까지 입력 가능합니다.')
			$(this).val(name.substring(0,10));
		}
	});
		
	//이메일 인증 처리
	$('#mailck').click(function(){
		$('#efrm').attr('action','/cls/member/mail.cls');
		var mail = $('#email').val();
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
		if(mailck == '' && count== ''){
			alert('인증이 되지 않았습니다.');
		}
		if(mailck == count && mailck != ''){
			if(count != ''){
			alert('인증이 완료되었습니다.');				
			}
		}else if(mailck != count){
			alert('인증 번호가 맞지 않습니다. 다시 입력해주세요');
			$('#email-ck').val('');
		}
	});

	/*// 체크박스 3개 넘게 체크하면 막는 이벤트함수	
	document.getElementsByName("interest").onclick = function(check){
		if(check.checked){
			totalChecked += 1;
		}else{
			totalChecked -= 1;
		}
		
		if(totalChecked > maxChecked){
			alert('관심분야는 3개까지 지정 가능합니다.');
			check.checked = false;
			totalChecked  -= 1;
		}
	}
	*/
	
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
