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
    <title>알림페이지</title>
    <script
      type="text/javascript"
      src="/BookNet/js/jquery-3.5.0.min.js"
    ></script>
    <style></style>
  </head>
  <body>
    <div>
      <!-- 본문부분 -->
      <div id="contents-wrap">
        <div style="width: 900px; margin: 15px auto; text-align: center;">
          <!-- 알림 반복시켜줘야함. -->
          <c:forEach var="alarm" items="${LIST}">
            <div class="div_activity new-act">
              <div class="prof_div">
                <img src="/cls/img/${alarm.save_name}" style="width: 100%; height: auto; margin-top: -26px;" />
              </div>
              <div class="div_act">
                <!-- 나에게 새로운 알람을 준 회원의 아이디 + 알람의 내용 -->
                <div
                  class="ala_cont"
                  style="font-size: 16px;"
                  id="${alarm.pno}"
                >
                  <c:if test="${alarm.type eq 'C'}">
                    <div>
                      <a href="/BookNet/mypage/mypage.cls?id=${alarm.id}" id="${alarm.id}" >${alarm.id}</a>님이
                      <a href="" id="${alarm.bname}">${alarm.bname}</a> 게시글에 댓글을 달았습니다.
                    </div>
                  </c:if>
                  <c:if test="${alarm.type eq 'L'}">
                    <div>
                      <a href="/BookNet/mypage/mypage.cls?id=${alarm.id}" id="${alarm.id}" >${alarm.id}</a>님이
                      <a href="" id="${alarm.bname}">${alarm.bname}</a> 게시글에 좋아요를 눌렀습니다.
                    </div>
                  </c:if>
                  <c:if test="${alarm.type eq 'F'}">
                    <div>
                      <a href="/BookNet/mypage/mypage.cls?id=${alarm.id}" id="${alarm.id}" >${alarm.id}</a>님이 팔로우하였습니다.
                    </div>
                  </c:if>
                  <div style="text-align: right;">
                    ${alarm.dday}
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
      <!-- 고정페이지부분 -->
      <jsp:include page="/WEB-INF/views/fixed.jsp" />
    </div>
  </body>
</html>
