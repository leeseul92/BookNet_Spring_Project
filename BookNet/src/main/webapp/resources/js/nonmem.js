/**
 * 이 JS는 호출과 footer, 검색창 clear이벤트를 준다.
 * @actor 서동혁
 * @version v.0.1.0
 * @since 2020.05.27
 */
$(function(){ 

   $('#lbtn').click(function(){
      $(location).attr('href','/cls/member/login.cls');
   })
   $('#lbtn2').click(function(){
      $(location).attr('href','/cls/member/login.cls');
   })
   $('#jbtn').click(function(){ 
      $(location).attr('href','/cls/member/join.cls');
   })
   $('#jbtn2').click(function(){
      $(location).attr('href','/cls/member/join.cls');
   })
   $('.dCJp8').click(function(){
      $('.closeing').remove();
   })
   // login_alert	
   $('.searchinput').keyup(function(e){
	   if(e.keyCode==13){
		   swal ({ text:"Oops" , title:"Please use after login!" ,  icon:"error" });
		   /* 	swal({
					  title:  "Please use after login!" , icon: "success", buttons:["12314", "Do it!"],
					}); */
		   
	   }
   })
   //게시물 클릭시 로그인 유도
   $('.eachPost').click(function(e){
		   swal ({ text:"Oops" , title:"Please use after login!" ,  icon:"error" });
   })
	
   $('.likebtn').click(function(e){
	   swal ({ text:"Oops" , title:"Please use after login!" ,  icon:"error" });
   })
		// search clear
		var $ipt = $('.searchinput'), $clearIpt = $('.searchclear');
		// keyup시 x표시
		$ipt.keyup(function() {
			$("#searchclear").toggle(Boolean($(this).val()));
		});
		$clearIpt.toggle(Boolean($ipt.val()));
		$clearIpt.click(function() {
			$("#searchinput").val('').focus();
			// display 속성을 none으로 바꾼다. : 감춘다
			$(this).hide();
		});

})