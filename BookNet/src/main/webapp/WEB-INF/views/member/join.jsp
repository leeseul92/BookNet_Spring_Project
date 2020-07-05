<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
					<!--<a class="d-none d-lg-block" href="https://shiftee.io/ko"><img src="./img/logo-with-text-white.png" height="32"></a>-->
					<h3 class="turnerlogo">PageTurner</h3>
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
				<div class="d-none d-lg-block text-center sft-enterprise-cta">
					<div class="sft-enterprise-cta-pattern" aria-hidden="true"></div>
					<div class="sft-text">
						<h4 class="mb-3">책과 함께하는 소통의 공간 PageTurner</h4>
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
						<div>



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
											type="text" class="form-control" id="confirm-password" name="name"
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
										class="form-control" id="email-address" name="mail" value=""
										size="5">
									<button class="btn btn-primary btn-block" id="mailck"
										type="button">인증번호 발송</button>
								</div>
								<div class="controls" id="efrm">

									<label for="email-ck">인증 번호</label> <input type="email"
										class="form-control" id="email-ck" 
										size="5">
									<button type="button" class="btn btn-primary btn-block"
										id="emailck">인증하기</button>
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

								


								<div class="row sft-terms-and-privacy-agreement-container">
									<label>관심 장르(국내도서)</label>
								</div>
								
								<div class="row sft-terms-and-privacy-agreement-container">
									<input type="checkbox" id="social" name="interest">
									<p class="gangre">소설</p>
									<input type="checkbox" id="Pessay" name="interest">
									<p class="gangre">시/에세이</p>
									<input type="checkbox" id="apculture" name="interest">
									<p class="gangre">예술/대중문화</p>
									<input type="checkbox" id="sscience" name="interest">
									<p class="gangre">사회과학</p>
									<input type="checkbox" id="hculture" name="interest">
									<p class="gangre">역사와문화</p>
									<input type="checkbox" id="magazine" name="interest">
									<p class="gangre">잡지</p>
									<input type="checkbox" id="comic" name="interest">
									<p class="gangre">만화</p>
									<input type="checkbox" id="inchild" name="interest">
									<p class="gangre">유아</p>
									<input type="checkbox" id="child" name="interest">
									<p class="gangre">아동</p>
									<input type="checkbox" id="famliylife" name="interest">
									<p class="gangre">가정과생활</p>
									<input type="checkbox" id="youth" name="interest">
									<p class="gangre">청소년</p>
									<input type="checkbox" id="elementary" name="interest">
									<p class="gangre">초등학습서</p>
									<input type="checkbox" id="High" name="interest">
									<p class="gangre">고등학습서</p>
									<input type="checkbox" id="nforgin" name="interest">
									<p class="gangre">국/외국어/사전</p>
									<input type="checkbox" id="nscience" name="interest">
									<p class="gangre">자연과 과학</p>
									<input type="checkbox" id="emanagement" name="interest">
									<p class="gangre">경제경영</p>
									<input type="checkbox" id="Sdevelopment" name="interest">
									<p class="gangre">자기개발</p>
									<input type="checkbox" id="humanities" name="interest">
									<p class="gangre">인문</p>
									<input type="checkbox" id="rmechanics" name="interest">
									<p class="gangre">종교/역학</p>
									<input type="checkbox" id="cinternet" name="interest">
									<p class="gangre">컴퓨터/인터넷</p>
									<input type="checkbox" id="licence" name="interest">
									<p class="gangre">자격서/수험서</p>
									<input type="checkbox" id="hobby" name="interest">
									<p class="gangre">취미/레져</p>
									<input type="checkbox" id="majar" name="interest">
									<p class="gangre">전공/대학도서</p>
									<input type="checkbox" id="haelth" name="interest">
									<p class="gangre">건강/뷰티</p>
									<input type="checkbox" id="trapic" name="interest">
									<p class="gangre">여행</p>
									<input type="checkbox" id="middle" name="interest">
									<p class="gangre">중등학습서</p>

								</div>
								<div class="row sft-terms-and-privacy-agreement-container">
									<label>관심 장르(해외도서)</label>
								</div>
								<div class="row sft-terms-and-privacy-agreement-container">
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