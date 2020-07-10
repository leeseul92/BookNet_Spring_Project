<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0079)https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com# -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>로그인페이지</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w_20200211.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
</head>
<script>
	$(document).ready(function(){
		$('.btn_global').click(function(){
			//데이터 읽기 
			var sid = $('#id').val();
			var spw = $('#pw').val();
			
			if(!sid){
				$('#id').focus();
				return;
			}
			if(!spw){
				$('#pw').focus();
				return;
			}
			
			$('#frm').attr('method', 'POST');
			$('#frm').attr('action', '/cls/member/loginProc.cls');
			$('#frm').submit();
		});
	});
</script>
<body style="height: 100%; background-position: inherit; background-image: url('/cls/img/login_image.jpeg')">
	<div class="totaldiv" style="margin-top: 100px;" >

		<!-- header -->
		<div id="header">
			<h1 style="text-align: center">
				<a href="/cls/main/non.cls" class="logo_font"><b>PageTurner</b></a>
			</h1>
		</div>
		<!-- //header -->
		<!-- container -->
		<div id="container">
			<!-- content -->
			<div id="content">
				<form id="frm">
					<fieldset class="login_form">
						<legend class="blind">로그인</legend>
						<div class="id_area">
							<div class="input_row" id="id_area">
								<span class="input_box"> 
									<label for="id" id="label_id_area" class="lbl" style="display: block;">아이디</label>
									<input type="text" id="id" name="id" placeholder="아이디" class="int" maxlength="41" value="">
								</span>
							</div>
						</div>
						<div class="pw_area">
							<div class="input_row" id="pw_area">
								<span class="input_box"> 
									<label for="pw" id="label_pw_area" class="lbl">비밀번호</label> 
									<input type="password" id="pw" name="pw" placeholder="비밀번호" class="int" maxlength="16">
								</span> 
							</div>
						</div>
					</fieldset>
						<input type="submit" title="로그인" alt="로그인" value="로그인" class="btn_global" id="log.login">
				</form>

				<!-- 아이디, 비번, 회원가입-->
				<div class="find_info">
					<a target="_blank" id="idinquiry" href="/cls/member/findID.cls">계정을 잊어버리셨나요?</a> 
					<span class="bar" aria-hidden="true">|</span> 
					<a target="_blank" id="join" href="/cls/member/join.cls">회원가입</a>
				</div>
			</div>
			<!-- //content -->
		</div>
		<!-- //container -->
	</div>
</body>
</html>