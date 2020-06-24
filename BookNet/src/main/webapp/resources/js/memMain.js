/* 이 스크립트파일은 메인화면과 관련된 처리를 해주기 위한 파일입니다.
 * @author leeseul kim
 * @since 22 Jun 2020 
 */

$(document).ready(function(){
	$('#slickModal').slick({
		infinite: true,
		slidesToShow: 1,
		arrows: true,
		dots: true,
		autoplay: true,
		autoplaySpeed: 10000,
		speed: 1000,
		pauseOnHover: true
	});
});
