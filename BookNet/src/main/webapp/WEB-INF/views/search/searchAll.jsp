<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
   이 페이지는 모든 검색 결과를 보여주는 페이지 입니다.
  @author 서동혁
  @version v.0.1.0
  @since 2020.05.27
 --%>
<html style="background-color:#F3F0F7">
<head>
<meta charset="UTF-8">
<title>모든 검색 결과 페이지</title>
<link rel="stylesheet" href="/cls/css/proj_fixed.css">
<link rel="stylesheet" href="/cls/css/modal.css">
<link rel="stylesheet" href="/cls/css/w3.css">
<link rel="stylesheet" href="/cls/css/non_search.css">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" /> -->
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/fixed.js"></script>
<script type="text/javascript" src="/cls/js/search.js"></script>
<script>
/*
	이 script는 search페이지에서 상세페이지로 이동시킬 때 쓰일 js 입니다.
	@author 서동혁
	@version v.0.1.0
	@since 2020.06.12
*/
$(document).ready(function() {
	// 검색된 아이디 클릭
	$('#searchIdBtn').click(function(){
	//	$(this).attr('href','/cls/search/searchMember.cls');
		$('#membKey').val('${KEYWORD}');
		$('#test').val('${KEYWORD}');
		$('#frm2').attr('action','/cls/search/searchMember.cls');
		$('#frm2').submit();
	})
	// 검색된 책이름 클릭
	$('#searchBookBtn').click(function(){
	//	$(this).attr('href','/cls/search/searchBook.cls');
		$('#bookKey').val('${KEYWORD}');
		$('#test').val('${KEYWORD}');
		$('#frm2').attr('action','/cls/search/searchBook.cls');
		$('#frm2').submit();
	})
	// 검색된 해시태그 클릭
	$('#searchHashBtn').click(function(){
	//	$(this).attr('href','/cls/search/searchHash.cls');
		$('#hashKey').val('${KEYWORD}');
		$('#test').val('${KEYWORD}');
		$('#frm2').attr('action','/cls/search/searchHash.cls');
		$('#frm2').submit();
	})
});
</script>
</head>
<body onload="printClock()" />
<form method="GET" action="" id="frm2">
	<input type="hidden" name="membKey" id="membKey">
	<input type="hidden" name="bookKey"id="bookKey">
	<input type="hidden" name="hashKey" id="hashKey">
