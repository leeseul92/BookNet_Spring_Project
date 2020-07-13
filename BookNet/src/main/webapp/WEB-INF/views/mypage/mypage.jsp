<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/cls/js/mypage.js"></script>
<script type="text/javascript">
</script>
<title>마이페이지</title>
</head>
<body onload="printClock()"/>
<c:if test="${SID eq INFO.id}">
	<script type="text/javascript">
		history.replaceState({}, null, location.pathname);
	</script>
</c:if>
<div>
	<div id="contents-wrap">
		<!-- 페이지 가로 길이 지정 -->
    	<div style="width: 900px; margin: 0 auto;">
      		<div class="w3-col w3-margin-top" style="height: 720px;">
        		<div class="w3-col w3-margin-top">
          		<!-- 좌측 : 회원 프로필 사진 및 게시글과 팔로우, 팔로워 수, 팔로우하기(언팔로우하기) -->
          		<div class="w3-col m3">
            	<!-- 회원 프로필 사진 -->
            		<img class="w3-col" style="width: 225px; height: auto;" src="/cls/img/${INFO.save_name}" />
            		<div class="w3-col">
              			<!-- 게시글 수 -->
              			<h3 class="w3-col w3-center">
                			<label for="cntpost">게시글 수 : </label>
                			<a id="cntpost" href="/cls/mypage/mypage.cls?id=${INFO.id}">${CNTPOST}</a>
              			</h3>
              			<!-- 팔로우 수 -->
              			<h3 class="w3-col w3-center">
                			<label for="cntfallow">팔로우 수 : </label>
                			<a id="cntfallow" href="/cls/mypage/fallow.cls?id=${INFO.id}">${CNTFALLOW}</a>
              			</h3>
              			<!-- 팔로워 수 -->
              			<h3 class="w3-col w3-center">
                			<label for="cntfallower">팔로워 수 : </label>
                			<a id="cntfallower" href="/cls/mypage/fallower.cls?id=${INFO.id}">${CNTFALLOWER}</a>
             			</h3>
              			<!-- 팔로우 여부 -->
						  <c:if test="${SID ne INFO.id}">
	              			<div class="w3-col w3-center">
								<input name="pid" id="pid" type="hidden" value="${INFO.id}" />
							  	<c:choose>
							  		<c:when test="${CKFAL == 'Y'}">
							  			<h5 class="w3-button"  id="fal">
											팔로우중
										</h5>
										<input name="ckfal" id="ckfal" type="hidden" value="Y" />
									</c:when>
									<c:otherwise>
										<h5 class="w3-button" id="fal">
											팔로우하기
										</h5>
										<input name="ckfal" id="ckfal" type="hidden" value="N" />
							  		</c:otherwise>
							  	</c:choose>
	             			</div>
						  </c:if>
            		</div>
          		</div>
          		<div class="w3-col m1"><p></p></div>
          			<!-- 우측 : 회원정보(공개된것만), 알람리스트(본인이 접속한 경우), 좋아요 리스트, 작성한 게시글 리스트(타인이 접속한 경우) -->
          			<div class="w3-col m8 w3-margin-bottom" style="padding-right: 10px;">
	            		<!-- 회원정보 -->
	            		<div class="w3-col" style="margin-bottom: 0px; margin-left: 10px;">
		              		<!-- 인플루언서 여부 -->
		              		<c:if test="${INFO.isinflu eq 'Y'}">
		                		<img class="w3-col m1 w3-margin-top" style="width: 32px; height: 32px; margin-bottom: 0px;" src="https://img.icons8.com/windows/32/000000/instagram-check-mark.png" />
		              		</c:if>
		              		<h2 class="w3-col m9" style="margin-bottom: 0px;">
		                		${INFO.id} 프로필
		              		</h2>
	            		</div>
            			<!-- 회원정보 -->
            			<div class="w3-border" style="max-height: 243.2px; border-radius: 5px; overflow: auto; padding-left: 3px; margin-left: 10px;">
              				<c:if test="${INFO.genshow eq 'Y'}">
                				<h6 style="margin-bottom: 0px;">성별</h6>
                				<h2 style="margin-top: 0px; margin-left: 5px;">${INFO.gen}</h2>
              				</c:if>
              				<c:if test="${INFO.birthshow eq 'Y'}">
                				<h6 style="margin-bottom: 0px;">생일</h6>
                				<h2 style="margin-top: 0px; margin-left: 5px;">
                  					${INFO.birthdate}
                				</h2>
              				</c:if>
              				<c:if test="${INFO.intershow eq 'Y'}">
               					<h6 style="margin-bottom: 0px;">관심분야</h6>
                				<h2 style="margin-top: 0px; margin-left: 5px;">
                  					${INFO.interest}
                				</h2>
              				</c:if>
           					<h6 style="margin-bottom: 0px;">한줄 소개</h6>
           					<h5 style="margin-top: 0px; margin-left: 5px;">
             					${INFO.describe}
           					</h5>
         				</div>
	           			 <!-- 본인이 접속한 경우 정보수정 페이지로 갈 수 있는 링크와 알람리스트가 보인다. -->
	            		<c:if test="${SID eq INFO.id}">
              				<!-- 정보수정 페이지로 갈 수 있는 링크 -->
              				<div class="w3-col" style="margin-right: 0px; height: 44.8px;">
                				<h6 class="w3-right-align" style="margin-bottom: 0px; margin-top: 3px;">
                  					<a style="margin-bottom: 0px;" href="/cls/member/editMemInfo.cls">정보수정</a>
                				</h6>
              				</div>
              				<!-- 알람 리스트 -->
              				<div style="margin-top: 25px; margin-bottom: 0px; margin-left: 10px;">
                				<h2 style="margin-bottom: 0px;">
                  					<a href="/cls/alarm/alarmPage.cls">알람</a>
                				</h2>
              				</div>
              				<div class="w3-border" style="height: 155px; border-radius: 5px; overflow: auto; margin-left: 10px;">
                				<c:forEach begin="0" end="4" var="alarm" items="${ALARM}">
                  					<div class="w3-padding" id="${alarm.pno}">
                    					<div>
                      						<h5 class="w3-center">
	                        					<!-- 댓글 알람 -->
	                        					<c:if test="${alarm.type eq 'C'}">
	                          						<a href="/cls/mypage/mypage.cls?id=${alarm.id}" id="${alarm.id}">${alarm.id}</a>님이
	                          						<a href="" id="${alarm.pno}">${alarm.bname}</a>
	                          							게시글에 댓글을 달았습니다.
	                        					</c:if>
	                        					<!-- 좋아요 알람 -->
	                        					<c:if test="${alarm.type eq 'L'}">
	                          						<a href="/cls/mypage/mypage.cls?id=${alarm.id}" id="${alarm.id}">${alarm.id}</a>님이
	                          						<a href="" id="${alarm.pno}">${alarm.bname}</a>
	                          							게시글에 좋아요를 눌렀습니다.
	                        					</c:if>
	                        					<!-- 팔로우 알람 -->
	                        					<c:if test="${alarm.type eq 'F'}">
	                          						<a href="/cls/mypage/mypage.cls?id=${alarm.id}" id="${alarm.id}">${alarm.id}</a>님이 팔로우하였습니다.
	                        					</c:if>
                      						</h5>
                    					</div>
					                    <!-- 현재 시간을 기준으로 이벤트가 언제 발생했는지 표시 -->
					                    <div style="text-align: right;">${alarm.dday}</div>
                  					</div>
                				</c:forEach>
            				</div>
            			</c:if>
            			<div style="margin-top: 25px; margin-bottom: 0px;">
              				<h2 style="margin-bottom: 0px; margin-left: 10px;">
                				<a href="">${INFO.id}가 좋아하는 글</a>
              				</h2>
            			</div>
            			<div class="w3-border" style="height: 160px; border-radius: 5px; overflow: auto; margin-left: 10px;">
              				<c:forEach begin="0" end="4" var="like" items="${LIKE}">
                				<div class="w3-col" style="height: 150px; margin-bottom: 3px;" id="${like.pno}">
                 					<div class="w3-col m2" style="margin-top: 10px;">
                    					<img src="${like.smallimg}" style="width: 96.88px; height: auto;"/>
                  					</div>
                  					<div class="w3-col m10">
                    					<div class="w3-col">
											<h1 class="w3-col m7" style="margin-left: 7px;">
														<a href="/cls/mypage/mypage.cls?id=${like.id}">${like.id}</a>
											</h1>
											<h6 class="w3-col m2">
														${like.pdate}
											</h6>
											<div class="w3-col m2 w3-right-align" style="margin-top: 20px; margin-bottom: 30px;">
														<c:choose>
																<c:when test="${like.ischeck eq 'Y'}">
																		 <img class="like-img" src="../img/fullheart.png" />
																</c:when>
																<c:otherwise>
																	  <img class="like-img" src="../img/emptyheart.png" />
																</c:otherwise>
														</c:choose>
														<c:if test="${SID eq like.id}">
																<img class="e-d-img" src="../img/submenu.png" />
														</c:if>
											</div>
										</div>
										<div class="w3-col" style="margin-top: 0px;">
											<h6 class="w3-col" style="margin-left: 7px; margin-bottom: 0px; margin-top: 10px; width: auto;">${like.postcont}</h6>
										</div>
									</div>
               					</div>
              				</c:forEach>
            			</div>
            			<c:if test="${SID ne INFO.id}">
              				<div style="margin-top: 25px; margin-bottom: 0px;">
                				<h2 style="margin-bottom: 0px; margin-left: 10px;">
                  					<a href="">${INFO.id}가 작성한 글</a>
                				</h2>
              				</div>
              				<div class="w3-border" style="height: 160px; border-radius: 5px; overflow: auto; margin-left: 10px;">
                				<c:forEach begin="0" end="4" var="post" items="${POST}">
                  					<div class="w3-col" style="height: 150px; margin-bottom: 3px;" id="${post.pno}">
                    					<div class="w3-col m2" style="margin-top: 10px;">
                      						<img src="${post.smallimg}" style="width: 96.88px; height: auto;"/>
                    					</div>
                    					<div class="w3-col m10">
                      						<div class="w3-col">
												  <h1 class="w3-col m7" style="margin-left: 7px;">
														  <a href="/cls/mypage/mypage.cls?id=${post.id}">${post.id}</a>
												  </h1>
												  <h6 class="w3-col m2">
														  ${post.pdate}
												  </h6>
												  <div class="w3-col m2 w3-right-align" style="margin-top: 20px; margin-bottom: 30px;">
														  <c:choose>
																	  <c:when test="${post.ischeck eq 'Y'}">
																			  <img class="like-img" src="../img/fullheart.png" />
																	  </c:when>
																	  <c:otherwise>
																			  <img class="like-img" src="../img/emptyheart.png" />
																	  </c:otherwise>
														  </c:choose>
														  <c:if test="${SID eq post.id}">
																	  <img class="e-d-img" src="../img/submenu.png" />
														  </c:if>
												  </div>
											  </div>
											  <div class="w3-col" style="margin-top: 0px;">
												  <h6 class="w3-col" style="margin-left: 7px; margin-bottom: 0px; margin-top: 10px; width: auto;">${post.postcont}</h6>
											  </div>
                    					</div>
                  						</div>
                				</c:forEach>
             				</div>
            			</c:if>
          			</div>
       			</div>
      		</div>
    	</div>
	</div>
	<!-- 고정페이지부분 -->
	<jsp:include page="/WEB-INF/views/fixed.jsp" />
</div>
</body>
</html>