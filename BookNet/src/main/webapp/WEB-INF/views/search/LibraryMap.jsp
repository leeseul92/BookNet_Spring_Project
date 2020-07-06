<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LibraryMap</title>
<link rel="stylesheet" href="/cls/css/proj_fixed.css">
<link rel="stylesheet" href="/cls/css/libMap.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
</head>
<body>
		<!-- 도서관 정보 넣을 부분 -->
	<div class="libPoint" id="contents-wrap" >
		도서관 정보 가져올 div
		
		
		
		
		
		
		
		
		
		<!-- 지도 컨테이너 -->
		<div class="libPointMap">
			<!-- 지도 위치 조정 -->
			<div class="mapLay">
				<!-- 지도 정보 가져올 div -->
				<a class="mapImg">
					<span class="libmap">i'm map</span>
				</a>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/fixed.jsp"/>
</body>
</html>