<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<%--
	이 페이지는 비회원에게 보여지는 게시물 메인페이지 | 로그인, 가입하기 유도 페이지 입니다.
  @author 서동혁
  @version v.0.1.0
  @since 2020.05.25
 --%>
<html style="background-color: #F3F0F7">
<head>
<meta charset="UTF-8">
<title>비회원 메인페이지</title>
</head>
<body onload="printClock()"/>
<form method="POST" id="frm2">
	<input type="hidden" id="pno" name="pno"> <!-- 게시글 삭제시 넘겨줄 게시글 번호 -->
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
			<!-- 고정페이지부분 -->
  		<jsp:include page="/WEB-INF/views/nonm.jsp"/>
   </div>
</body>
</html>