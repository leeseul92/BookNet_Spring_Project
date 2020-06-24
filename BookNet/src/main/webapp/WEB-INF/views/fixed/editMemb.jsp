<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
<link rel="stylesheet" href="/cls/css/w3.css" />
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<style>
	.imgsize {
		width: 90px;
		height: auto;
	}
	.rel {
		position: relative;
    	right: -21px;
    }
    .rel2 {
		position: relative;
    	top: 12px;
    }
</style>
<script type="text/javascript">
	$(function(){
		// 비번일치
		$('#pwck').keyup(function(){
			var pw = $('#newpw').val();
			var pwck = $('#pwck').val();
			if(pw == pwck){
				$('#pwckshow').html('일치');
				$('#pwckshow').css('color', 'blue');
			} else{
				$('#pwckshow').html('다름');			
				$('#pwckshow').css('color', 'red');
			}
		});
		
		// 프사 미리보기
		$('#file').change(function(e){
			var img = URL.createObjectURL(e.target.files[0]);
//			document.getElementById('img').setAttribute('src', img);
			$('#img').attr('src', img);
		});
		
		// 수정/홈 얼럿
		$('#ebtn').click(function(){
			// 데이터 무결성 검사해야됨
			
			$('#frm').submit();
		});
		$('#hbtn').click(function(){
//			alert('홈으로돌아감 홈링크안만듦');
			$(location).attr('href', '/cls/main.cls');
		});
	});
</script>
</head>
<body>
	<div class="w3-col l3 m3"><p></p></div>
	<div class="w3-col l6 m6 s12">
		<form class="w3-col" method="post" action="" name="frm" id="frm" encType="multipart/form-data">
			<div class="w3-col w3-padding w3-black w3-card">
				<h3 class="w3-center">정보수정</h3>
			</div>
				<!-- 비번수정 -->
			<div class="w3-col w3-padding w3-border w3-card" style="margin-top: 10px;">
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="pw">현재 비밀번호</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input  class="w3-col m12 " type="text" id="pw" name="pw" >
					</div>
				</div>
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="newpw">새 비밀번호</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12 " type="password" id="newpw" name="newpw">
					</div>
				</div>
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="pwck">비밀번호 확인</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12" type="password" id="pwck" name="pwck">
						<div class="w3-col m12" id="pwckshow"></div>
					</div>
				</div>
			</div>
			</form>
		<form class="w3-col" method="post" action="" name="frm" id="frm" encType="multipart/form-data">
			<div class="w3-col m12 w3-padding w3-card w3-center w3-blue w3-button" id="ebtn">비밀번호 변경</div>
				<!-- 프로필사진 -->
			<div class="w3-col w3-padding w3-border w3-card" style="margin-top: 10px;">
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="file">프로필 사진</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12" type="file" id="file" name="file"/>
					</div>
					<div class="w3-row w3-center w3-border" >
						<img id="img" style="width: 100px; height: auto;" src="" />
					</div>
				</div>
				<!-- 닉네임 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="nickname">닉네임</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12" type="text" id="nickame" name="nickname">
					</div>
				</div>
				<!-- 관심분야 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="interest">관심분야</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12" type="text" id="interest" name="interest">
					</div>
				</div>
				<!-- 간단소개 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="describe">간단소개</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12" type="text" id="describe" name="describe">
					</div>
				</div>
				<!-- 정보공개설정 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="gen">정보공개설정</label>
					<div class="w3-col m9 w3-padding w3-border">
						<span class="w3-col m10">관심분야
							<input type="radio" id="Y" name="gen">공개
							<input type="radio" id="N" name="gen">비공개
						</span>
						</br>
						<span class="w3-col m10">생년월일
							<input type="radio" id="Y" name="gen">공개
							<input type="radio" id="N" name="gen">비공개
						</span>
						</br>
						<span class="w3-col m10">성별
							<input type="radio" id="Y" name="gen">공개
							<input type="radio" id="N" name="gen">비공개
						</span>
						</br>
					</div>
				</div>
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-hide" for="avt">아바타 :</label>
					<!-- <div class="w3-col m9 w3-padding">
						<div class="w3-row" id="avt">
							<div class="w3-col">
								<input type="radio" id="avt" name="avt" />
							</div>
						</div>
					</div> -->
				</div>
			</div>
		</form>
			<div class="w3-col m12 w3-padding w3-card w3-center w3-blue w3-button" id="ebtn">정보수정</div>
				<!-- 회원탈퇴 -->
			<div class="w3-col w3-padding w3-border w3-card" style="margin-top: 10px;">
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="name">회원탈퇴</label>
					<div class="w3-col m9 w3-padding w3-border">
						<button style="display: inline-block; border: 2px solid gray;" id="delete">회원탈퇴하시겠습니까?</button>
					</div>
				</div>
			</div>
		<!-- 홈버튼 -->
		<div class="w3-col m12 w3-padding w3-card w3-center w3-red w3-button" id="hbtn">홈으로</div>
	</div>
</body>
</html>