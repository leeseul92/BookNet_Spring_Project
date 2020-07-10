<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 이 페이지는 알람 목록을 보여줄 페이지이다.
	@auther	박기윤
	@since	2020.05.27
-->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>팔로우페이지</title>
    <script type="text/javascript" src="/BookNet/js/jquery-3.5.0.min.js"></script>
    <style>
    	.div_activity {
			width: ;
			border-bottom: solid 1px black;
			height: 200px;
			line-height: 100px;
			padding: 10px;
			margin: 5px;
		}
    
      .prof_pic {
        float: left;
        width: 120px;
        height: 160px;
        text-align: center;
        border: solid 1px black;
      }
      
      .div_act {
			float: left;
			width: 800px;
			height: 100%;
			text-align: center;
			margin-left: 20px;
			margin-top: -8px;
		}
    </style>
  </head>
  <body>
    <div>
      <!-- 본문부분 -->
      <div id="contents-wrap">
        <div style="width: 900px; margin: 15px auto; text-align: center;">
          <div>
          	<h1>${ID} 팔로우 목록</h1>
          </div>
          <div>
            <c:forEach var="memb" items="${LIST}">
              <div class="div_activity new-act">
                <div class="prof_pic">
                  <img src="/cls/img/${memb.sloc}" style="width: 100%; height: 100%; margin-top: -26px;" />
                </div>
                <div class="div_act">
                  <div class="ala_cont" style="font-size: 16px;" id="${memb.fallow_no}">${memb.id}</div>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
      <!-- 고정페이지부분 -->
      <jsp:include page="/WEB-INF/views/fixed.jsp" />
    </div>
  </body>
</html>
