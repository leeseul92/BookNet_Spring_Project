package com.pageturner.cls.controller.member;

import javax.inject.Inject;

/**
 * 이 클래스는 회원정보와 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 5th Jun 2020
 *
 */

import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.*;

import com.pageturner.cls.dao.MemberDAO;
import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;
import com.pageturner.cls.util.Dice;

@Controller
@RequestMapping("/member")
public class Member {
	@Autowired
	MemberService membSrvc;
	@Autowired
	MemberDAO mDAO;
	@Inject
	JavaMailSender mailSender;

	// 로그인form 요청
	@RequestMapping("/login.cls")
	public ModelAndView loginForm(HttpSession session, ModelAndView mv) {
		// 세션을 통해 sid가 있는지 없는지 확인
		String sid = (String) session.getAttribute("SID");
		String view = "member/login";

		if (sid != null) {
			// 메인으로 보내준다.
			RedirectView rv = new RedirectView("/main/main.cls");
			mv.setView(rv);
		} else {
			mv.setViewName(view);
		}

		return mv;
	}

	// 로그인 처리 요청
	@RequestMapping(value = "/loginProc.cls", method = RequestMethod.POST, params = { "id", "pw" })
	public ModelAndView loginProc(MemberVO mVO, ModelAndView mv, HttpSession session) {
		// jsp로부터 로그인요청이 들어오게 되면 id 와 pw 를 받아올 수 있는데, 이때 매개변수로 선언된 mVO에 자동으로 셋팅됨.
		// 제대로 처리가 진행되는지 확인
		System.out.println("#### id: " + mVO.getId());
		System.out.println("#### pw: " + mVO.getPw());

		RedirectView rv = null;

		// 서비스 클래스 호출
		String id = membSrvc.loginService(mVO);

		if (id == null || id.length() == 0) {
			// 서비스클래스로부터 넘어온 id 값이 없음 = db에 id, pw가 일치하는 회원정보가 없음.
			rv = new RedirectView("/cls/member/login.cls"); // 재로그인 시키기
		} else {
			// 세션에 아이디 저장
			session.setAttribute("SID", id);
			rv = new RedirectView("/cls/main/main.cls"); // 로그인한 회원용 메인으로 넘기기
		}

		mv.setView(rv);
		return mv;
	}

	// 이명환
	// 아디비번찾기 뷰
	@RequestMapping("/findID.cls")
	public ModelAndView findID(ModelAndView mv) {
		String view = "member/findID";
		mv.setViewName(view);
		return mv;
	}

	// 이명환
	// 메일인증 처리
	@RequestMapping("/mail.cls")
	@ResponseBody
	public String mailProc(HttpServletRequest req) {
		Dice dice = new Dice();
		String cout = dice.Dice();

		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
			msgHelper.setFrom("myeongwhan@gmail.com");
			msgHelper.setTo(req.getParameter("mail"));
			msgHelper.setSubject("회원가입 인증메일 발송");
			msgHelper.setText("인증번호는 " + cout + " 입니다");

			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str = "{\"tno\": \"" + cout + "\"}";

		return str;
	}
	
	// 이명환
	// 정보수정 뷰
	@RequestMapping("/edit.cls")
	public ModelAndView edit(HttpServletRequest req, ModelAndView mv) {
		mv.setViewName("mypage/editMemb");
		return mv;
	}
	
	// 이명환
	// 정보수정(비번) 처리
	@RequestMapping("/editPW.cls")
	public ModelAndView editPW(HttpServletRequest req, ModelAndView mv, MemberVO mVO) {
		mVO.setId((String)req.getSession().getAttribute("SID"));
		int cnt = mDAO.editPW(mVO);
		
		if(cnt == 0) {
			System.out.println("정보수정(비번)처리 에러");
		}
		mv.setView(new RedirectView("마이페이지"));
		
		return mv;
	}
	
	// 이명환
	// 정보수정(유저) 처리
	@RequestMapping("/editUser.cls")
	public ModelAndView editUser(HttpServletRequest req, ModelAndView mv, MemberVO mVO) {
		mVO.setId((String)req.getSession().getAttribute("SID"));
		int cnt = mDAO.editUser(mVO);
		
		if(cnt == 0) {
			System.out.println("정보수정(유저)처리 에러");
		}
		mv.setView(new RedirectView("마이페이지"));
		return mv;
	}
	
	// 이명환
	// 회원탈퇴 처리
	@RequestMapping("/delUser.cls")
	public ModelAndView delUser(HttpServletRequest req, ModelAndView mv, MemberVO mVO) {
		mVO.setId((String)req.getSession().getAttribute("SID"));
		int cnt = mDAO.delUser(mVO);
		
		if(cnt == 0) {
			System.out.println("정보수정(유저)처리 에러");
		}
		req.getSession().removeAttribute("SID");
		mv.setView(new RedirectView("비회원메인페이지"));
		return mv;
	}
	
}
