<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 
	이 페이지는 footer를 include로 활용할 페이지
	@actor 서동혁
	@version v.0.1.0
	@since 2020.06.12
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/cls/css/proj_fixed.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="/cls/css/w3.css?v=<%=System.currentTimeMillis() %>">
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/clock.js?v=<%=System.currentTimeMillis() %>"></script>
<script type="text/javascript" src="/cls/js/footer.js?v=<%=System.currentTimeMillis() %>"></script>
<style>
</style>
<script type="text/javascript">
</script>
</head>
<body onload="printClock()"/>
      <!-- 풋터부분 -->
      <footer id="footer-wrap"
         style="padding: 0px 10px 10px 10px; height: 20px; color: #FFF;">
         <!-- 화살표 -->
         <div style="text-align: center;" id="arrow"><img src="https://img.icons8.com/material-rounded/24/000000/chevron-up.png"/></div>
         <!-- /화살표 -->
         <h3
            style="font-size: 18.72px; position: absolute; top: 40px; left: 255px; display: flex; font-family: Verdana, sans-serif;">Company</h3>
         <br>
         <h4
            style="position: absolute; top: 35px; left: 380px; display: flex; font-size: 10pt; font-family: Verdana, sans-serif;">Increpas</h4>
         <br>
         <h4
            style="position: absolute; top: 55px; left: 380px; display: flex; font-size: 10pt; font-family: Verdana, sans-serif;">서울특별시
            관악구 신림동 시흥대로 552</h4>
         <h3
            style="font-size: 18.72px; position: absolute; top: 40px; left: 735px; display: flex; font-family: Verdana, sans-serif;">Project_Team</h3>
         <br>
         <h4
            style="position: absolute; top: 35px; left: 910px; display: flex; font-size: 10pt; font-family: Verdana, sans-serif;">BookNet
            KOR</h4>
         <br>
         <h4
            style="position: absolute; top: 55px; left: 910px; display: flex; font-size: 10pt; font-family: Verdana, sans-serif;">PageTurner</h4>
         <h3
            style="font-size: 18.72px; position: absolute; top: 40px; left: 1135px; display: flex; font-family: Verdana, sans-serif;">만든이</h3>
         <br>
         <h4
            style="position: absolute; top: 35px; left: 1222px; display: flex; font-size: 10pt; font-family: Verdana, sans-serif;">박
            기윤 | 김 이슬 | 이 명환</h4>
         <br>
         <h4
            style="position: absolute; top: 55px; left: 1222px; display: flex; font-size: 10pt; font-family: Verdana, sans-serif;">서
            동혁 | 우 현우 |</h4>
         <small>
            <p
               style="position: absolute; top: 120px; left: 800px; display: flex;">Copyright
               © 2020 BookNet.co.,Ltd. All rights reserved.</p> <a id="influencer" href="" 
            style="position: absolute; top: 139px; left: 1037px; display: flex;"><address
                  style="font-size: 12px; color: #fff;">@인플루언서 신청 ., @
                  Apply for Influencer</address></a>
            <address
               style="position: absolute; top: 140px; left: 800px; display: flex;">Contact
               increpas for more information.</address>
         </small> <img src="https://img.icons8.com/dusk/64/000000/finn.png"
            style="position: absolute; top: 100px; left: 1497px; display: flex; width: 64px; height: 64px;" />
         <img src="https://img.icons8.com/dusk/64/000000/jake.png"
            style="position: absolute; top: 100px; left: 1582px; display: flex; width: 64px; height: 64px;" />
         <img src="https://img.icons8.com/dusk/64/000000/stich.png"
            style="position: absolute; top: 100px; left: 1667px; display: flex; width: 64px; height: 64px;" />
         <img src="https://img.icons8.com/dusk/64/000000/homer-simpson.png"
            style="position: absolute; top: 100px; left: 1752px; display: flex; width: 64px; height: 64px;" />
         <img
            src="https://img.icons8.com/dusk/64/000000/futurama-zoidberg.png"
            style="position: absolute; top: 100px; left: 1830px; display: flex; width: 64px; height: 64px;" />
         <div
            style="width: 400px; height: 80px; line-height: 65px; color: #fff; font-size: 60px; text-align: center; position: absolute; top: 10px; left: 1490px;"
            id="clock"></div>
      </footer>
</body>
</html>