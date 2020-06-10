/*
	이 문서는 search페이지에서 쓰일 js 입니다.
	@author 서동혁
	@version v.0.1.0
	@since 2020.05.28
*/
 
$(document).ready(function() {
	// search clear
	var $ipt = $('#searchinput'), $clearIpt = $('#searchclear');
	// keyup시 x표시
	$ipt.keyup(function() {
		$("#searchclear").toggle(Boolean($(this).val()));
	});
	// 엔터검색
	$('#searchinput').keyup(function(e) {
		if (e.keyCode == 13) {
			$('#frm').attr('action', '/BookNet/search/searchAll.cls');
			$('#frm').submit();
		}
	})
	
	$clearIpt.toggle(Boolean($ipt.val()));
	$clearIpt.click(function() {
		$("#searchinput").val('').focus();
		// display 속성을 none으로 바꾼다. : 감춘다
		$(this).hide();
	});
});
