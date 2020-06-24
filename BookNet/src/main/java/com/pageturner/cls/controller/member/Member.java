package com.pageturner.cls.controller.member;
/**
 * 이 클래스는 회원정보와 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 5th Jun 2020
 *
 */

import javax.servlet.http.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.*;

import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/member")
public class Member {
	@Autowired
	MemberService membSrvc;
	
	//로그인form 요청
	@RequestMapping("/login.cls")
	public ModelAndView loginForm(HttpSession session, ModelAndView mv) {
		//세션을 통해 sid가 있는지 없는지 확인
		String sid = (String)session.getAttribute("SID");
		String view = "member/login";
		
		if(sid != null) {
			//메인으로 보내준다.
			RedirectView rv = new RedirectView("/main/main.cls");
			mv.setView(rv);
		} else {
			mv.setViewName(view);
		}
		
		return mv;
	}
	
	//로그인 처리 요청
	@RequestMapping(value="/loginProc.cls", method=RequestMethod.POST, params= {"id", "pw"})
	public ModelAndView loginProc(MemberVO mVO, ModelAndView mv, HttpSession session) {
		//jsp로부터 로그인요청이 들어오게 되면 id 와 pw 를 받아올 수 있는데, 이때 매개변수로 선언된 mVO에 자동으로 셋팅됨.
		//제대로 처리가 진행되는지 확인
		System.out.println("#### id: " + mVO.getId());
		System.out.println("#### pw: " + mVO.getPw());
		
		RedirectView rv = null;
		
		//서비스 클래스 호출 
		String id = membSrvc.loginService(mVO);
		
		if(id == null || id.length() == 0) {
			//서비스클래스로부터 넘어온 id 값이 없음 = db에 id, pw가 일치하는 회원정보가 없음.
			rv = new RedirectView("/cls/member/login.cls"); //재로그인 시키기 
		} else {
			//세션에 아이디 저장
			session.setAttribute("SID", id);
			rv = new RedirectView("/cls/main/main.cls"); //로그인한 회원용 메인으로 넘기기 
		}
		
		mv.setView(rv);
		return mv;
	}
}
