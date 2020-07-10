<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="Daniel Shin">



<meta name="google-site-verification"
	content="k87bBuLe-2-Mg1r1Wzq7HE4hmxj25wfonCkWB1s70kM">
<meta name="naver-site-verification"
	content="f107dd8d22fc998a8c4f485860851c793158154f">

<title>PageTurner회원가입</title>

<meta name="msapplication-TileColor" content="#2b5797">
<meta name="theme-color" content="#ffffff">



<link rel="stylesheet" href="/cls/css/bootstrap.min.css">
<link href="/cls/css/c845a517197b04b7f694e3e7bdf31371-register.css"
	rel="stylesheet">
<link rel="stylesheet" href="/cls/css/w3.css">
<link rel="stylesheet" href="/cls/css/whw_join.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/cls/js/join.js"></script>



<!--[if lt IE 9]>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<section id="accounts-header">
		<div class="container-fluid">

			<!-- 좌측상단 로고 -->
			<div class="row sft-header-register d-flex">
				<div class="col-3 pl-0">
					<h3 class="turnerlogo"><a href="/cls/main/non.cls" style="font-size: 40px; color: white;  font-weight: bold; background-color: rgba( 0, 0, 0, 0.5 );">PageTurner</a></h3>
				</div>
				<div class="col-9 pr-0">
					<div class="pt-1 text-right">
						<span class="d-none d-sm-inline">이미 PageTurner계정이 있나요?</span>
						<!-- 로그인으로 연결하는 링크 -->
						<a class="btn-flat pl-2"
							href="http://localhost/cls/member/login.cls">로그인</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 좌측 파란색 공간 -->
	<section id="accounts-content">


		<div class="container-fluid">
			<div class="row overflow-hidden">
				<div class="d-none d-lg-block text-center sft-enterprise-cta" >
					<div class="sft-enterprise-cta-pattern" aria-hidden="true" style="background-image: url('/cls/img/join.jpg')"></div>
					<div class="sft-text" style="background-color: rgba( 0, 0, 0, 0.5 );">
						<h4 class="mb-3" style="color: white;  font-weight: bold;">책과 함께하는 소통의 공간 PageTurner</h4>
					</div>
					<div class="sft-enterprise-cta-customers">
						<div class="form-row sft-align-center">
							<!-- 좌측 하단부 이미지 첨부-->
							<!--<div class="col-4 d-inline-block h-100 text-center mb-3">
              <img src="./img/b6b9fb1f8999bcbfc4dedc4e07ef09d6-kakao.png" width="62">
            </div>
            
            <div class="col-4 d-inline-block h-100 text-center mb-3">
              <img src="./img/7f6509153e427e88a0a999287993f3dd-sknetworks.png" width="90">
            </div>
            
            <div class="col-4 d-inline-block h-100 text-center mb-3">
              <img src="./img/7252160ba84042b719ae2e0cd1d52975-miraeasset.png" width="125">
            </div>
            
            <div class="col-4 d-inline-block h-100 text-center mb-3">
              <img src="./img/d52b2dfafe85b665c8038f37c2f445c3-siemens.png" width="85">
            </div>
            
            <div class="col-4 d-inline-block h-100 text-center mb-3">
              <img src="./img/08516575e129295ba420191ff10b2122-ey.png" width="45">
            </div>
            
            <div class="col-4 d-inline-block h-100 text-center mb-3">
              <img src="./img/ec8c1109840053d29ffc38e18af41cb1-donga.png" width="110">
            </div>-->

						</div>
					</div>
				</div>
				<div class="row col-12 p-0 justify-content-center sft-register-form">
					<div class="sft-form col-xs-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
						<header>
							<div class="sft-text ">
								<h3 class="text-center">환영합니다!</h3>
								<p class="sft-text-15 text-center">책을 통해 소통하는 sns PageTuner
									지금바로 시작하세요!</p>
							</div>
						</header>
					

						<!-- 회원 정보 입력 -->
							<form action="/cls/member/joinProc.cls" method="POST" id="frm" name="frm">
						



								<div class="control-group form-group">
									<div class="controls">
										<label for="id">아이디</label> 
										<input type="text" class="form-control" id="id" name="id" value="">
										<p class="w3-col w3-center" id="idmsg" style="display: none;"></p>
									</div>
									<div class="controls">
										<button class="btn btn-primary btn-block" id="idck"
											type="button">아이디 확인</button>
									</div>

								</div>

								<div class="control-group form-group">
									<div class="controls">

										<label for="password">비밀번호</label> <input type="password"
											class="form-control" id="password" name="pw">



									</div>
								</div>



								<div class="control-group form-group">
									<div class="controls" id=rePwBox>

										<label for="confirm-password">비밀번호 재확인</label> <input
											type="password" class="form-control" id="confirm-password"
											>
										<div class="repw" id="repw"></div>
									</div>
								</div>
								



								


										<div class="control-group form-group">
									<div class="controls" >

										<label for="confirm-name">이름</label> <input
											type="text" class="form-control" id="name" name="name"
											>
										
									</div>
								</div>
										
										

									

									<!-- <div class="col-12 col-sm-6 pr-2">


										<div class="control-group form-group">
											<div class="controls">

												<label for="phone-number">전화번호</label> <input type="tel"
													class="form-control" id="phone_number" name="phone_number">


											</div>
										</div> 


									</div> -->

								
								<div class="controls">

									<label for="email-address">이메일</label> <input type="email"
										class="form-control" id="email" name="mail" 
										size="5">
									<button class="btn btn-primary btn-block" id="mailck" type="button">인증번호 발송</button>
									<p class="w3-col w3-center" id="mckmsg" style="display: none;"></p>
								</div>
								<div class="controls" id="efrm">

									<label for="email-ck">인증 번호</label> 
									<input type="text"class="form-control" id="email-ck" size="5">
									<button type="button" class="btn btn-primary btn-block" id="emailck">인증하기</button>
								</div>
								<div class="controls">

									<label for="gen">성별</label> 
										<select class="form-control" id="gen" name="gen">
										<option>선택하세요</option>
										<option id="male" >M</option>
										<option id="fmale">F</option>
									</select>
								</div>

								<div class="controls">

									<label for="birthday">생년월일</label> <input type="date"
										class="form-control" id="birthday" name="birthdate" value="">
								</div>
					


															
							<label for="firstG">관심장르</label>
							<div class="controls">
							<c:forEach var="data" items="${GENRE }" varStatus="st">
						<c:if test="${data.genre < 200 }">
							<div style="display: inline-block;">
							<input type="checkbox" onclick="CountChecked(this)" id="${data.genre }" name="interest" value="${data.gname}" faking-checkbox>
							<label class="gangre" for="${data.genre }">${data.gname }</label>
							</div>
						</c:if>
						</c:forEach>
								<!-- <div class="controls">

									<label for="firstG">관심장르</label> 
										<select class="form-control" id="firstG" name="interest">
										<option>선택하세요</option>
										<option>소설</option>
										<option>시/에세이</option>
										<option>사회과학</option>
										<option>역사와문화</option>
										<option>잡지</option>
										<option>만화</option>
										<option>유아</option>
										<option>아동</option>
										<option>가정과생활</option>
										<option>청소년</option>
										<option>초등학습서</option>
										<option>고등학습서</option>
										<option>국어/외국어/사전</option>
										<option>자연과 과학</option>
										<option>경제경영</option>
										<option>자기개발</option>
										<option>인문</option>
										<option>종교/역학</option>
										<option>컴퓨터/인터넷</option>
										<option>자격서/수험서</option>
										<option>취미/레져</option>
										<option>전공/대학도서</option>
										<option>건강/뷰티</option>
										<option>여행</option>
										<option>중등학습서</option>
										<option>어린이(해외)</option>
										<option>ELT/사전(해외)</option>
										<option>문학(해외)</option>
										<option>경영/인문(해외)</option>
										<option>예술/디자인(해외)</option>
										<option>실용(해외)</option>
										<option>해외잡지(해외)</option>
										<option>대학/전문서적(해외)</option>
										<option>컴퓨터(해외)</option>
										<option>일본도서(해외)</option>
										<option>프랑스도서(해외)</option>
										<option>중국도서(해외)</option>
										<option>해외주문원서()</option>
									</select>
									
								</div>
								<div class="controls">
									<label></label>
									<select class="form-control" id="secondG" name="interest">
										<option>선택하세요</option>
										<option>소설</option>
										<option>시/에세이</option>
										<option>사회과학</option>
										<option>역사와문화</option>
										<option>잡지</option>
										<option>만화</option>
										<option>유아</option>
										<option>아동</option>
										<option>가정과생활</option>
										<option>청소년</option>
										<option>초등학습서</option>
										<option>고등학습서</option>
										<option>국어/외국어/사전</option>
										<option>자연과 과학</option>
										<option>경제경영</option>
										<option>자기개발</option>
										<option>인문</option>
										<option>종교/역학</option>
										<option>컴퓨터/인터넷</option>
										<option>자격서/수험서</option>
										<option>취미/레져</option>
										<option>전공/대학도서</option>
										<option>건강/뷰티</option>
										<option>여행</option>
										<option>중등학습서</option>
										<option>어린이(해외)</option>
										<option>ELT/사전(해외)</option>
										<option>문학(해외)</option>
										<option>경영/인문(해외)</option>
										<option>예술/디자인(해외)</option>
										<option>실용(해외)</option>
										<option>해외잡지(해외)</option>
										<option>대학/전문서적(해외)</option>
										<option>컴퓨터(해외)</option>
										<option>일본도서(해외)</option>
										<option>프랑스도서(해외)</option>
										<option>중국도서(해외)</option>
										<option>해외주문원서(해외)</option>
									</select>
								</div>
								<div class="controls">
									<label></label>
									<select class="form-control" id="thirdG" name="interest">
										<option>선택하세요</option>
										<option>소설</option>
										<option>시/에세이</option>
										<option>사회과학</option>
										<option>역사와문화</option>
										<option>잡지</option>
										<option>만화</option>
										<option>유아</option>
										<option>아동</option>
										<option>가정과생활</option>
										<option>청소년</option>
										<option>초등학습서</option>
										<option>고등학습서</option>
										<option>국어/외국어/사전</option>
										<option>자연과 과학</option>
										<option>경제경영</option>
										<option>자기개발</option>
										<option>인문</option>
										<option>종교/역학</option>
										<option>컴퓨터/인터넷</option>
										<option>자격서/수험서</option>
										<option>취미/레져</option>
										<option>전공/대학도서</option>
										<option>건강/뷰티</option>
										<option>여행</option>
										<option>중등학습서</option>
										<option>어린이(해외)</option>
										<option>ELT/사전(해외)</option>
										<option>문학(해외)</option>
										<option>경영/인문(해외)</option>
										<option>예술/디자인(해외)</option>
										<option>실용(해외)</option>
										<option>해외잡지(해외)</option>
										<option>대학/전문서적(해외)</option>
										<option>컴퓨터(해외)</option>
										<option>일본도서(해외)</option>
										<option>프랑스도서(해외)</option>
										<option>중국도서(해외)</option>
										<option>해외주문원서(해외)</option>
									</select>
								</div> -->
							</div>
									
								<div class="controls">

									<label for="introduce">간단소개</label>
									<textarea style="resize: none" rows="10" cols="50" class="form-control" id="introduce" name="describe"  placeholder="자기소개 100자이내로 입력해주세요."></textarea>
									<span id="count"></span>
								</div>

								<div type="button" class="btn btn-primary btn-block" id="submit">
									가입하기</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		
				</section>




		<!-- 풋터 -->
		<footer>
			<div class="row">
				<div class="col-12">
					<p class="text-center">Copyright © 2020 (주)PageTurner. All
						rights reserved</p>
				</div>
			</div>
		</footer>
</body>
</html>