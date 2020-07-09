<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
   이 페이지는 해쉬태그 검색 결과를 보여주는 페이지 입니다.
  @author 서동혁
  @version v.0.1.0
  @since 2020.05.27
 --%>
<html style="background-color:#F3F0F7">
<head>
<meta charset="UTF-8">
<title>해쉬태그 검색 결과 페이지</title>
<link rel="stylesheet" href="/cls/css/proj_fixed.css">
<link rel="stylesheet" href="/cls/css/modal.css">
<link rel="stylesheet" href="/cls/css/w3.css">
<link rel="stylesheet" href="/cls/css/non_search.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/fixed.js"></script>
<script type="text/javascript" src="/cls/js/search.js"></script>
<script>
	$(function(){
		// 엔터검색
		$('#searchinput').keyup(function(e) {
			if (e.keyCode == 13) {
				$('#hashKey').val('${KEYWORD}');
				$('#frm').attr('action', '/cls/search/searchHash.cls');
				$('#frm').submit();
			}
		})
	})
</script>
</head>
<body onload="printClock()" />
<form method="POST" action="" id="frm">
   <div>
      <!-- 본문부분 -->
      <div id="contents-wrap">
         <div class="contents" style="width: 1002px;">
            <!-- 이곳에 본문내용을 넣어주세요! -->
            <div
               style="line-height: 1; text-align: center; height: 100%; padding: 0px 10px; margin: 0px auto; border-top-width: 0px; border-bottom-width: 0px;">
               <!-- 검색값-->
               <div style="width: 100%; height: 204px;">
                  <!-- 검색어 -->
                     <div
                        style="height: 204px; float: right; width: 610px; position: relative; top: 30px;">
                        <div style="height: 100px; text-align: left;">${KEYWORD}</div>
                     </div>
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
                        <!-- /게시글  -->
                     </div>
               </div>
               <!-- /모든 검색 결과 창 -->
            </div>
         </div>
            	<!-- 고정페이지부분 -->
		<jsp:include page="/WEB-INF/views/fixed.jsp" />
      </div>
</form>
</body>
</html>