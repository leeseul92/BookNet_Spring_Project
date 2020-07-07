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
		
		// 회원탈퇴
		$('#delete').click(function(){
			var result = confirm('회원탈퇴하시겠습니까?');
			if(result){
				$(location).attr('href', '/cls/member/delUser.cls');
			}
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
		<form class="w3-col" method="post" action="/cls/member/editUser.cls" name="frm" id="frm2" encType="multipart/form-data">
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
						<c:forEach var="data" items="${GENRE }" varStatus="st">
						<c:if test="${data.genre < 200 }">
							<span>
							<input onclick="CountChecked(this)" type="checkbox" id="${data.genre }" name="interest" value="${data.gname }" faking-checkbox>
							<label class="gangre" for="${data.genre }">${data.gname }</label>
							</span>
						</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="interest">관심분야(해외도서)</label>
					<div class="w3-col m9 w3-padding w3-border">
						<c:forEach var="data" items="${GENRE }" varStatus="st">
						<c:if test="${data.genre > 200 }">
							<input onclick="CountChecked(this)" type="checkbox" id="${data.genre }" name="interest" value="${data.gname }" faking-checkbox>
							<label class="gangre" for="${data.genre }">${data.gname }</label>
						</c:if>
						</c:forEach>
					</div>
				</div>
				<!-- 간단소개 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="describe">간단소개</label>
					<div class="w3-col m9 w3-padding w3-border">
						<input class="w3-col m12" type="text" id="describe" name="describe" value="${LIST.get(0).describe }">
					</div>
				</div>
				<!-- 정보공개설정 -->
				<div class="w3-row">
					<label class="w3-col m3 w3-right-align w3-padding w3-border" for="gen">정보공개설정</label>
					<div class="w3-col m9 w3-padding w3-border">
						<span class="w3-col m10">관심분야
							<input type="radio" id="intershowY" name="intershow" value="Y"><label for="intershowY">공개</label>
							<input type="radio" id="intershowN" name="intershow" value="N"><label for="intershowN">비공개</label>
						</span>
						</br>
						<span class="w3-col m10">생년월일
							<input type="radio" id="birthshowY" name="birthshow" value="Y"><label for="birthshowY">공개</label>
							<input type="radio" id="birthshowN" name="birthshow" value="N"><label for="birthshowN">비공개</label>
						</span>
						</br>
						<span class="w3-col m10">성별
							<input type="radio" id="genshowY" name="genshow" value="Y"><label for="genshowY">공개</label>
							<input type="radio" id="genshowN" name="genshow" value="N"><label for="genshowN">비공개</label>
						</span>
						</br>
					</div>
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