<!--
아디비번찾기 뷰
작성자: 이명환
작성일: 20.06.25
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<link rel="stylesheet" href="../css/w3.css"/>
<script type="text/javascript" src="../js/jquery-3.5.0.min.js"></script>
<style>

</style>
<script type="text/javascript">
	$(function(){
		var cert = '';
		
		$('#btn1').click(function(){
			$('#f_write').css('display', '');
			$('.idid').css('display', 'none');
			$('#id').val('');
		});
		
		$('#btn2').click(function(){
			$('#f_write').css('display', '');
			$('.idid').css('display', '');
		});
		
		
		$('#mailUtil').click(function(){
			$('#frm').attr('action', '/cls/member/mail.cls');
			var mail = $('#mail').val();
			if(mail == ''){
				alert('이메일을 입력해주세요');
				return
			}
			
			$.ajax({
				url: '/cls/member/mail.cls',
				type: 'post',
				dataType: 'json',
				data:{
					'mail': mail
				},
				success: function(obj){
					alert('인증번호가 발송되었습니다. 이메일을 확인해주세요.');
					cert = obj.tno;
					alert(cert);
				},
				error: function(){
					alert('통신에러');
				}
			});
			
		});
		
		$('#confirm').click(function(){
			var id = $('#id').val();
			var name = $('#name').val();
			var mail = $('#mail').val();
			var cert_no = $('#cert_no').val();
			
			if(id == '') {
				if(name == '') {
					alert('이름을 입력하세요');
					return;
				}
				if(mail == '') {
					alert('이메일을 입력하세요');
					return;
				}
				if(cert_no == '') {
// 					alert(cert_no);
// 					alert(cert);
					alert('인증번호를 입력하세요');
					return;
				}
				if(cert == cert_no) {
// 					alert(cert);
// 					alert(cert_no);
// 					alert('*****************');
				}else {
// 					alert(cert);
// 					alert(cert_no);
// 					alert("#mail val : " + cert.length);
// 					alert("#input val : " + cert_no.length);
// 					alert('인증번호가 일치하지 않습니다');
					return;
				}
				$.ajax({
					url: '/cls/member/findIDProc.cls',
					type: 'post',
					dataType: 'json',
					data:{
						'mail': mail
					},
					success: function(obj){
						alert('회원님의 ID는 ' + obj.id + ' 입니다');
						$(location).attr('href', '/cls/member/findID.cls');
					},
					error: function(){
						alert('통신에러');
					}
				});
// 				$('#frm').attr('action','/cls/member/findIDProc.cls');
			} else {
				if(name == '') {
					alert('이름을 입력하세요');
					return;
				}
				if(mail == '') {
					alert('이메일을 입력하세요');
					return;
				}
				if(cert_no == '') {
					alert('인증번호를 입력하세요');
					return;
				}
				
				if(cert != cert_no) {
					alert('인증번호가 일치하지 않습니다');
					return;
				}
				$.ajax({
					url: '/cls/member/findPWProc.cls',
					type: 'post',
					dataType: 'json',
					data:{
						'id': id,
						'mail': mail
					},
					success: function(obj){
						alert('회원님의 PW는 ' + obj.pw + ' 입니다');
						$(location).attr('href', '/cls/member/findID.cls');
					},
					error: function(){
						alert('통신에러');
					}
				});
// 				$('#frm').attr('action','/cls/member/findPWProc.cls');
			}
			
			$('#frm').submit();
		});
	});
</script>
</head>
<body>
				<div class="logobox">
					<div style="box-sizing: border-box; font-size: 30px; text-align: center;">
						<!-- 로고 이미지 혹은 링크 들어갈 자리 class="div_logo" -->
						<a href="/cls/main/non.cls" style="color: #120E0A;"><b>PageTurner</b></a>
					</div>
				</div>

	<form id="frm" method="post" action="">
		
		<div class="w3-content" style="max-width: 600px; margin-top: 100px;" id="loginWin">
			<div class="w3-col w3-red w3-button w3-padding w3-center w3-margin-top" id="btn1">아이디찾기</div>
			<div class="w3-col w3-blue w3-button w3-padding w3-center w3-margin-top" id="btn2">비밀번호찾기</div>
			<div class="w3-col w3-padding w3-card-4 w3-round-large w3-border w3-margin-top" id="f_write" style="display: none;">
				<label for="id" class="idid w3-col m2 w3-right-align w3-padding-16">아이디 : </label>
				<div class="idid w3-col m10 w3-padding">
					<input type="text" class="w3-col w3-input w3-border" id="id" name="id">
				</div>
				<label for="name" class="w3-col m2 w3-right-align w3-padding-16">이름 : </label>
				<div class="w3-col m10 w3-padding">
					<input type="text" class="w3-col w3-input w3-border" id="name" name="name">
				</div>
				<label for="mail" class="w3-col m2	 w3-right-align w3-padding-16">이메일 : </label>
				<div class="w3-col m10 w3-padding">
					<input type="text" class="w3-col m8 w3-input w3-border" id="mail" name="mail">
					<span class="w3-col m3 w3-card w3-button" style="height: 40px; margin-left: 32px;" id="mailUtil">인증번호받기</span>
				</div>
				<label for="cert_no" class="w3-col m2 w3-right-align w3-padding-16">인증번호 : </label>
				<div class="w3-col m10 w3-padding">
					<input type="text" class="w3-col w3-input w3-border" id="cert_no" name="cert_no">
				</div>
				<div class="w3-col w3-margin-top">
					<div class="w3-padding w3-blue w3-center w3-card-4 w3-round-large w3-button" id="confirm">확인</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>