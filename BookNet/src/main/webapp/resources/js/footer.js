/**
 * 이 클래스는 footer 이벤트를 관리하는 문서입니다.
 * @actor 서동혁
 * @version v.0.1.0
 * @since 2020.05.28
 */
$(function(){
// footerUp
	var hei = $('#footer-wrap').css("height"); 
	var wei = 0;
		// 올리기 
	 $("#footer-wrap").mouseenter(function(){
			if($('#footer-wrap').css("height") == hei){
				$('#footer-wrap').css("transition","all 0.6s");
				$('#footer-wrap').css("background-color","#F7B3D2");
				$('#footer-wrap').css("color","#FFF");
				$('#footer-wrap').css("height","186.438px");
				$('#arrow').fadeOut();
			}
	// 내리기
	 	$("#footer-wrap").mouseleave(function(){
	 		 wei = $('#footer-wrap').css("height");
	 		if($('#footer-wrap').css("height") == wei){
	 			$('#footer-wrap').css("height", hei);
				$('#footer-wrap').css("background-color","#F3F0F7");
				$('#footer-wrap').css("color","#FFF");
				$('#footer-wrap').css("transition","all 0.6s");
				$('#footer-wrap').css("overflow","hidden");
				$('#arrow').css("display","");
	 		}
		})
	})
//	$('#influencer').click(function(){
//		$('#influencer').attr('href','');
//	})
})