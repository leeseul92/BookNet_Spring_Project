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
	.form-control {
	display: block;
	width: 100%;
	height: calc(1.5em + .75rem + 2px);
	padding: .375rem .75rem;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: .25rem;
	transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out
	}
</style>
<script type="text/javascript">

// 체크박스 3개 넘게 체크하면 막는 이벤트함수
var maxChecked = 3;   // 체크 최대 개수
var interstr = '${LIST.get(0).interest}';
var totalChecked = 0; // 총 체크 수
if(interstr == ''){
	totalChecked = 0;
} else if(interstr.match(/,/gi) == null) {
	totalChecked = 1;
} else if(interstr.match(/,/gi).length == 1) {
	totalChecked = 2;
} else if(interstr.match(/,/gi).length == 2) {
	totalChecked = 3;
}

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
		// 정보공개설정 상태 반영
		var interS = '${LIST.get(0).intershow}';
		var birthS = '${LIST.get(0).birthshow}';
		var genS = '${LIST.get(0).genshow}';
// 		alert(interS + birthS + genS);
		
		if(interS == 'Y') {
			$('#intershowY').attr('checked', 'checked');
		} else {
			$('#intershowN').attr('checked', 'checked');
		}
		if(birthS == 'Y') {
			$('#birthshowY').attr('checked', 'checked');
		} else {
			$('#birthshowN').attr('checked', 'checked');
		}
		if(genS == 'Y') {
			$('#genshowY').attr('checked', 'checked');
		} else {
			$('#genshowN').attr('checked', 'checked');
		}
		
		// 관심분야 상태 반영
		var inter = '${LIST.get(0).interest}';
		var comma = 0;
		if(inter.indexOf(',') != -1){
			comma = inter.match(/,/gi).length;
		};
		
		var tmp = inter;
		let i = 0;
		do{
			i += 1;
// 			alert(tmp);
			if(tmp.indexOf(',') == -1){
				$('input[value=\"' + tmp + '\"]').attr('checked', 'checked');
			}
			var inter1 = tmp.substr(0, tmp.indexOf(','));
// 			alert('inter1 = '+inter1);
			$('input[value=\"' + inter1 + '\"]').attr('checked', 'checked');
			tmp = tmp.substr(inter1.length + 1);
// 			alert('자른tmp = '+tmp);
		} while (i<=comma);
		
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
			var oldpw = $('#oldpw').val();
			var newpw = $('#newpw').val();
			var pwck = $('#pwck').val();
			if(!oldpw){
				alert('현재 비밀번호를 입력해주세요');
				$('#oldpw').focus();
				return;
			}
			if(!newpw){
				alert('새 비밀번호를 입력해주세요');
				$('#newpw').focus();
				return;
			}
			if(!pwck){
				alert('비밀번호 확인이 필요합니다');
				$('#pwck').focus();
				return;
			}
			if(oldpw && newpw && pwck){
				$('#frm1').submit();
			}
		});
		
		// 정보 수정
		$('#ebtn').click(function(){
			$('#frm2').submit();
		});
		
		// 마이페이지로
		$('#hbtn').click(function(){
			$(location).attr('href', '/cls/mypage/mypage.cls');
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
	<div>
		<div id="contents-wrap">
			<div style="width: 900px; margin: 0 auto;">
				<!-- <div class="w3-col l6 m6 s12"> -->
					<!-- 비번수정 -->
					<form class="w3-col" method="post" action="/cls/member/editPW.cls" name="frm1" id="frm1">
						<div class="w3-col w3-padding w3-black w3-card">
							<h3 class="w3-center">정보수정</h3>
						</div>
						<div class="w3-col w3-padding w3-card" style="margin-top: 10px;">
							<div class="w3-row w3-border-top">
								<label class="w3-col m3 w3-right-align w3-padding" for="oldpw">현재 비밀번호</label>
								<div class="w3-col m9 w3-padding w3-border-left">
									<input  class="w3-col m12 " type="password" id="oldpw" name="oldpw" >
								</div>
							</div>
							<div class="w3-row w3-border-top">
								<label class="w3-col m3 w3-right-align w3-padding" for="newpw">새 비밀번호</label>
								<div class="w3-col m9 w3-padding w3-border-left">
									<input class="w3-col m12" type="password" id="newpw" name="pw">
								</div>
							</div>
							<div class="w3-row w3-border-top w3-border-bottom">
								<label class="w3-col m3 w3-right-align w3-padding" for="pwck">비밀번호 확인</label>
								<div class="w3-col m9 w3-padding w3-border-left">
									<input class="w3-col m12" type="password" id="pwck" name="pwck">
									<div class="w3-col m12" id="pwckshow"></div>
								</div>
							</div>
						</div>
					</form>
					<!-- //비번수정 -->
						<div class="w3-col m12 w3-padding w3-card w3-center w3-blue w3-button" id="pbtn">비밀번호 변경</div>
					<!-- 정보수정 -->
					<form class="w3-col" method="post" action="/cls/member/editUser.cls" name="frm2" id="frm2" encType="multipart/form-data">
						<div class="w3-col w3-padding  w3-card" style="margin-top: 10px;">
							<!-- 프사 수정 -->
							<div class="w3-row w3-border-top">
								<label class="w3-col m3 w3-right-align w3-padding" for="file">프로필 사진</label>
								<div class="w3-col m9 w3-padding w3-border-left">
									<input class="w3-col m12" type="file" id="file" name="file"/>
								</div>
								<div class="w3-row w3-center " >
									<img id="img" style="width: 100px; height: auto;" src="" />
								</div>
							</div>
							<!-- //프사 수정 -->
							<!-- 관심분야 -->
								<div class="w3-row w3-border-top">
									<label class="w3-col m3 w3-right-align w3-padding" for="interest">관심분야(국내)</label>
									<div class="w3-col m9 w3-padding w3-border-left">
										<!-- 
										<select class="form-control" id="firstG">
											<option>선택하세요</option>
											<c:forEach var="data" items="${GENRE }" varStatus="st">
											<option>${data.gname }</option>
											</c:forEach>
										</select>
										<select class="form-control" id="secondG">
											<option>선택하세요</option>
											<c:forEach var="data" items="${GENRE }" varStatus="st">
											<option>${data.gname }</option>
											</c:forEach>
										</select>
										<select class="form-control" id="thirdG">
											<option>선택하세요</option>
											<c:forEach var="data" items="${GENRE }" varStatus="st">
											<option>${data.gname }</option>
											</c:forEach>
										</select>
										 -->
										<c:forEach var="data" items="${GENRE }" varStatus="st">
										<c:if test="${data.genre < 200 }">
											<div style="display: inline-block;">
											<input onclick="CountChecked(this)" type="checkbox" id="${data.genre }" name="interest" value="${data.gname }" faking-checkbox>
											<label class="gangre" for="${data.genre }">${data.gname }</label>
											</div>
										</c:if>
										</c:forEach>
									</div>
								</div>
								<div class="w3-row w3-border-top">
									<label class="w3-col m3 w3-right-align w3-padding" for="interest">관심분야(해외)</label>
									<div class="w3-col m9 w3-padding w3-border-left">
										<c:forEach var="data" items="${GENRE }" varStatus="st">
										<c:if test="${data.genre > 200 }">
											<div style="display: inline-block;">
											<input onclick="CountChecked(this)" type="checkbox" id="${data.genre }" name="interest" value="${data.gname }" faking-checkbox>
											<label class="gangre" for="${data.genre }">${data.gname }</label>
											</div>
										</c:if>
										</c:forEach>
									</div>
								</div>
							<!-- //관심분야 -->
							<!-- 간단소개 -->
							<div class="w3-row w3-border-top">
								<label class="w3-col m3 w3-right-align w3-padding" for="describe">간단소개</label>
								<div class="w3-col m9 w3-padding w3-border-left">
									<input class="w3-col m12" type="text" id="describe" name="describe" value="${LIST.get(0).describe }">
								</div>
							</div>
							<!-- //간단소개 -->
							<!-- 정보공개설정 -->
							<div class="w3-row w3-border-top">
								<label class="w3-col m3 w3-right-align w3-padding" for="gen">정보공개설정</label>
								<div class="w3-col m9 w3-padding w3-border-left">
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
							<!-- //정보공개설정 -->
						</div>
					</form>
					<!-- //정보수정-->
						<div class="w3-col m12 w3-padding w3-card w3-center w3-blue w3-button" id="ebtn">정보수정</div>
							<!-- 회원탈퇴 -->
						<div class="w3-col w3-padding  w3-card" style="margin-top: 10px;">
							<div class="w3-row">
								<label class="w3-col m3 w3-right-align w3-padding w3-border-right w3-border-top w3-border-bottom" style="height: 44px;" for="name">회원탈퇴</label>
								<div class="w3-col m9 w3-padding w3-border-top w3-border-bottom">
									<button style="display: inline-block; border: 2px solid gray;" id="delete">회원탈퇴하시겠습니까?</button>
								</div>
							</div>
						</div>
					<!-- 홈버튼 -->
					<div class="w3-col m12 w3-padding w3-card w3-center w3-red w3-button" id="hbtn">마이페이지로</div>
				<!-- </div> -->
			</div>
		</div>
		<!-- 고정페이지부분 -->
		<jsp:include page="/WEB-INF/views/fixed.jsp" />
	</div>
</body>
</html>