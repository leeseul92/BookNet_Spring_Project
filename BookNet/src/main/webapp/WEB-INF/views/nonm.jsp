<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<%--
	이 페이지는 비회원에게 보여지는 게시물 메인페이지 || 로그인, 가입하기 유도 페이지 입니다.
  @author 서동혁
  @version v.0.1.0
  @since 2020.05.25
 --%>
<html style="background-color: #F3F0F7">
<head>
<meta charset="UTF-8">
<title>비회원 메인페이지</title>
<link rel="stylesheet" href="/cls/css/nonmem.css?v=1 ">
<link rel="stylesheet" href="/cls/css/non_search.css?v=1">
<link rel="stylesheet" href="/cls/css/proj_fixed.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/cls/css/modal.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/cls/css/w3.css?v=<%=System.currentTimeMillis() %>">
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/fixed.js?v=<%=System.currentTimeMillis() %>"></script>
<script type="text/javascript" src="/cls/js/clock.js?v=<%=System.currentTimeMillis() %>"></script>
<script type="text/javascript" src="/cls/js/nonmem.js?v=<%=System.currentTimeMillis() %>"></script>
<script src = "https://unpkg.com/sweetalert/dist/sweetalert.min.js?v=1" ></script>
</head>
<form method="POST" id="frm2">
	<input type="hidden" id="pno" name="pno"> <!-- 게시글 삭제시 넘겨줄 게시글 번호 -->
</form>
	<div>
		<!-- 헤더부분 -->
		<div id="header-wrap">
			<div class="header">
				<div class="logobox">
					<div style="box-sizing: border-box; font-size: 30px; text-align: center;">
						<!-- 로고 이미지 혹은 링크 들어갈 자리 class="div_logo" -->
						<a href="/cls/main/non.cls" style="color: #120E0A;"><b>PageTurner</b></a>
					</div>
				</div>
				<div class="searchbox">
					<input class="searchinput" type="text" placeholder="search">
				</div>
			  <div class="iconsbox">
               <!-- 상단 로그인, 가입하기 버튼 -->
               <a href="#" class="ft-log foot-box mg-whtie"  style="color: #fff;"id="lbtn">로그인</a>
               <a href="#" class="ft-join joinc0l0" style="padding-left:15px; color:rgba(var(--d69,0,149,246),1);" id="jbtn">가입하기</a>
               <!-- /상단 로그인, 가입하기 버튼 -->
            </div>
			</div>
		</div>
		<!-- Footer Link -->
		     <div class="closeing bgalss dCJb6 rBNOH Igw0E pmxbr HcJZg XfCBB IY_1 4EzTm" style="z-index: 2; height:111.938px; bottom: 0px; position: fixed;">
		         <!-- close button -->
		         <button class="xqRnw dCJp8">
		            <!-- <span aria-label="닫기" style="text-align: center; margin: 0px auto;"><img src="https://img.icons8.com/plasticine/100/000000/close-window.png" style="width: 24px; height: 24px;"/></span> -->
		            <span aria-label="닫기" class="insbak insgreyClose" style="margin: 3px;"></span>
		         </button>
		         <!-- /close button -->
		         <!-- div area -->
		         <div class="divflex" style="width: 903px; margin: 0px auto;">
		            <!-- area in icon -->
		            <div style="height: 56px; width: 56px; border: 1px solid white;" class="inblock posit bd-rad">
		               <span aria-label="로그인" style="color: white; display: block; padding: 6px; padding-top: 15px;" class="XfCBB HcThg dCJb6 full0">LOGO</span>
		            </div>
		            <!-- /area in icon -->
		            <!-- text body -->
		            <div class="mg-left dblock rG18m">
		               <!-- from Login -->
		               <div class="mg-whtie">
		                  <div>PageTurner에 로그인</div>
		               </div>
		               <!-- /from Login -->
		               <!-- body -->
		               <div class="footbody">PageTurner에서 다른 사람들과 당신이 좋아하는 책에 대해 이야기해보세요<img style="width: 20px; hieght: 20px;"src="https://img.icons8.com/cotton/64/000000/apple--v2.png"/></div>
		               <!-- /body -->
		            </div>
		            <!-- /text body -->
		            <!-- Login, Join button -->
		            <div class="ft-btn">
		               <!-- Login -->
		               <div class="mt-12">
		                  <a href="#" class="ft-log foot-box mg-whtie"style="color: #fff;" id="lbtn2">로그인</a>
		               </div>
		               <!-- /Login -->
		               <!-- Join -->
		               <div style="text-align:center; margin-top: 12px; padding: 0px 30px;">
		                  <a href="#" class="ft-join joinc0l0" style="color:rgba(var(--d69,0,149,246),1);"id="jbtn2">가입하기</a>
		               </div>
		               <!-- /Join -->
		            </div>
		            <!-- /Login, Join button -->
		         </div> 
		         <!-- /div area -->
		      </div>
		<!-- /Footer Link -->
	     <!-- 풋터부분 -->
      <footer>
      	<jsp:include page="/WEB-INF/views/include/seoFooter.jsp"/>
      </footer>
   </div>
</body>
</html>