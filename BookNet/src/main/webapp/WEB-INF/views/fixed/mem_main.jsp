<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="background-color: #F3F0F7">
<head>
<meta charset="UTF-8">
<title>회원 메인페이지</title>
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
	<input type="hidden" id="body" name="body"> <!-- 글 작성할때 넘겨줄 게시글 본문 -->
	<input type="hidden" id="tags" name="tags"> <!-- 글 작성할때 넘겨줄 해시태그 -->
</form>
<form method="POST" id="frm2">
	<input type="hidden" id="pno" name="pno"> <!-- 게시글 삭제시 넘겨줄 게시글 번호 -->
</form>
<form method="POST" id="frm3">
	<input type="hidden" id="searchinput" name="searchinput"> <!-- 검색시 넘겨줄 키워드 값 -->
</form>
	<!-- 추천도서, 베스트셀러, 신간도서 모달 슬라이드 처리 -->
	<div class="firstModal slideRank" role="none">
		<div class="r-modal-content" id="">
			<div style="width: 100%; height: 10px; margin: 0 atuo;">
				<span class="close r-x-btn" id="r-close_butt" style="color: #fefefe;">x</span>
			</div>
			<div style="width: 100%; height: 10px; margin: 5px auto;">
				<div class="w3-col"><a class="w3-third" style="color: white; font-size: 18px; text-align: center;" href="">신간도서</a></div>
				<!-- <div><a class="w3-third w3-border" style="color: white; text-align: center;" href="">베스트셀러</a></div>
				<div><a class="w3-third w3-border" style="color: white; text-align: center;" href="">추천도서</a></div> -->
			</div>
			<c:forEach begin="0" end="2" varStatus="status">
				<div class="w100-h290 mgt15" style="border-bottom: dashed 1px white"> <!-- 신간도서 정보를 담을 div -->
					<div style="width: 100%; height: 30px; line-height: 30px;"><a style="font-size: 25px; color: white;"><b>${status.count}</b></a></div>
				</div>
			</c:forEach>
		</div>
	</div>
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
									<a style="box-sizing: border-box; font-size: 13px;" id="pbody${data.pno}">${data.postcont}</a>
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
							<span class="close w-x-btn" id="">x</span>
							<div class="w100-pt10">
								<div class="wrtProf" style="width: 45px; height: 45px;">
									<img src="">
								</div>
								<div class="wrter" style="line-height: 40px;" id="">
									<a href="" style="font-size: 18px;"><b class="wrter"></b></a>
								</div>
								<div class="time" style="line-height: 40px;" id="time"></div>
							</div>
							<div class="w100-h500">
								<div class="w500-h450">
									<div class="genre-pad" id="genre-pad"></div>
									<div class="genre-pad" style="height: 35px; font-size: 25px; line-height: 25px;"><b id="genre-name"><b></b></b></div>
									<div class="book-pic">
										<!-- 도서 사진 들어갈 부분 -->
										<img id="bimg" src="" style="float: left; box-sizing: border-box;" />
									</div>
									<div class="detail-body">
										<!-- 게시글 부분 -->
										<a style="box-sizing: border-box; font-size: 13px;" id="p-body"></a>
									</div>
								<div class="w100-h35">
									<div style="float: left; margin-left: 20px; text-align: left; font-size: 12px;" id="gethash"></div>
									<div class="like-butt" style="margin-right: 20px;" id="">
										<span style="font-size: 12px; line-height: 0px;" class="comt-img comtbtn"></span>
									</div>
									<div class="like-butt" id="" style="display: flex;'">
										<span style="font-size: 12px; line-height: 0px;" class="like-img likebtn" id=""></span>
									</div>
								</div>
								</div>
								<div class="w450-h400">
									<div class="w450-h400 post-comment" style="height: 350px;" id="">
										<!-- 댓글 리스트 뽑아오기 -->
									</div>
									<div class="wrtcomt hidcommt" style="display: none;" id="">
										<div class="comwrter">
											<input type="hidden">
											<a>${SID}</a>
										</div>
										<input type="text" id="-comt-id" class="combody" placeholder="댓글을 입력하세요." />
										<input type="button" class="comsubbtn" value="등록" id=""/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 우측 정보 부분 : 고정페이지로 들어갈 것-->
				<div class="info_area">
					<div style="width: 100%; height: 250px; margin-top: 15px;">
						<div class="w100-h40" style="/* background-position: inherit; background-image: url('/BookNet/img/manuscript_img.png');  */border-bottom: solid 1px black;">
							<a class="fl-fs13"><b>페이지터너에서 가장 많은 글이 달린 도서</b></a>
						</div>
						<c:forEach var="bData" items="${OLIST}">
							<div class="w100-h40" id="${bData.bno}">
								<a class="fl-fs10">${bData.gname}</a>
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
						<a href="/cls/main/main.cls" style="color: #6b70b2;"><b>PageTurner</b></a>
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
						<div id="writeModal" style="padding-top: 50px;" class="w3-modal">
							<div id="" class="w-modal-content">
								<span class="close w-x-btn" id="w-close_butt">x</span>
									<!-- onclick="document.getElementById('actModal').style.display='none'" -->
								<!-- 도서검색 -->
								<div class="w-b-input">
									<!-- 도서장르 선택 -->
									<div style="float: left; wdith: 100px; height: 40px; line-height: 40px; margin-right: 10px;">
										<select name="selGenre" id="setGenre">
											<option value="">도서장르</option>
											<c:forEach var="genre" items="${GENRE}">
												<option value="${genre.genre}">${genre.gname}</option>
											</c:forEach>
										</select>
									</div>
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
		 							<div class="sel-wrt-b-info" id="sel-wrt-b-info">
		 								<div style="width: 100%; height: 20px; margin-top: 10px;" id="rst-book-gname"></div>
		 								<div style="width: 100%; height: 20px; margin-top: 10px;" id="rst-book-bname"></div>
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