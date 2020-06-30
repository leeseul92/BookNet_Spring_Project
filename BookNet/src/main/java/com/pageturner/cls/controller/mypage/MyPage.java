package com.pageturner.cls.controller.mypage;


/**
 * 이 클래스는 회원의 마이페이지 / 타인의 마이페이지와 관련된 요청을 처리해주기 위한 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/myPage")
public class MyPage {
	@Autowired
	MyPageService mpSrvc;

	// 마이페이지 화면 요청
	@RequestMapping("/myPage.cls")
	public ModelAndView showMyPage(HttpServletRequest req, ModelAndView mv, HttpSession session, MemberVO mVO) {
		// AOP를 통해 로그인되어있는지 확인
		String view = "mypage/myPage";
		
		mpSrvc.getInfo(mVO);
		int cnt = mpSrvc.countPosts(mVO);
		
		mv.setViewName(view);
		return mv;
	}
}
