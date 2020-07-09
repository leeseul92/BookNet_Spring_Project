<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
   이 페이지는 아이디 검색 결과를 보여주는 페이지 입니다.
  @author 서동혁
  @version v.0.1.0
  @since 2020.05.27
 --%>
<html style="background-color:#F3F0F7">
<head>
<meta charset="UTF-8">
<title>아이디 검색 결과 페이지</title>
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
			$('#membKey').val('${KEYWORD}');
			$('#frm').attr('action','/cls/search/searchMember.cls');
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
                <!-- 검색아이디 -->
               <div style="width: 100%; height: 204px;">
                  <span
                     style="color: #666; font-size: 14px; float: left; padding-top: 40px; padding-bottom: 10px;"
                     class="box">검색된 아이디</span>
                  <div class="width_scroll">
                        <div style="font-size: 14px;" class="boxwrap">
                     <c:forEach var="data" items="${LIST}">
                           <span style="border: solid 4px transparent;" class="box">
                              <!-- ${data.profile} -->
                              <img src="https://img.icons8.com/dusk/64/000000/no-camera.png" 
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
                  </div>
                 </div>
            </div>
         </div>
           	<!-- 고정페이지부분 -->
		<jsp:include page="/WEB-INF/views/fixed.jsp" />
      </div>
</form>
</body>
</html>