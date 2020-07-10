/*

 * 이 스크립트는 javascript 및 jquery 진행을 위한 스크립트 파일입니다.
 * 웹 내 이벤트 처리를 담당하며 ajax 처리 또한 존재합니다.
 * @author leeseul kim
 * @since 25th May 2020
 * 
 */


//모달 밖의 뷰 url을 가지고오는 함수
function getDomain(){
	var dom = document.location.href.split('/');
	var domain = "";
	for(var i = 3; i < dom.length; i++){
		var tmp = "/" + dom[i];
		domain += tmp;
	}
	return domain;
}

//글쓰기모달에서 검색된 도서 중 하나를 클릭했을 때 정보를 가져오도록 하는 함수 
function selrstbook(id){ 
	//도서번호 가져오기 
	var sbno= id;
	var simg = document.getElementById('img'+sbno).getAttribute('src'); 
	var sbname = document.getElementById('bname'+sbno).innerText; 
	var sgname = document.getElementById('gname'+sbno).innerText;
	document.getElementById('-s-b-modal').style.display = "none";
	$('.rstPage').html('');
	$('#findBook').val(''); //검색어부분 사라지게 하기 
	//값을 frm에 저장 
	$('#bno').val(sbno);
	$('#sel-wrt-b-img').attr('src', simg);
	$('#rst-book-gname').html('<small>' + sgname + '</small>');
	$('#rst-book-bname').html('<b>' + sbname + '</b>');
}

//replaceAll 함수 만들기
String.prototype.replaceAll = function(org, dest){
	return this.split(org).join(dest);
}

