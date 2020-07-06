<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 
	이 문서는 search페이지에서 파라미터를 받아올 페이지 입니다.
	@author 서동혁
	@version v.0.1.0
	@since 2020.06.12
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script src = "https://unpkg.com/sweetalert/dist/sweetalert.min.js" ></script>
<script>
$(document).ready(function() {
	if('${param.membKey}' =='${param.test}'){
		swal ({ text:"Wait!" , title:"Please Wait!" ,  icon:"success" });
		$('#membKey').val('${param.membKey}');
		$('#frm').attr('action','/cls/search/searchMember.cls');
	} else if('${param.bookKey}'=='${param.test}'){
		swal ({ text:"Wait!" , title:"Please Wait!" ,  icon:"success" });
		$('#bookKey').val('${param.bookKey}');
		$('#frm').attr('action','/cls/search/searchBook.cls');
	} else if('${param.hashKey}'=='${param.test}'){
		swal ({ text:"Wait!" , title:"Please Wait!" ,  icon:"success" });
		$('#hashKey').val('${param.hashKey}');
		$('#frm').attr('action','/cls/search/searchHash.cls');
	}
		$('#frm').submit();
})
</script>
</head>
<body>
<form method="POST" action="" id="frm">
	<input type="hidden" name="membKey" id="membKey">
	<input type="hidden" name="bookKey"id="bookKey">
	<input type="hidden" name="hashKey" id="hashKey">
</form>
</body>
</html>