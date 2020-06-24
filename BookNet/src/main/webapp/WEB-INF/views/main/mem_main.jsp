<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="background-color: #F3F0F7">
<head>
<meta charset="UTF-8">
<title>회원 메인페이지</title>
<link rel="stylesheet" href="/cls/css/proj_fixed.css?after=1">
<link rel="stylesheet" href="/cls/css/modal.css?after">
<link rel="stylesheet" href="/cls/css/w3.css?after">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" /> -->
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/fixed.js"></script>
<script type="text/javascript" src="/cls/js/clock.js"></script>
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
	<input type="hidden" id="body" name="body"> <!-- 글 작성할때 넘겨줄 게시글 본문 -->
	<input type="hidden" id="tags" name="tags"> <!-- 글 작성할때 넘겨줄 해시태그 -->
</form>
<form method="POST" id="frm2">
	<input type="hidden" id="pno" name="pno"> <!-- 게시글 삭제시 넘겨줄 게시글 번호 -->
</form>
<form method="POST" id="frm3">
	<input type="hidden" id="searchinput" name="searchinput"> <!-- 검색시 넘겨줄 키워드 값 -->
</form>
	<div>
		<!-- 본문부분 -->
		<div id="contents-wrap">
			<div class="contents">
				<!-- 좌측 게시글 부분 -->
				<div class="posts_area">
					<c:forEach var="data" items="${LIST}">
						<article class="eachPost"><!-- id="${data.pno}" -->
							<!-- 작성자 정보 & 버튼 :: 아이디 불러와야함  -->
							<div class="wrtInfo">
								<div class="wrtProf">
									<img src="">
								</div>
								<div class="wrter" id="id${data.pno}"><a href=""><b id="">${data.id}</b></a></div>
								<div class="time" id="time${data.pno}">${data.pdate} ${data.ptime}</div>
								<c:if test="${SID eq data.id}">
									<div class="like-butt" id="${data.pno}" style="display: flex;'">
										<span style="font-size: 12px; line-height: 0px;" class="e-d-img edbtn" id=""></span>
									</div>
								</c:if>
								<div class="like-butt" id="${data.pno}" style="display: flex;'">
									<span style="font-size: 12px; line-height: 0px;" class="like-img likebtn" id="like${data.pno}"></span>
								</div>
							</div>
							<!-- 게시글의 본문부분::도서사진,도서이름,본문 -->
							<div class="postCont" style="text-align: center; font-size: 16px;">
								<!-- 도서사진, 도서이름, 게시글본문 -->
								<div class="book-pic">
									<!-- 도서 사진 들어갈 부분 -->
									<img id="img${data.pno}" src="${data.largeimg}" style="width: 90%; height: auto;" />
								</div>
								<div class="genre-name" style="font-size: 12px; text-align: left;" id="genre${data.pno}">
									<!-- 도서장르 들어갈 부분 -->
									${data.gname}
								</div>
								<div class="book-name" id="bname${data.pno}">
									<!-- 도서명 들어갈 부분 -->
									<b>${data.bname}</b>
								</div>
								<div class="post-body">
									<!-- 게시글 부분 -->
									<a style="box-sizing: border-box; font-size: 18px;" id="pbody${data.pno}">${data.postcont}</a>
								</div>
							</div>
							<div class="wrtInfo">
								<div class="etcdiv" style="text-align: left; font-size: 13px;" id="hash${data.pno}">${data.hash}</div>
								<span class="modifdiv modi_post" id="${data.pno}"></span>
							</div>
						</article>
					</c:forEach>
					<!-- 게시물 수정 삭제 선택 띄워주는 모달 -->
					<div class="modal edit-del-modal" role="none">
						<div class="e-modal-content" style="margin: 100px auto;" id="">
							<div class="w100-pt10" style="height: 40px; border-top: 1px solid black; border-bottom: 1px solid black;">
								<a id="e-btn" style="font-size: 15px; position: absolute; line-height: 1;">수 정</a>
							</div>
							<div class="w100-pt10" style="height: 40px;">
								<a id="d-btn" style="font-size: 15px; position: absolute; line-height: 1;">삭 제</a>
							</div>
							<div class="w100-pt10" style="height: 40px; border-top: 1px solid black; border-bottom: 1px solid black;">
								<a id="c-btn" style="font-size: 15px; position: absolute; line-height: 1;">취 소</a>
							</div>
						</div>
					</div>
					<!-- 게시물 상세보는 모달 -->
					<div class="modal detailPost" role="none">
						<div class="p-modal-content" id="" style="height: 540px;">
							<span class="close w-x-btn" id="d-close_butt">x</span>
							<div class="w100-pt10">
								<div class="wrtProf" style="width: 45px; height: 45px;">
									<img src="">
								</div>
								<div class="wrter" style="line-height: 40px;" id="">
									<a href="" style="font-size: 18px;"><b class="wrter"></b></a>
								</div>
								<div class="time" style="line-height: 40px;" id="time"></div>
								<div class="like-butt" id="">
									<span style="font-size: 12px; line-height: 0px;" class="comt-img comtbtn"></span>
								</div>
								<div class="like-butt" id="" style="display: flex;'">
									<span style="font-size: 12px; line-height: 0px;" class="like-img likebtn" id=""></span>
								</div>
								<div class="w100-h290">
									<div class="book-pic">
										<!-- 도서 사진 들어갈 부분 -->
										<img id="bimg" src="" style="float: left; box-sizing: border-box;" />
									</div>
									<div class="genre-pad" id="genre-pad"></div>
									<div class="genre-pad" style="font-size: 25px; line-height: 25px;"><b id="genre-name"><b></b></b></div>
									<div class="detail-body">
										<!-- 게시글 부분 -->
										<a style="box-sizing: border-box; font-size: 15px;" id="p-body"></a>
									</div>
								</div>
								<div class="w100-h35">
									<div style="margin-left: 20px; text-align: left; font-size: 12px;" id="gethash"></div>
								</div>
								<div class="w100-h95" id="">
									<!-- 댓글 리스트 뽑아오기 -->
								</div>
								<div class="wrtcomt hidcommt" style="display: none;" id="">
									<div class="comwrter">
										<input type="hidden">
										<a>${SID}</a>
									</div>
									<input type="text" class="combody" placeholder="댓글을 입력하세요." />
									<input type="button" class="comsubbtn" value="등록" id=""/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 우측 정보 부분 : 고정페이지로 들어갈 것-->
				<div class="info_area">
					<div style="width: 100%; height: 250px; margin-top: 15px;">
						<div class="w100-h40" style="border-bottom: solid 1px black;">
							<a class="fl-fs13"><b>페이지터너에서 가장 많은 글이 달린 도서</b></a>
						</div>
						<c:forEach var="bData" items="${OLIST}">
							<div class="w100-h40" id="${bData.bno}">
								<a class="fl-fs10" href="">${bData.gname}</a>
								<div class="fl-fs15">${bData.bname}</div>
							</div>
						</c:forEach>
					</div>
					<div style="width: 100%; height: 200px; margin-top: 15px; border: solid 1px white;">
						<a></a>
					</div>
				</div>
				<!-- 우측 정보 끝! -->
			</div>
		</div>
		<!-- 헤더부분 -->
		<div id="header-wrap">
			<div class="header">
				<div class="logobox">
					<div style="box-sizing: border-box; font-size: 30px; text-align: center;">
						<!-- 로고 이미지 혹은 링크 들어갈 자리 class="div_logo" -->
						<a href="/cls/main/main.cls" style="color: #120E0A;"><b>PageTurner</b></a>
					</div>
				</div>
				<div class="searchbox">
					<input class="searchinput" type="text" placeholder="search">
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
						<div id="writeModal" class="w3-modal">
							<div id="" class="w-modal-content">
								<span class="close w-x-btn" id="w-close_butt">x</span>
									<!-- onclick="document.getElementById('actModal').style.display='none'" -->
								<!-- 도서검색 -->
								<div class="w-b-input">
									<input type="search" id="findBook" placeholder="도서검색" style="float: left; width: 190px; height: 40px; line-height: 40px;"/>
									<input type="button" id="book-search" value="검색" style="float: left; width: 40px; height: 40px; line-height: 40px; margin-left: 10px;"/>
									<!-- 감정 셀렉트 -->
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
	 							</div>
	 							<div class="wrt-div">
									<div class="wrt-b-img">
										<img id="sel-wrt-b-img"/>
									</div>
		 							<div class="wrt-body">
		 								<p style="height: 80px; line-height: 80px; margin-bottom: 30px; font-size: 25px;" id="sel-wrt-b-ttl"></p>
	 									<textarea class="-a-t" id="postBody"></textarea>
	 								</div>
	 							</div>
	 							<div class="wrt-last">
	 								<input type="text" placeholder="hashTags" class="hash-input" id="hash-input"/>
	 								<input type="button" value="글 등록" class="p-submit" id="p-submit"/>
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
     		<!-- 풋터부분 -->
		<footer id="footer-wrap" style="padding:10px; height: 86.45px; color: #FFF;">		
					<h3 style="position:absolute; top:40px; left: 260px; display: flex;">Company</h3><br><h4 style="position:absolute;  top:35px; left: 360px; display: flex; font-size: 10pt;">Increpas</h4><br><h4 style="position:absolute; top:55px; left: 360px; display: flex; font-size:10pt;">서울특별시 관악구 신림동 시흥대로 552</h4>
					<h3 style="position:absolute; top:40px; left: 760px; display: flex;">Project_Team</h3><br><h4 style="position:absolute; top:35px; left: 890px; display: flex; font-size: 10pt;">BookNet KOR</h4><br><h4 style="position:absolute; top:55px; left: 890px; display: flex; font-size:10pt;">PageTurner</h4>
					<h3 style="position:absolute; top:40px; left: 1135px; display: flex;">만든이</h3><br><h4 style="position:absolute; top:35px; left: 1202px; display: flex; font-size: 10pt;">박 기윤 | 김 이슬 | 이 명환</h4><br><h4 style="position:absolute; top:55px; left: 1202px; display: flex; font-size:10pt;">서 동혁 | 우 현우 |</h4>
			    <small>
			    <p style="position:absolute; top:120px; left: 800px; display: flex;">Copyright © 2020 BookNet.co.,Ltd. All rights reserved.</p>
			    <a href="#"  style="position:absolute; top:139px; left: 1037px; display: flex;"><address style="font-size:12px; color:#fff;">@인플루언서 신청 ., @ Apply for Influencer</address></a>
			    <address style="position:absolute; top:140px; left: 800px; display: flex;">Contact increpas for more information. </address>
			    </small>
			    <img src="https://img.icons8.com/dusk/64/000000/finn.png" style="position:absolute; top:100px; left: 1497px; display: flex; width:64px; height: 64px;"/>
			    <img src="https://img.icons8.com/dusk/64/000000/jake.png" style="position:absolute; top:100px; left: 1582px; display: flex; width:64px; height: 64px;"/>
			    <img src="https://img.icons8.com/dusk/64/000000/stich.png" style="position:absolute; top:100px; left: 1667px; display: flex; width:64px; height: 64px;"/>
			    <img src="https://img.icons8.com/dusk/64/000000/homer-simpson.png" style="position:absolute; top:100px; left: 1752px; display: flex; width:64px; height: 64px;"/>
			    <img src="https://img.icons8.com/dusk/64/000000/futurama-zoidberg.png" style="position:absolute; top:100px; left: 1830px; display: flex; width:64px; height: 64px;"/>
			    <div style="/*border:2px solid #fff;*/ width: 400px; height:80px; line-height:65px; color:#fff;font-size:60px; text-align:center; position:absolute; top:10px; left: 1490px;" id="clock">
				</div>  
		</footer>
	</div>
</body>
</html>