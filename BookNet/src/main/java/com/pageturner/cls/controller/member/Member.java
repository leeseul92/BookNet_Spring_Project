package com.pageturner.cls.controller.member;

/**
 * 이 클래스는 회원정보(로그인, 회원가입 등)와 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 5th Jun 2020
 *
 */

import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;
import javax.inject.Inject;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.*;

import com.pageturner.cls.dao.*;
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
	@Autowired
	ProfileDAO fDAO;
	@Autowired
	ProfileService pSrvc;
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

	// 이명환
	// 아디비번찾기 뷰
	@RequestMapping("/findID.cls")
	public ModelAndView findUser(ModelAndView mv) {
		String view = "member/findUser";
		mv.setViewName(view);
		return mv;
	}

	// 이명환
	// 아이디 찾기 처리
	@RequestMapping("/findIDProc.cls")
	@ResponseBody
	public String findIDProc(HttpServletRequest req, MemberVO mVO) {
		String fid = mDAO.findID(mVO);
		String str = "{\"id\": \"" + fid + "\"}";
		return str;
	}

	// 이명환
	// 비번 찾기 처리
	@RequestMapping("/findPWProc.cls")
	@ResponseBody
	public String findPWProc(HttpServletRequest req, MemberVO mVO) {
		String fpw = mDAO.findPW(mVO);
		String str = "{\"pw\": \"" + fpw + "\"}";
		return str;
	}

	// 이명환
	// 인증번호 메일 보내기 처리
	@RequestMapping("/mail.cls")
	@ResponseBody
	public String mailProc(HttpServletRequest req) {
		Dice dice = new Dice();
		String cout = dice.Dice();	// 랜덤문자 변수에 담기

		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
			msgHelper.setFrom("pageTurner");	// 보내는 사람
			msgHelper.setTo(req.getParameter("mail"));	// 받는 사람
			msgHelper.setSubject("회원가입 인증메일 발송");	// 제목
			msgHelper.setText("인증번호는 " + cout + " 입니다");	// 내용

			mailSender.send(msg);	// 보내기
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str = "{\"tno\": \"" + cout + "\"}";	// js에 기억시키기 위해 랜덤문자 전달

		return str;
	}

	// 이명환
	// 정보수정 뷰
	@RequestMapping("/editMemInfo.cls")
	public ModelAndView edit(HttpServletRequest req, ModelAndView mv) {
		mv.setViewName("mypage/editMemb");
		String sid = (String) req.getSession().getAttribute("SID");
		List<MemberVO> list = mDAO.selUser(sid);
		List<PostsVO> genre = mDAO.genre();
		mv.addObject("LIST", list);
		mv.addObject("GENRE", genre);
		
		return mv;
	}

	// 이명환
	// 정보수정(비번) 처리
	@RequestMapping("/editPW.cls")
	public ModelAndView editPW(HttpServletRequest req, ModelAndView mv, MemberVO mVO) {
		mVO.setId((String) req.getSession().getAttribute("SID"));
		int cnt = mDAO.editPW(mVO);

		if (cnt == 0) {
			System.out.println("정보수정(비번)처리 에러");
		}
		mv.setView(new RedirectView("/cls/mypage/mypage.cls"));

		return mv;
	}

	// 이명환
	// 정보수정(유저) 처리
	@RequestMapping("/editUser.cls")
	public ModelAndView editUser(HttpServletRequest req, ModelAndView mv, MemberVO mVO, ProfileVO fVO) {
		mVO.setId((String) req.getSession().getAttribute("SID"));
		int cnt = mDAO.editUser(mVO);

		// editUser() 실행 후, 파일이 선택된 경우(size가 있는 경우) 업로드 함수 실행
		if (cnt == 1 && fVO.getFile().getSize() != 0) {
			fVO.setId(mVO.getId());
			mDAO.updateProfile(fVO);
			String savename = pSrvc.uploadProc(req.getSession(), fVO.getFile());
			fVO.setOri_name(fVO.getFile().getOriginalFilename());
			fVO.setSave_name(savename);
			mVO.setSave_name(savename);
			int ck = mDAO.editProfile(fVO);
			if(ck != 1) {
				System.out.println("정보수정(프사업로드) 에러");
			}
		} else {
			System.out.println("정보수정(유저)처리 에러");
		}
		
		mv.setView(new RedirectView("/cls/mypage/mypage.cls"));
		return mv;
	}

	// 이명환
	// 회원탈퇴 처리
	@RequestMapping("/delUser.cls")
	public ModelAndView delUser(HttpServletRequest req, ModelAndView mv, MemberVO mVO) {
		mVO.setId((String) req.getSession().getAttribute("SID"));
		int cnt = mDAO.delUser(mVO);

		if (cnt == 0) {
			System.out.println("정보수정(탈퇴)처리 에러");
		}
		req.getSession().removeAttribute("SID");
		mv.setView(new RedirectView("/cls/main/non.cls"));
		return mv;
	}

	// 우현우
	// 로그인 처리
	@RequestMapping(value = "/loginProc", method = RequestMethod.POST, params = { "id", "pw" })
	public ModelAndView loginProc(MemberVO mVO, ModelAndView mv, HttpSession session, RedirectView rv) {

		int cnt = mDAO.getLogin(mVO);
		rv = null;
		String view = "member/login";
		// sid가 null이 아니면 메인으로 Redirect시키고 null이면 로그인 창에 머물게 하기
		if (cnt == 1) {
			session.setAttribute("SID", mVO.getId());
			rv = new RedirectView("/cls/main/main.cls");
		} else {
			rv = new RedirectView("/cls/member/login.cls");
		}
		mv.setView(rv);
		return mv;
	}

	// 우현우
	// 로그아웃 처리
	@RequestMapping("/logoutProc.cls")
	public ModelAndView logout(ModelAndView mv, HttpSession session, RedirectView rv) {
		String view = "/cls/main/non.cls";
		rv = null;
		session.removeAttribute("SID");
		if (session.getAttribute("SID") != null) {
			view = "/cls/main";
		}
		rv = new RedirectView(view);
		mv.setView(rv);
		return mv;
	}

	// 우현우
		// 회원가입 폼 요청
		@RequestMapping("/join.cls")
		public ModelAndView joinForm(ModelAndView mv, HttpSession session) {
			String sid = (String) session.getAttribute("SID");
			String view = "member/join";
			if (sid != null) {
				RedirectView rv = new RedirectView("main");
				mv.setView(rv);
			} else {
				mv.setViewName(view);
			}
			List<PostsVO> genre = mDAO.genre();
			mv.addObject("GENRE", genre);
			return mv;
		}

	// 우현우
	// 아이디 중복여부 확인 요청
	@RequestMapping("/idck.cls")
	@ResponseBody
	public Map idcheck(String id) {
		HashMap map = new HashMap();
		map.put("cnt", mDAO.idcheck(id));
		return map;
	}
	
	//우현우
	// 이메일 중복 여부 확인 요청
	@RequestMapping("/mailck.cls")
	@ResponseBody
	public Map mailck(MemberVO mVO) {
		mVO = new MemberVO();
		HashMap map = new HashMap();
		map.put("cnt", mDAO.mailck(mVO));
		return map;
	}
	// 우현우
		// 회원가입 처리
		@RequestMapping("/joinProc.cls")
		public ModelAndView joinProc(HttpSession session, ModelAndView mv, MemberVO mVO, RedirectView rv) {		
			try {
			int cnt = mDAO.join(mVO);
			rv = null;
			if (cnt == 1) {
				session.setAttribute("SID", mVO.getId());
					
				rv = new RedirectView("/cls/main/main.cls");
			} else {
					rv = new RedirectView("/cls/main/non.cls");
			}
			mv.setView(rv);
			} catch (Exception e) {
				String view = "error/error";
				mv.setViewName(view);
			}
				return mv;
		}	
}