//작성한 글에서 해시태그 분리해주는 자바스크립트 함수 
function splitedHash(body){
	var content = body;
//	var content = document.getElementById('postBody').innerText();
	content = content.replaceAll(/(\n)/g, ' ');
	var splitedArr = content.split(' '); //게시글 전체를 띄어쓰기로 구분하여 배열에 저장
	var regExp = /^[#]([_가-힣ㅏ-ㅣㄱ-ㅎ0-9a-zA-Z]{1,20})$/i;
	var tags = '';
	for(var hash in splitedArr){
		hash = splitedArr[hash];
		
		//#으로 시작하는 단어만 추출하기
		//단, 연속으로 # 표시가 오거나, 하나의 #만 오는 경우는 추출하지 않는다.
		if(regExp.test(hash)){
			tags += hash;
		}
	}
	
	return tags;
}

//댓글 리스트 불러주는 비동기통신 함수 
function showCmtList(pno, tid){
	var sid = document.getElementById('sid').value;
	
	$.ajax({
		url: '/cls/posts/showCmtList.cls',
		type: 'POST',
		dataType: 'json',
		data: {
			'pno': pno
		},
		success: function(obj){
			var len = obj.length;
			if(len != 0){
				for(var i = 0; i < len; i++){
					if(sid == obj[i].id){
						$('#'+tid).append('<div style="width: 100%; height: 30px;" id="' + tid + '">' +
								'<div style="float: left; width: 30px; height: 30px; margin-left: 10px; border: 1px dashed black;">' +
								'<img src="" style="box-sizing: border-box;"/>' +
								'</div>' +
								'<div class="h30-m10" style="width: 60px;"><a href="" id="id' + obj[i].cno + '" >' + obj[i].id + '</a></div>' +
								'<div class="h30-m10" style="width: 150px;"><small>' + obj[i].cdate + '</small></div>' +
								'<button class="h30-m10 butt" id="' + obj[i].cno + '" style="float: right; width: 60px;" onclick="replyCmt(this);">Reply</button>' +
								'<button class="h30-m10 butt" style="float: right; width: 60px;" onclick="delCmt(this);">Delete</button>' +
								'</div>' +
								'<div class="h30-m10" style="width: 100%;">' + obj[i].comnt + '</div>');
					} else {
						$('#'+tid).append('<div style="width: 100%; height: 30px;"id="' + tid + '">' +
								'<div style="float: left; width: 30px; height: 30px; margin-left: 10px; border: 1px dashed black;">' +
								'<img src="" style="box-sizing: border-box;"/>' +
								'</div>' +
								'<div class="h30-m10" style="width: 60px;"><a href="" id="id' + obj[i].cno + '" >' + obj[i].id + '</a></div>' +
								'<div class="h30-m10" style="width: 150px;"><small>' + obj[i].cdate + '</small></div>' +
								'<button class="h30-m10 butt" id="' + obj[i].cno + '" style="float: right; width: 60px;" onclick="replyCmt(this);">Reply</button>' +
								'</div>' +
								'<div class="h30-m10" style="width: 100%;">' + obj[i].comnt + '</div>');
					}
					$('.detailPost').css('display', 'block');
				}
			} else {
				$('.detailPost').css('display', 'block');
			}
		},
		error: function(){
			alert("실패!");
		}
	});
}

//대댓글 달아주기 
function replyCmt(element){
	var cno = element.getAttribute('id');
	var id = $('#id'+cno).html();
	$('.wrtcomt').css('display', '');
	$('.wrt-hid').css('height','460px');
	$('.combody').val('@'+id);
}

//댓글 삭제처리해주는 함수 
function delCmt(element){
	var tid = element.parentNode.getAttribute('id'); // cmt+숫자 의 형태임.
	var pno = tid.substr(3);
//	alert(pno);
	
	var cno = element.previousSibling.getAttribute('id');
	alert(cno);
	
	//비동기처리 
	$.ajax({
		url: '/cls/posts/delCmt.cls',
		type: 'POST',
		dataType: 'json',
		data: {
			'cno': cno
		},
		success: function(rst){
			if(rst != 1){
				alert('댓글삭제 실패!');
			}
			
			if(rst == 1){
				$('#'+tid).html('');
				showCmtList(pno, tid);
			}
		},
		error: function(){
			alert('실패!');
		}
	});
}

//jQuery 시작 
$(document).ready(function(){
	//like 버튼 눌리는 뷰가 모달인지 아닌지 판별해주는 함수
	var checkModal = function(){
		var str = null;
		
		if($('.detailPost').css('display') == 'none'){
			//모달 열리지 않았음.
			str = 'ischeck';
		} else {
			str = 'ischeckDetail';
		}
		
		return str;
	}
	
	//like 버튼 뷰와 모달 서로 동기화시켜서 서로 같은 모양띄워주도록 하는 함수
	var checkIf = function(element1, element2){
		if($('#'+element1).css('background-position') == '-208px -370px'){
			//빨간하트
			$('#'+element2).css('background-position', '-208px -370px');
		} else{
			//빈하트
			$('#'+element2).css('background-position', '-233px -370px');
		}
	}
	
	// search clear
	var $ipt = $('#searchinput'),
	    $clearIpt = $('#searchclear');
			// keyup시 x표시
		$ipt.keyup(function(){
		  $("#searchclear").toggle(Boolean($(this).val()));
		});
			
			
		$clearIpt.toggle(Boolean($ipt.val()));
		$clearIpt.click(function(){ 
		  $("#searchinput").val('').focus();
		  // display 속성을 none으로 바꾼다. : 감춘다
		  $(this).hide();
		});
	
	$(document).scroll(function() {
		var maxHeight = $(document).height();
		var currentScroll = $(window).scrollTop() + $(window).height();
		if (maxHeight <= currentScroll + 100) {
			$('.posts_area').append('<article class="eachPost" id="이곳은게시물번호가들어갈자리"><!-- 작성자 정보 & 버튼 :: 아이디 불러와야함  --><div class="wrtInfo"><div class="wrtProf"><img src="https://img.icons8.com/cotton/64/000000/apple--v1.png"/></div><div class="wrter" id=""><b>작성자아이디</b></div><div class="like-butt" id=""><span style="font-size: 12px; line-height: 0px;" class="comt-img"></span></div><div class="like-butt" id="" style="display: flex;"><span style="font-size: 12px; line-height: 0px;" class="like-img" id="likebtn"></span></div></div><!-- 게시글의 본문부분::도서사진,도서이름,본문 --><div class="postCont" style="text-align: center; font-size: 16px;"><!-- 도서사진, 도서이름, 게시글본문 --><div class="book-pic"><!-- 도서 사진 들어갈 부분 --></div><div class="book-name"><!-- 도서명 들어갈 부분 --></div><div class="post-body"><!-- 게시글 부분 --></div></div><div class="etcdiv" style="text-align: center; font-size: 16px;">태그<!-- 게시글 해시태그 부분 --></div></article>');
		}
		
	});
	
	// 엔터검색
	$('.searchinput').keyup(function(e) {
		if (e.keyCode == 13) {
			var key = $('.searchinput').val();
			$('#searchinput').val(key);
			$('#frm3').attr('action', '/cls/search/searchAll.cls');
			$('#frm3').submit();
		}
	});
	
	//베스트셀러 모달 닫기 
	$('#r-close_butt').click(function(){
		$('.slideRank').css('display', 'none');
	});
	
	//알림페이지로 이동 
	$('#more_butt').click(function() {  
		$(location).attr('href', '/cls/alarm/alarmPage.cls');
	});

	//알림 모달 열기 
	$('#aBtn').click(function() { 
		$('#actModal').css('display', 'block');
	});

	//알림 모달 닫기 
	$('#a-close_butt').click(function() {  
		$('#actModal').css('display', 'none');
	});

	//게시글작성시 도서검색결과 모달 닫기 
	$('#s-close_butt').click(function() { 
		$('#-s-b-modal').css('display', 'none');
		$('.rstPage').html('');
		$('#findBook').val('');
	});
	
	//마이페이지로 이동 
	$('#myBtn').click(function(){
		$(location).attr('href', '/cls/mypage/mypage.cls');
	});
	
	//좋아요처리 
	$('.likebtn, .dLikebtn').click(function(){ 
		var pno = $(this).parents().attr('id');
		var sid = $('#sid').val();
		var likeStatus = $(this).attr('id');
		alert(likeStatus);
		
		//뷰인지 모달인지 체크해줄 함수 선언 
		var str = checkModal();
		
		if($(this).css('background-position') == '-208px -370px') {
			//만일, 하트가 빨간색이라면 ischeck에 'Y' 대입
			$('#'+str).val('Y');
		} else {
			//만일, 하트가 비어있다면 ischeck에 'N' 대입 (NULL값은 자바에서 확인)
			$('#'+str).val('N');
		}
		
		var ischeck = $('#'+str).val();
		
		//비동기처리 
		$.ajax({
			url: '/cls/posts/likePosts.cls',
			type: 'POST',
			dataType: 'text',
			data: {
				'ischeck' : ischeck,
				'pno': pno,
				'id': sid
			},
			success: function(data){
//				alert(data);
				if(data == 'Y'){
					$('#'+likeStatus).css('background-position', '-208px -370px');
					$('#'+str).val('Y');
				} else {
					$('#'+likeStatus).css('background-position', ' -233px -370px');
					$('#'+str).val('N');
				}
			},
			error: function(request, status, error){
				alert("code = " + request.status + " message = " + request.responseText + " error = " + error);
			}
		});
	});
	
	//게시글 수정 삭제 선택하게 하는 모달 
	$('.edbtn').click(function(){  
		$('.edit-del-modal').css('display', 'block');
		//frm2에 값을 전달해주어야함. 
		var pno = $(this).parents().attr('id');
		$('#pno').val(pno); 
	});
	
	//게시글 수정처리 
	$('#e-btn').click(function(){  
		var pno = $('#pno').val();
		$('.edit-del-modal').css('display', 'none');
		$('#pbody'+pno).css('display', 'none');
		$('#ebody'+pno).css('display', 'block');
		$('.editButton').css('display', 'inherit');
		$('.emotiondiv').css('display', 'block');
		
		$('#eSubmit'+pno).click(function(){
			var editbody = $('#ebody'+pno).val();
			var editemotion = $('#editemo'+pno).val();
			
			alert(editbody);
			//수정된 게시글 해시태그 분리하기
			var hash = splitedHash(editbody);
			
			//수정처리 비동기처리
			$.ajax({
				url: '/cls/posts/editPost.cls',
				type: 'POST',
				dataType: 'json',
				data: {
					'pno': pno,
					'postcont': editbody,
					'eno': editemotion,
					'hash': hash
				},
				success: function(rst){
					if(rst == 1){
						alert('게시글이 수정되었습니다.');
					} else {
						alert('게시글이 수정에 실패하였습니다.');
					}
				},
				error: function(){
					alert('##통신에러##');
				}
			});
		})
	});
	
	//게시글 삭제처리 
	$('#d-btn').click(function(){ 
		var pno = $('#pno').val();
		$('#frm2').submit();
		
		$.ajax({
			url: '/cls/posts/delPost.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				'pno' : pno
			},
			success: function(rst){
				if(rst == 1){
					alert('삭제가 완료되었습니다.');
				} else {
					alert('삭제에 실패하였습니다.');
				}
			},
			error: function(){
				alert('##통신에러##');
			}
		});
	});
	
	//게시글 수정삭제 모달 닫기 
	$('#c-btn').click(function(){  
		//수정삭제 모달 닫아주어야한다.
		$('.edit-del-modal').css('display', 'none');
	});
	
	//댓글버튼 클릭시 댓글 달 수 있는 div 보여주기 
	$('.dComtbtn').click(function(){  
		$('.wrtcomt').css('display', '');
		$('.wrt-hid').css('height','460px');
	});
	
	//게시글 상세보기 모달 
	$('.modi_post').click(function(){ 
		var pno = $(this).attr('id'); //게시글번호
		var id = $('#id'+pno).text(); //작성자 아이디
		var stime = $('#time'+pno).html(); //작성시간 
		var simg = $('#img'+pno).attr('src'); //선택도서 사진
		var sgen = $('#genre'+pno).text(); //선택도서 장르 
		var bname = $('#bname'+pno).text(); //선택도서 제목
		var pbody = $('#pbody'+pno).text(); //본문 
		var htags = $('#hash'+pno).text(); //해시태그 
		
		$('.realLkBtn').attr('id', pno);
		$('.dLikebtn').attr('id', 'dLike'+pno);
		$('.w-x-btn').attr('id', 'd-close_butt'+pno);
		$('b.wrter').html(id);
		$('#time').html(stime);
		$('#bimg').attr('src', simg);
		$('#genre-pad').html(sgen);
		$('b#genre-name').html(bname);
		$('#p-body').html(pbody);
		$('#gethash').html(htags);
		
		//if로 뷰와 모달의 좋아요 버튼을 연동시켜줄 함수 호출
		checkIf('like'+pno, 'dLike'+pno);
		
		//댓글부분 큰 div에 해당게시글 번호를 id 값으로 준다.
		var tid = 'cmt' + pno;
		$('.post-comment').attr('id', tid);

		//게시물 상세보기 닫기 
		$('#d-close_butt'+pno).click(function(){ 
			checkIf('dLike'+pno, 'like'+pno);
			$('.detailPost').css('display', 'none');
			$('#'+tid).html('');
			var str = $('.combody').val();
			if(str){
				$('.combody').val('');
			}
			$('.wrtcomt').css('display', 'none'); //댓글달기위한 창 닫기 
		});

		//상세보기 게시물에서 보여줄 댓글리스트 비동기통신 함수호출
		showCmtList(pno, tid);
		
	});
	
	//댓글 등록처리 
	$('.comsubbtn').click(function(){ 
		var pno = $('.realLkBtn').attr('id');
		alert(pno);
		var cbody = $('.combody').val();
		var tid = 'cmt' + pno;
		
		$.ajax({
			url: '/cls/posts/wrtCmt.cls',
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
				if(data.cnt == 1){
					$('.combody').val('');
					$('.post-comment').prepend('<div style="width: 100%; height: 30px;" id="' + tid + '">' +
							'<div style="float: left; width: 30px; height: 30px; margin-left: 10px; border: 1px dashed black;">' +
							'<img src="" style="box-sizing: border-box;"/>' +
							'</div>' +
							'<div class="h30-m10" style="width: 60px;"><a href="">' + data.id + '</a></div>' +
							'<div class="h30-m10" style="width: 150px;"><small>' + data.cdate + '</small></div>' +
							'<button class="h30-m10 butt" id="' + data.cno + '" style="float: right; width: 60px;" onclick="replyCmt(this);">Reply</button>' +
							'<button class="h30-m10 butt" style="float: right; width: 60px;" onclick="delCmt(this);">Delete</button>' +
							'</div>' +
							'<div class="h30-m10" style="width: 100%;">' + data.cbody + '</div>');
				}
			},
			error: function(){
				alert("###통신에러###");
			}
		});
	});
	
	//게시글작성 모달 열기 
	$('#wBtn').click(function(){ 
		$('#writeModal').css('display', 'block');
	});
	
	//게시글작성 모달 닫기 
	$('#w-close_butt, #c-submit').click(function(){  
		$('#writeModal').css('display', 'none');
		$('.rstPage').html('');
		$('#findBook').val('');
		$('#sel-wrt-b-info').attr('src', '');
		$('#rst-book-gname').val('');
		$('#rst-book-bname').val('');
	});
	
	//회원 정보수정하기 페이지 이
	$('#changeInfo').click(function(){ 
		$(location).attr('href', '/cls/member/editMemInfo.cls');
	});
	
	//글작성 도서검색 ajax 처리 구문
	$('#book-search').click(function(){ //글쓰기 모달에서 읽은 도서 검색 클릭시 처리해주는 함수 
		//입력한 검색어를 변수에 저장한다.
		var book = $('#findBook').val();
		//선택된 도서장르 번호를 변수에 저장
		var genre = $('#setGenre').val();
		//검색어 유효성 검사
		if(!book){
			$('#findBook').focus();
			return;
		}
		if(!genre){
			$('#setGenre').focus();
			return;
		}
		
		//검색결과 모달 띄우기 
		$('#-s-b-modal').css('display', 'block');
		
		$.ajax({ 
			url : '/cls/posts/searchBook.cls',
			type : 'POST',
			dataType : 'json',
			data : {
				'searchword' : book,
				'genre' : genre
			},
			success : function(obj){ 
				//정보 들어갈 부분 생성해주기 
				$('#w-modal-content').css('height', '580px');
				$('#wrt-b-img').css('display', '');
				$('#sel-wrt-b-info').css('display', '');
				for(var i = 0; i < obj.length; i++){
					$('.rstPage').append('<div class="w100perh300 rstbook" id="' + obj[i].bno + '">' +
							'<div class="-s-b-img">' +
							'<img style="width: 150px; height: auto; margin-top: 20px;" src="' + obj[i].largeimg + '"id="img' + obj[i].bno + '"/>' +
							'</div>' +
							'<div class="-s-b-info">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>도서장르</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="gname' + obj[i].bno + '">' + obj[i].gname + '</div>' +
							'</div>' +
							'<div class="-s-b-info">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>도서명</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="bname' + obj[i].bno + '">' + obj[i].bname + '</div>' +
							'</div>' +
							'<div class="-s-b-info">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>저 자</b> : </div>' + 
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="writer' + obj[i].bno + '">' + obj[i].writer + '</div>' +
							'</div>' +
							'<div class="-s-b-info" id="notrans">' +
							'<div style="float: left; margin-right: 15px; font-size: 15px;"><b>옮긴이</b> : </div>' +
							'<div style="float: left; font-size: 15px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" id="trans' + obj[i].bno + '">' + obj[i].trans + '</div>' +
							'</div>' +
							'<div class="-s-b-submit" >' +
							'<input type="button" value="책 등록" id="' + obj[i].bno + '" class="sel-b-submit" onClick="selrstbook(this.id)"/>' +
							'</div>' +
					'</div>');
				}
			},
			error : function(){
				alert("통신에러!");
			}
		});
	});

	//게시글 등록 처리
	$(document).on('click', '#p-submit', function(){ 
		var dom = document.location.href.split('/');
		var domain = "";
		for(var i = 3; i < dom.length; i++){
			var tmp = "/" + dom[i];
			domain += tmp;
		}
		
		var bno = $('#bno').val();
		//select로 선택된 감정을 변수에 대입하기 
		var emo = $('#selEmo').val();
		var body = $('#postBody').val();
		//게시글본문 안에 있는 해시태그만 골라내기 
		var htag = splitedHash(body);
		
		//데이터 집어넣기 
		$('#eno').val(emo);
		$('#postcont').val(body);
		$('#hash').val(htag);
		$('#domain').val(domain);
		
		//데이터 유효성 검사 
		if(!bno){		
			alert('작성할 책을 검색해주세요!');
			$('#findBook').focus();
			return;
		}
//		if(!emo){
//			alert('당시의 감정을 선택해주세요!');
//			$('#selEmo').focus();
//			return
//		}
		if(!body){
			alert('게시글 본문을 입력해주세요!');
			$('#postBody').focus();
			return
		}
		
		//데이터 넘기기
		$('#frm').attr('action','/cls/posts/addPost.cls');
		$('#frm').submit();
	});

	
});