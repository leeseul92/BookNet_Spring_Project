<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 게시물 상세보는 모달 -->
<div class="modal detailPost" role="none">
	<!-- 좋아요 처리해주기 위한 하트값 저장 -->
	<input type="hidden" id="ischeckDetail" name="ischeckDetail" />
	<div class="p-modal-content" id="" style="height: 540px;">
		<span class="close w-x-btn" id="">x</span>
		<div class="w100-pt10">
			<div class="wrtProf" style="width: 45px; height: 45px;">
				<img src="">
			</div>
			<div class="wrter" style="line-height: 40px;" id="">
				<a href="" style="font-size: 18px;"><b class="wrter"></b></a>
			</div>
			<div class="time" style="line-height: 40px;" id="time"></div>
		</div>
		<div class="w100-h500">
			<div class="w500-h450">
				<div class="genre-pad" id="genre-pad"></div>
				<div class="genre-pad" style="height: 35px; font-size: 25px; line-height: 25px;"><b id="genre-name"><b></b></b></div>
				<div class="book-pic">
					<!-- 도서 사진 들어갈 부분 -->
					<img id="bimg" src="" style="float: left; box-sizing: border-box;" />
				</div>
				<div class="detail-body">
					<!-- 게시글 부분 -->
					<a style="box-sizing: border-box; font-size: 13px;" id="p-body"></a>
				</div>
			<div class="w100-h35">
				<div class="like-butt" style="margin-right: 20px;" id="">
					<span style="font-size: 12px; line-height: 0px;" class="comt-img dComtbtn"></span>
				</div>
				<div class="like-butt realLkBtn" id="" style="display: flex;'">
					<span style="font-size: 12px; line-height: 0px;" class="like-img dLikebtn" id=""></span>
				</div>
				<div class="like-butt" id="" style="display: flex;'">
					<span style="font-size: 12px; line-height: 0px;" class="rev-img dRevbtn" id=""></span>
				</div>
			</div>
			</div>
			<div class="w450-h400">
				<div class="w450-h400 post-comment" style="height: 350px;" id="">
					<!-- 댓글 리스트 뽑아오기 -->
				</div>
				<div class="wrtcomt hidcommt" style="display: none;" id="">
					<div class="comwrter">
						<input type="hidden">
						<a>${SID}</a>
					</div>
					<input type="text" id="-comt-id" class="combody" placeholder="댓글을 입력하세요." />
					<input type="button" class="comsubbtn" value="등록">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>