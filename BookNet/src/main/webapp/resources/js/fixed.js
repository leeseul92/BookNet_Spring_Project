/*
 * 이 스크립트는 jquery 진행을 위한 스크립트 파일입니다.
 * 웹 내 이벤트 처리를 담당하며 ajax 처리 또한 존재합니다.
 * @author leeseul kim
 * @since 25th May 2020
 * 
 */

function selrstbook(){
	var selno = $(this).parents().attr('id'); //도서 isbn 번호 
//	alert(selno);
	var selimg = $('#b-image').attr('src'); //도서 이미지
	var selttl = $('#b-title').text(); //도서 제목 
//	alert(selttl); 
	$('#-s-b-modal').css('display', 'none');
$('.rstPage').html('');
	//값 셋팅 
	$('#bno').val(selno);
	$('#sel-wrt-b-img').attr('src', selimg);
	$('#sel-wrt-b-ttl').html('<b>' + selttl + '</b>');
}


$(document).ready(function(){
	
	$(document).scroll(function() {
		var maxHeight = $(document).height();
		var currentScroll = $(window).scrollTop() + $(window).height();
		if (maxHeight <= currentScroll + 100) {
			$('.posts_area').append('<article class="eachPost" id="이곳은게시물번호가들어갈자리"><!-- 작성자 정보 & 버튼 :: 아이디 불러와야함  --><div class="wrtInfo"><div class="wrtProf"><img src="https://img.icons8.com/cotton/64/000000/apple--v1.png"/></div><div class="wrter" id=""><b>작성자아이디</b></div><div class="like-butt" id=""><span style="font-size: 12px; line-height: 0px;" class="comt-img"></span></div><div class="like-butt" id="" style="display: flex;"><span style="font-size: 12px; line-height: 0px;" class="like-img" id="likebtn"></span></div></div><!-- 게시글의 본문부분::도서사진,도서이름,본문 --><div class="postCont" style="text-align: center; font-size: 16px;"><!-- 도서사진, 도서이름, 게시글본문 --><div class="book-pic"><!-- 도서 사진 들어갈 부분 --></div><div class="book-name"><!-- 도서명 들어갈 부분 --></div><div class="post-body"><!-- 게시글 부분 --></div></div><div class="etcdiv" style="text-align: center; font-size: 16px;">태그<!-- 게시글 해시태그 부분 --></div></article>');
		}
		
	});
	
	// footerUp
	var hei = $('#footer-wrap').css("height"); 
	 $("#footer-wrap").mouseenter(function(){
			if($('#footer-wrap').css("height") == "86.438px"){
				$('#footer-wrap').css("transition","all 0.6s");
				$('#footer-wrap').css("background-color","#F7B3D2");
				$('#footer-wrap').css("color","#FFF");
				$('#footer-wrap').css("height","186.438px");
				
			} else if($('#footer-wrap').css("height") == hei){
				$('#footer-wrap').css("transition","all 0.6s");
				$('#footer-wrap').css("background-color","#F7B3D2");
				$('#footer-wrap').css("color","#FFF");
				$('#footer-wrap').css("height","186.438px");
			}
	 	$("#footer-wrap").mouseleave(function(){
	 		if($('#footer-wrap').css("height") == "186.438px"){
	 			$('#footer-wrap').css("height", "86.438px");
				$('#footer-wrap').css("background-color","#F3F0F7");
				$('#footer-wrap').css("color","#FFF");
				$('#footer-wrap').css("transition","all 0.6s");
				$('#footer-wrap').css("overflow","hidden");
	 		}
		});
	});
	
	// 엔터검색
	$('.searchinput').keyup(function(e) {
		if (e.keyCode == 13) {
			var key = $('.searchinput').val();
//			alert(key);
			$('#searchinput').val(key);
			$('#frm3').attr('action', '/BookNet/search/searchAll.cls');
			$('#frm3').submit();
		}
	});
	
	$('#more_butt').click(function() { //modal에서 알림페이지로 이동 
		$(location).attr('href', '/BookNet/alarm/alarmPage.cls');
	});

	$('#aBtn').click(function() { //modal 열기
		$('#actModal').css('display', 'block');
	});

	$('#a-close_butt').click(function() { //modal 닫기버튼 
		$('#actModal').css('display', 'none');
	});

	$('#s-close_butt').click(function() { //modal 닫기버튼 
		$('#-s-b-modal').css('display', 'none');
		$('.rstPage').html('');
		$('#findBook').value('');
	});
	
	$('#myBtn').click(function(){
		$(location).attr('href', '/BookNet/mypage/mypage.cls');
	});
	
	$('.likebtn').click(function(){ //like 버튼 클릭시 빨강하트로 변경 
		$(this).css('background-position', '-208px -370px');
		var pno = $(this).parents().attr('id');
//		alert(pno);
		
		//비동기처리 
		$.ajax({
			url: '/BookNet/ajax/clickLikeBtn.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				'pno': pno
			},
			success: function(data){
				if(data.cnt == 1){
					//cnt 값이 1이면 디비에 저장 완료 
				}
			},
			error: function(){
				alert("###통신에러###");
			}
		});
	});
	
	$('.edbtn').click(function(){ //수정삭제를 보여주는 아이콘클릭시 수정과 삭제를 선택하게 하는 모달 
		$('.edit-del-modal').css('display', 'block');
		//frm2에 값을 전달해주어야함. 
		var pno = $(this).parents().attr('id');
//		alert(pno);
		$('#pno').val(pno); 
	});
	
	$('#e-btn').click(function(){ //수정 버튼을 눌렀을 때 처리이벤트 
		
	});
	
	$('#d-btn').click(function(){ //삭제 버튼을 눌렀을 때 처리이벤트 
		$('#frm2').attr('action', '/BookNet/post/postDelProc.cls')
		$('#frm2').submit();
	});
	
	$('#c-btn').click(function(){ //취소 버튼을 눌렀을 때 처리이벤트 
		//수정삭제 모달 닫아주어야한다.
		$('.edit-del-modal').css('display', 'none');
	});
	
	$('.comtbtn').click(function(){ //댓글버튼 클릭시 댓글 달 수 있는 창 보여주기 
		$('.wrtcomt').css('display', '');
		$('.p-modal-content').css('height','590px');
	});
	
	$('.modi_post').click(function(){ //게시물 상세보기 모달 
		var pno = $(this).attr('id'); //게시글번호
		var sid = $('#'+'id'+pno).text(); //작성자 아이디
		var stime = $('#'+'time'+pno).html(); //작성시간 
		var simg = $('#'+'img'+pno).attr('src'); //선택도서 사진
		var sgen = $('#'+'genre'+pno).text(); //선택도서 장르 
		var bname = $('#'+'bname'+pno).text(); //선택도서 제목
		var pbody = $('#'+'pbody'+pno).text(); //본문 
		var htags = $('#'+'hash'+pno).text(); //해시태그 
		$('.p-modal-content').attr('id', pno);
		$('b.wrter').html(sid);
		$('#time').html(stime);
		$('#bimg').attr('src', simg);
		$('#genre-pad').html(sgen);
		$('b#genre-name').html(bname);
		$('#p-body').html(pbody);
		$('#gethash').html(htags);
//		alert(sgen);
		$.ajax({
			url: '/BookNet/ajax/showRplList.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				'pno': pno
			},
			success: function(obj){
				var len = obj.length;
//				alert(obj[0].comnt);
//				alert(len);
				if(len != 0){
					for(var i = 0; i < len; i++){
						$('.w100-h95').attr('id', obj[i].cno);
						var str = $('.w100-h95').attr('id');
						$('#'+str).append('<div style="float: left; width: 30px; height: 30px; margin-left: 10px; border: 1px dashed black;">' +
											'<img src="" style="box-sizing: border-box;"/>' +
											'</div>' +
											'<div class="h30-m10" style="width: 60px;">' + obj[i].id + '</div>' +
											'<div class="h30-m10" style="width: 150px;">' + obj[i].sdate + '</div>' +
											'<div class="h30-m10" style="width: 280px;">' + obj[i].comnt + '</div>');
						$('.detailPost').css('display', 'block');
					}
				} else{
					$('.detailPost').css('display', 'block');
				}
			},
			error: function(){
				alert("실패!");
			}
		});
	});
	
	$('.comsubbtn').click(function(){ //댓글 등록하기 
		var pno = $('.p-modal-content').attr('id');
		var cbody = $('.combody').val();
		
		$.ajax({
			url: '/BookNet/post/addRplProc.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				'cbody': cbody,
				'pno': pno
			},
			success: function(data){
				if(data.cnt != 1){
					alert('댓글등록에 실패하였습니다.');
				}
				
				$('.combody').val('');
				$('.w100-h95').append('<div style="float: left; width: 30px; height: 30px; margin-left: 10px; border: 1px dashed black;">' +
						'<img src="" style="box-sizing: border-box;"/>' +
						'</div>' +
						'<div class="h30-m10" style="width: 60px;">'+ data.id +'</div>' +
						'<div class="h30-m10" style="width: 150px;">'+  data.date +'</div>' +
						'<div class="h30-m10" style="width: 280px;">' + data.body + '</div>');
				
			},
			error: function(){
//				console.log('code: ' + request.status + '\n message: ' + request.responseText + '\n error: ' + error);
				alert("###통신에러###");
			}
		});
	});
	
	$('#d-close_butt').click(function(){ //게시물 상세보기 닫기 
		$('.detailPost').css('display', 'none');
		$('.w100-h95').html('');
	});
	
	$('#wBtn').click(function(){ //글쓰기 modal 열기 
		$('#writeModal').css('display', 'block');
	});
	
	$('#w-close_butt').click(function(){ //글쓰기 모달 닫기 
		$('#writeModal').css('display', 'none');
	});
	
	$('#changeInfo').click(function(){ //정보수정페이지로 이동 
		$(location).attr('href', '/BookNet/member/editMemInfo.cls');
	});
	

	//글작성 도서검색 ajax 처리 구문
	$('#book-search').click(function(){ //글쓰기 모달에서 읽은 도서 검색 클릭시 처리해주는 함수 
		$('#-s-b-modal').css('display', 'block');
		
		//입력한 검색어를 변수에 저장한다.
		var book = $('#findBook').val();
//		alert(book);
		//InterParkAPI 
		$.ajax({ 
			url : '/BookNet/ajax/searchBook.cls',
			type : 'POST',
			dataType : 'json',
			data : {
				'searchWord' : book
			},
//			tranditional: true,
			success : function(obj){ //SearchBook.java 에서 gstr json 문서가 들어오게 된다.
				var len = obj.length;
				
//				console.log(len);
//				alert(obj[0].isbn);
				for(var i = 0; i < len; i++){
					$('.rstPage').append('<div class="w100perh300 rstbook" id="' + obj[i].isbn + '">' +
							'<div class="-s-b-img">' +
							'<img style="width: 150px; height: auto; margin-top: 20px;" src="' + obj[i].coverLargeUrl + '"id="b-image"/>' +
							'</div>' +
							'<div class="-s-b-info">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>도서장르</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-genre">' + obj[i].categoryId + '</div>' +
							'</div>' +
							'<div class="-s-b-info">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>도서명</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-title">' + obj[i].title + '</div>' +
							'</div>' +
							'<div class="-s-b-info">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>저 자</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-author">' + obj[i].author + '</div>' +
							'</div>' +
							'<div class="-s-b-info" id="notrans">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>옮긴이</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-author">' + obj[i].translator + '</div>' +
							'</div>' +
							'<div class="-s-b-submit" id="' + obj[i].isbn + '">' +
							'<input type="button" value="책 등록" class="sel-b-submit" onclick="selrstbook()"/>' +
							'</div>' +
					'</div>');
//					$('.rstPage').append('<div class="w100perh300 rstbook" id="">' +
//							'<div class="-s-b-img">' +
//								'<img style="width: 150px; height: auto; margin-top: 20px;" src="' + obj[i].largeimg + '"id="b-image"/>' +
//							'</div>' +
//							'<div class="-s-b-info">' +
//								'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>도서장르</b> : </div>' + 
//								'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-genre">' + obj[i].gname + '</div>' +
//							'</div>' +
//							'<div class="-s-b-info">' +
//								'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>도서명</b> : </div>' + 
//								'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-title">' + obj[i].bname + '</div>' +
//							'</div>' +
//							'<div class="-s-b-info">' +
//								'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>저 자</b> : </div>' + 
//								'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-author">' + obj[i].writer + '</div>' +
//							'</div>' +
//							'<div class="-s-b-info" id="notrans">' +
//								'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>옮긴이</b> : </div>' + 
//								'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="b-author">' + obj[i].trans + '</div>' +
//							'</div>' +
//							'<div class="-s-b-submit" id="' + obj[i].bno + '">' +
//								'<input type="button" value="책 등록" id="sel-b-submit"/>' +
//							'</div>' +
//						'</div>');
				}
			},
			error : function(){
				alert("통신에러!");
			}
		});
	});
	
	$('.sel-b-submit').click(selrstbook); //검색된 도서 중 맞는 결과를 선택해주는 클릭이벤트 
	
	$(document).on('click', '#p-submit', function(){
		//이미 도서번호는 input name=bno 에 담겨져 있다.
		//select로 선택된 감정을 변수에 대입하기 
		var emo = $('#selEmo').val();
		var body = $('#postBody').val();
		var htag = $('#hash-input').val();
		alert(htag);
		$('#eno').val(emo);
		$('#body').val(body);
		$('#tags').val(htag);
//		alert(len);
		
		if(!emo){
			$('#selEmo').focus();
			return
		}
		if(!body){
			$('#postBody').focus();
			return
		}
		
		//데이터 넘기기
		$('#frm').attr('action','/BookNet/post/postWriteProc.cls');
		$('#frm').submit();
	});
	
//	var tagfunc = function(){
//		var str = $('#hash-input').val();
//	};
//	
//	$(document).on('keyup', '#hash-input', function(){ //해시태그 작성시
//		if(keyCode == 32){
//			//스페이스바 입력시 #으로 대체해준다.
//			var str = $('#hash-input')
//		}
//	});
	
});