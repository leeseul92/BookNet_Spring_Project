package com.pageturner.cls.controller.mypage;


/**
 * 이 클래스는 회원의 마이페이지 / 타인의 마이페이지와 관련된 요청을 처리해주기 위한 클래스입니다.
 * @author leeseulkim
 * @since 27th Jun 2020
 * @version v.1.0
 *
 */

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/myPage")
public class MyPage {
	@Autowired
	MyPageService mpSrvc;

	//마이페이지 화면 요청
	@RequestMapping("/myPage.cls")
	public ModelAndView showMyPage(HttpServletRequest req, ModelAndView mv, HttpSession session, MemberVO mVO) {
		//AOP를 통해 로그인되어있는지 확인 
		String view = "mypage/myPage";
		
		//세션에 저장된 id 값을 서비스 클래스로 이동시키기 
		//서비스클래스 불러오기
		String id = (String)session.getAttribute("SID");
		int mno = mpSrvc.getMno(id);
		
		mVO = mpSrvc.getMembInfo(mVO);
		
		mv.addObject("INFO", mVO);
		
		mv.setViewName(view);
		return mv;
	}
}
