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

import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/member")
public class Member {
	@Autowired
	MemberDAO mDAO;
	
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
	public ModelAndView loginProc(String id, String pw, MemberVO mVO, ModelAndView mv, HttpSession session) {
		//제대로 처리가 진행되는지 확인
		System.out.println("#### id: " + id);
		System.out.println("#### pw: " + pw);
		
		System.out.println(mVO.getId());
		System.out.println(mVO.getPw());
		
		int cnt = mDAO.loginProc(mVO);
		
		RedirectView rv = null;
		
		if(cnt == 1) {
			session.setAttribute("SID", id); //세션에 아이디 등록해놓는다.
			rv = new RedirectView("/cls/main/main.cls");
		} else {
			//아이디와 비밀번호가 일치하는 회원이 존재하지 않으므로 다시 로그인페이지로 이동.
			rv = new RedirectView("/cls/member/login.cls");
		}
		
		mv.setView(rv);
		return mv;
	}
}
