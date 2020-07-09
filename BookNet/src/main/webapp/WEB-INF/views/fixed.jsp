<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="background-color: #F3F0F7">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/cls/css/proj_fixed.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/cls/css/modal.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/cls/css/w3.css?v=<%=System.currentTimeMillis() %>">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" /> -->
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/fixed.js?v=<%=System.currentTimeMillis() %>"></script>
<script type="text/javascript" src="/cls/js/clock.js?v=<%=System.currentTimeMillis() %>"></script>
<style>
</style>	
<script type="text/javascript">
</script>
</head>
<body onload="printClock()"/>
<!-- 파라미터로 넘길 데이터값 -->
<form method="POST" id="frm">
	<input type="hidden" id="bno" name="bno"> <!-- 글 작성할때 넘겨줄 책 번호 -->
	<input type="hidden" id="eno" name="eno"> <!-- 글 작성할때 넘겨줄 감정번호 -->
	<input type="hidden" id="sid" name="sid" value="${SID}"> <!-- 세션에 저장된 아이디값 -->
	<input type="hidden" id="postcont" name="postcont"> <!-- 글 작성할때 넘겨줄 게시글 본문 -->
	<input type="hidden" id="hash" name="hash"> <!-- 글 작성할때 넘겨줄 해시태그 -->
	<input type="hidden" id="domain" name="domain"> <!-- 글 작성할때 넘겨줄 뷰 주소값 -->
</form>
<form method="POST" id="frm3">
	<input type="hidden" id="searchinput" name="searchinput"> <!-- 검색시 넘겨줄 키워드 값 -->
</form>
	<div>
		<!-- 헤더부분 -->
		<div id="header-wrap">
			<div class="header">
				<div class="logobox">
					<div style="box-sizing: border-box; font-size: 30px; text-align: center;">
						<!-- 로고 이미지 혹은 링크 들어갈 자리 class="div_logo" -->
						<a href="/cls/main/main.cls" style="color: #6b70b2;"><b>PageTurner</b></a>
					</div>
				</div>
				<div class="searchbox">
					<input class="searchinput" type="text" placeholder="search">
					<span id="searchclear">X</span>
				</div>
				<div class="iconsbox">
					<div style="float: left; width:80px;"> 
						<a href="/cls/member/logoutProc.cls">로그아웃</a>
						<!-- <img class="iconimg" id="" src="/cls/img/iconmonstr-compass-4-240.png"> -->
					</div> 
					<!-- 알람표시아이콘 -->
					<div class="span_icons">
						<button type="button" class="butt" id="aBtn">
							<img class="iconimg" id="" src="/cls/img/iconmonstr-bell-7-240.png">
						</button>
						<!-- The Modal -->
						<div id="actModal" class="modal" role="none">
							<!-- Modal Content -->
							<div style="width: 900px; height: auto; margin: 0 auto;">
								<div id="modal-content" class="a-modal-content">
									<span class="close w-x-btn" id="a-close_butt">x</span>
									<!-- onclick="document.getElementById('actModal').style.display='none'" -->
									<p>Some Text....</p>
									<div style="width: 100%; height: 30px; line-height: 30px; background-color: rgba(0, 0, 0, 0.4);">
										<!-- <input type="button" value="MORE" id="more_butt" style="width: 100%; box-sizing: border-box;"/> -->
										<div style="width: 100%; text-align: center" id="more_butt">MORE</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="span_icons" id=""> 
						<button type="button" class="butt" id="wBtn">
							<img class="iconimg" id="" src="/cls/img/iconmonstr-pen-15-240.png">
						</button>
						<!-- The Modal -->
						<div id="writeModal" style="padding-top: 50px;" class="w3-modal">
							<div id="" class="w-modal-content">
								<span class="close w-x-btn" id="w-close_butt">x</span>
									<!-- onclick="document.getElementById('actModal').style.display='none'" -->
								<!-- 도서검색 -->
								<div class="w-b-input">
									<!-- 도서장르 선택 -->
									<div style="float: left; width: 100px; height: 40px; line-height: 40px; margin-right: 10px;">
										<select name="selGenre" id="setGenre">
											<option value="">도서장르</option>
											<c:forEach var="genre" items="${GENRE}" varStatus="status">
												<option value="${genre.genre}" id="genre${status.count}">${genre.gname}</option>
											</c:forEach>
										</select>
									</div>
									<input type="search" id="findBook" placeholder="도서검색" style="float: left; width: 190px; height: 40px; line-height: 40px;"/>
									<input type="button" id="book-search" value="검색" style="float: left; width: 40px; height: 40px; line-height: 40px; margin-left: 10px;"/>
	 							</div>
	 							<div class="wrt-div" style="margin-top: 25px;">
									<div class="wrt-b-img">
										<img id="sel-wrt-b-img"/>
									</div>
		 							<div class="sel-wrt-b-info" id="sel-wrt-b-info">
		 								<div style="width: 100%; height: 20px; margin-top: 10px;" id="rst-book-gname"></div>
		 								<div style="width: 100%; height: 20px; margin-top: 10px;" id="rst-book-bname"></div>
		 							</div>
		 						</div>
		 						<div class="wrt-div">
		 							<!--  감정 셀렉트 -->
									<div class="w-e-sel">
										<select name="emotion" id="selEmo">
											<option value="">감정을 선택해주세요X)</option>
											<option value="2">덜덜;무서워욧!</option>
											<option value="3">ㅠ_ㅠ불안해요..</option>
											<option value="4">very exciting!</option>
											<option value="1">행복해요X)</option>
											<option value="5">그리워요;ㅁ;</option>
										</select>
									</div>
		 							<div class="wrt-body">
	 									<textarea class="-a-t" id="postBody" wrap="hard"></textarea>
	 								</div>
	 							</div>
	 							<div class="wrt-last">
	 								<input type="button" value="취소하기" class="wrt-butt" id="c-submit"/>
	 								<input type="button" value="등록하기" class="wrt-butt" style="float: right;" id="p-submit"/>
	 							</div>
							</div>
							<!-- 도서검색 결과 모달창 -->
 							<div class="w3-modal" id="-s-b-modal">
 								<div id="" class="s-modal-content">
 									<span class="close w-x-btn" style="position: fixed;" id="s-close_butt">x</span>
 									<div class="-s-rst" id="rst-cont">
 										<b>검색 결과</b>
 									</div>
 									<div class="rstPage">
 										<!-- 검색결과 리스트 -->
	 								</div>
 								</div>
 							</div>
						</div>
					</div> 
					<div class="span_icons"> 
						<button type="button" class="butt" id="myBtn">
							<img class="iconimg" id="" src="/cls/img/iconmonstr-user-19-240.png">
						</button>
					</div>
				</div>
			</div>
		</div>
     	<!-- /Footer Link -->
     	<!-- 풋터부분 -->
      <footer>
      	<jsp:include page="/WEB-INF/views/include/seoFooter.jsp"/>
      </footer>
	</div>
</body>
</html>