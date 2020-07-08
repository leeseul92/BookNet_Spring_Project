<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 이 파일은 베스트셀러를 슬라이드 쇼로 보여주기 위한
      jsp 파일이다.
      작성자: 박기윤
      작성일: 2020.07.07
      버전:   v.1.0
-->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title></title>
    <link rel="stylesheet" href="/cls/css/w3.css" />
    <link rel="stylesheet" href="/cls/css/main_slideshow.css" />
    <script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
    <style></style>
    <script type="text/javascript"></script>
  </head>
  <body>
    <div class="slideshow-container">
      <c:forEach var="list" items="${BLIST}">
        <div class="mySlides fade">
          <div class="sl-img">
            <img src="${list.largeimg}" style="width: 100%; height: 100%" />
          </div>
          <div class="sl-info">
            <div><h6>${list.gname}</h6></div>
            <div><h3>${list.bname}</h3></div>
            <div><h5>${list.writer}</h5></div>
            <div><h6>${list.publish}</h6></div>
          </div>
        </div>
      </c:forEach>

      <a class="prev" onclick="plusSlides(-1)"><h4>&#10094;</h4></a>
      <a class="next" onclick="plusSlides(1)"><h4>&#10095;</h4></a>
    </div>
  </body>
  <script type="text/javascript" src="/cls/js/main_slideshow.js"></script>
</html>