</form>
<form method="POST" action="" id="frm">
   <div>
      <!-- 본문부분 -->
      <div id="contents-wrap">
         <div class="contents" style="width: 1002px;">
            <!-- 이곳에 본문내용을 넣어주세요! -->
            <!-- 모든 검색 결과 창 -->
            <div
               style="line-height: 1; text-align: center; height: 100%; padding: 0px 10px; margin: 0px auto; border-top-width: 0px; border-bottom-width: 0px;">
               <!-- 검색값-->
               <div style="width: 100%; height: 204px;">
                  <!-- 검색어, 해시태그 -->
                     <div
                        style="height: 204px; float: right; width: 610px; position: relative; top: 30px;">
                        <div style="height: 100px; text-align: left;">${KEYWORD}</div>
                        <!-- keyword -->
                        <span
                           style="color: #666; font-size: 14px; float: left; padding-top: 40px; padding-bottom: 5px;"
                           class="box"> 관련 해시태그 </span>
                        <table style="font-size: 14px; height: 50px; display: flex;"
                           class="boxwrap">
                           <tr>
                           <c:forEach var="data" items="${LIST}" begin="0" end="5">
                              <td style="" class="box"><a href="#" style="text-decoration: unset; color: #F7B3D2;">${data.hash}</a>
                              </td>
                           </c:forEach>
                           </tr>
                        </table>
                     </div>
               </div>
               <!-- 검색아이디 -->
               <div style="width: 100%; height: 204px;">
                  <span
                     style="color: #666; font-size: 14px; float: left; padding-top: 40px; padding-bottom: 10px;"
                     class="box" id="searchIdBtn">검색된 아이디</span>
                  <div class="width_scroll">
                        <div style="font-size: 14px;" class="boxwrap">
                     <c:forEach var="data" items="${LIST}">
                           <span style="border: solid 4px transparent;" class="box">
                              <!-- ${data.profile} --><img src="https://img.icons8.com/dusk/64/000000/no-camera.png" 
                              style="text-decoration: unset; color: #F7B3D2; width: 70px; height: 70px;">
                           </span>
                     </c:forEach>
                        </div>
                        <div style="font-size: 14px; margin-bottom: 10px;"
                           class="boxwrap">
                     <c:forEach var="data" items="${LIST}">
                           <span style="border: solid 4px transparent;" class="box">
                              <a href="${data.profile}"
                              style="text-decoration: unset; color: #F7B3D2; width: 70px; height: 70px;">${data.id}</a>
                           </span>
                     </c:forEach>
                        </div>
                  </div>
                  <!-- 검색책 -->
                  <div style="width: 100%; height: 204px;">
                        <span
                           style="color: #666; font-size: 14px; float: left; padding-top: 40px; padding-bottom: 10px;"
                           class="box"id="searchBookBtn"> 검색된 책이름</span>
                        <div style="font-size: 14px;" class="boxwrap">
                     <c:forEach var="data" items="${LIST}" begin="0" end="4">
                           <span style="border: solid 4px transparent;" class="box">
                              <img src="${data.limg}"
                              style="text-decoration: unset; color: #F7B3D2; width: 200px; height: 239px;">
                           </span>
                     </c:forEach>
                        </div>
                        <div style="font-size: 14px; margin-bottom: 10px;"
                           class="boxwrap">
                        <c:forEach var="data" items="${LIST}" begin="0" end="4">
                           <span style="border: solid 4px transparent;" class="box">
                              <a href="#" style="text-decoration: unset; color: #F7B3D2; width: 200px; height: 239px;">${data.bname}</a>
                           </span>
                        </c:forEach>
                        </div>
                        <div style="font-size: 14px;" class="boxwrap">
                     <c:forEach var="data" items="${LIST}" begin="5" end="9">
                           <span style="border: solid 4px transparent;" class="box">
                              <img src="${data.limg}"
                              style="text-decoration: unset; color: #F7B3D2; width: 200px; height: 239px;">
                           </span>
                     </c:forEach>
                        </div>
                        <div style="font-size: 14px; margin-bottom: 10px;"
                           class="boxwrap">
                        <c:forEach var="data" items="${LIST}" begin="5" end="9">
                           <span style="border: solid 4px transparent;" class="box">
                              <a href="#" style="text-decoration: unset; color: #F7B3D2; width: 200px; height: 239px;">${data.bname}</a>
                           </span>
                        </c:forEach>
                        </div>
                     <!-- 검색 해시태그 포함 게시물 -->
                     <div style="width: 100%; height: 204px;">
                        <span
                           style="color: #666; font-size: 14px; float: left; padding-top: 40px; display: block; text-align: left; width: 100%; padding-bottom: 10px;"
                           class="box"id="searchHashBtn">검색된 해시태그가 포함된 게시물 </span>
                        <!-- 여기부터 게시글  -->
                        <c:forEach var="post" items="${LIST}">
                        <article class="eachPost"
                           style="margin: 30px; display: inline-block;"
                           id="이곳은게시물번호가들어갈자리">
                           <!-- 작성자 정보 & 버튼 :: 아이디 불러와야함  -->
                           <div class="wrtInfo">
                                 <div class="wrtProf">
                                    <img src="${post.profile }" />
                                 </div>
                                 <div class="wrter" id="">
                                    <b>${post.id}</b>
                                 </div>
                              <div class="like-butt" id="" style="display: flex;">
                                 <span style="font-size: 12px; line-height: 0px;"
                                    class="like-img" id="likebtn"> </span>
                              </div>
                           </div>
                           <!-- 게시글의 본문부분::도서사진,도서이름,본문 -->
                           <div class="postCont"
                              style="text-align: center; font-size: 16px;">
                              <!-- 도서사진, 도서이름, 게시글본문 -->
                              <div class="book-pic">
                                 <!-- 도서 사진 들어갈 부분 -->
                                 <img src="${post.limg}"
                              style="text-decoration: unset; color: #F7B3D2; width: 200px; height: 239px;">
                              </div>
                              <div class="book-name">
                                 <!-- 도서명 들어갈 부분 -->
                                 ${post.bname}
                              </div>
                              <div class="post-body">
                                 <!-- 게시글 부분 -->
                                 ${post.postcont}
                              </div>
                           </div>
                           <div class="wrtInfo">
                           		<div class="etcdiv" style="text-align: left; font-size: 13px;" id="">${post.hash}</div>
                           		<span class="modifdiv modi_post"></span>
                           </div>
                        </article>
                        </c:forEach>
                        <div style="display: inline-block; width:100%; height:200px; text-align:center; ">
                           <b>-End-</b>
                        </div>
                        <!-- /게시글  -->
                     </div>
                  </div>
               </div>
               <!-- /모든 검색 결과 창 -->
            </div>
         </div>
      </div>
      <!-- 헤더부분 -->
      <div id="header-wrap">
         <div class="header">
            <div class="logobox">
               <div
                  style="box-sizing: border-box; font-size: 30px; text-align: center;">
                  <!-- 로고 이미지 혹은 링크 들어갈 자리 class="div_logo" -->
                  <a href="/cls/main/main.cls"><b>PageTurner</b></a>
               </div>
            </div>
            <div class="searchbox">
               <input id="searchinput" class="searchinput" type="text"
                  placeholder="search" name="searchinput"> <span
                  id="searchclear">X</span>
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
                  <img class="iconimg" id="" src="/cls/img/iconmonstr-user-19-240.png">
               </div>
            </div>
         </div>
      </div>
   </div>
      <!-- 풋터부분 -->
      <footer>
      	<jsp:include page="/WEB-INF/views/include/seoFooter.jsp"/>
      </footer>
</form>
</body>
</html>