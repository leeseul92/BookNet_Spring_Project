<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정페이지</title>
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
    .gangre {
	margin-right: 10px;
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
		
		// 비번 변경
		$('#pbtn').click(function(){
			// 데이터 무결성 검사해야됨
			
			$('#frm1').submit();
		});
		
		// 정보 수정
		$('#ebtn').click(function(){
			$('#frm2').submit();
		});
		
		$('#hbtn').click(function(){
			$(location).attr('href', '/cls/main.cls');
		});
	});
</script>
</head>
<body>
	<div class="w3-col l3 m3"><p></p></div>
	<div class="w3-col l6 m6 s12">
		<form class="w3-col" method="post" action="/cls/member/editPW.cls" name="frm" id="frm1" encType="multipart/form-data">
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
			<div class="w3-col m12 w3-padding w3-card w3-center w3-blue w3-button" id="pbtn">비밀번호 변경</div>
				<!-- 프로필사진 -->
		<form class="w3-col" method="post" action="" name="frm" id="frm2" encType="multipart/form-data">
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
				<!-- 관심분야 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="interest">관심분야(국내도서)</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input type="checkbox" id="social" name="interest" value="소설">
							<label class="gangre" for="social">소설</label>
						<input type="checkbox" id="Pessay" name="interest">
							<label class="gangre" for="Pessay">시/에세이</label>
						<input type="checkbox" id="apculture" name="interest">
							<label class="gangre" for="apculture">예술/대중문화</label>
						<input type="checkbox" id="sscience" name="interest">
							<label class="gangre" for="sscience">사회과학</label>
						<input type="checkbox" id="hculture" name="interest">
							<label class="gangre" for="hculture">역사와문화</label>
						<input type="checkbox" id="magazine" name="interest">
							<label class="gangre" for="magazine">잡지</label>
						<input type="checkbox" id="comic" name="interest">
							<label class="gangre" for="comic">만화</label>
						<input type="checkbox" id="inchild" name="interest">
							<label class="gangre" for="inchild">유아</label>
						<input type="checkbox" id="child" name="interest">
							<label class="gangre" for="child">아동</label>
						<input type="checkbox" id="famliylife" name="interest">
							<label class="gangre" for="famliylife">가정과생활</label>
						<input type="checkbox" id="youth" name="interest">
							<label class="gangre" for="youth">청소년</label>
						<input type="checkbox" id="elementary" name="interest">
							<label class="gangre" for="elementary">초등학습서</label>
						<input type="checkbox" id="High" name="interest">
							<label class="gangre" for="High">고등학습서</label>
						<input type="checkbox" id="nforgin" name="interest">
							<label class="gangre" for="nforgin">국/외국어/사전</label>
						<input type="checkbox" id="nscience" name="interest">
							<label class="gangre" for="nscience">자연과 과학</label>
						<input type="checkbox" id="emanagement" name="interest">
							<label class="gangre" for="emanagement">경제경영</label>
						<input type="checkbox" id="Sdevelopment" name="interest">
							<label class="gangre" for="Sdevelopment">자기개발</label>
						<input type="checkbox" id="humanities" name="interest">
							<label class="gangre" for="humanities">인문</label>
						<input type="checkbox" id="rmechanics" name="interest">
							<label class="gangre" for="rmechanics">종교/역학</label>
						<input type="checkbox" id="cinternet" name="interest">
							<label class="gangre" for="cinternet">컴퓨터/인터넷</label>
						<input type="checkbox" id="licence" name="interest">
							<label class="gangre" for="licence">자격서/수험서</label>
						<input type="checkbox" id="hobby" name="interest">
							<label class="gangre" for="hobby">취미/레져</label>
						<input type="checkbox" id="majar" name="interest">
							<label class="gangre" for="majar">전공/대학도서</label>
						<input type="checkbox" id="haelth" name="interest">
							<label class="gangre" for="haelth">건강/뷰티</label>
						<input type="checkbox" id="trapic" name="interest">
							<label class="gangre" for="trapic">여행</label>
						<input type="checkbox" id="middle" name="interest">
							<label class="gangre" for="middle">중등학습서</label>
					</div>
				</div>
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="interest">관심분야(해외도서)</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input type="checkbox" id="social" name="interest">
								<input type="checkbox" id="ochild" name="interest">
									<p class="gangre">어린이</p>
									<input type="checkbox" id="ELT" name="ELT" name="interest">
									<p class="gangre">ELT/사전</p>
									<input type="checkbox" id="Literature" name="interest">
									<p class="gangre">문학</p>
									<input type="checkbox" id="mpersonnel" name="interest">
									<p class="gangre">경영/인문</p>
									<input type="checkbox" id="aDesign" name="interest">
									<p class="gangre">예술/디자인</p>
									<input type="checkbox" id="practicaluse" name="interest">
									<p class="gangre">실용</p>
									<input type="checkbox" id="omagazine" name="interest">
									<p class="gangre">해외잡지</p>
									<input type="checkbox" id="universitybooks"
										name="interest">
									<p class="gangre">대학/전문서적</p>
									<input type="checkbox" id="computer" name="interest">
									<p class="gangre">컴퓨터</p>
									<input type="checkbox" id="jbooks" name="interest">
									<p class="gangre">일본도서</p>
									<input type="checkbox" id="fbooks" name="interest">
									<p class="gangre">프랑스도서</p>
									<input type="checkbox" id="cbooks" name="interest">
									<p class="gangre">중국도서</p>
									<input type="checkbox" id="ooapplication" name="interest">
									<p class="gangre">해외주문원서</p>
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
							<input type="radio" id="intershowY" name="intershow">공개
							<input type="radio" id="intershowN" name="intershow">비공개
						</span>
						</br>
						<span class="w3-col m10">생년월일
							<input type="radio" id="birthshowY" name="birthshow">공개
							<input type="radio" id="birthshowN" name="birthshow">비공개
						</span>
						</br>
						<span class="w3-col m10">성별
							<input type="radio" id="genshowY" name="genshow">공개
							<input type="radio" id="genshowN" name="genshow">비공개
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