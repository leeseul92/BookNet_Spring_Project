package com.pageturner.cls.controller.mypage;

/**
 * 이 클래스는 회원의 마이페이지 / 타인의 마이페이지와 관련된 요청을 처리해주기 위한 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.RedirectView;

import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/mypage")
public class MyPage {
	@Autowired
	MyPageService mpSrvc;
	@Autowired
	FallowService falSrvc;
	@Autowired
	AlarmService alSrvc;

	// 마이페이지 화면 요청
	@RequestMapping("/mypage.cls")
	public ModelAndView showMyPage(HttpServletRequest req, ModelAndView mv, MemberVO mVO) {
		// AOP를 통해 로그인되어있는지 확인
		if((boolean)mv.getModel().get("isLogin")) {
			String view = "mypage/mypage";
			HttpSession session = req.getSession();
			String sid = (String)session.getAttribute("SID");
			String id = mVO.getId();
			String ckFal = null;
			ArrayList<AlarmVO> alarmList = new ArrayList<AlarmVO>();
			
			if(id == null || id.equals(sid)) {
				mVO.setId(sid);
			}
			mVO = mpSrvc.getInfo(mVO);
			int cnt = mpSrvc.countPosts(mVO);
			int cntFallow = falSrvc.cntFallow(mVO);
			int cntFallower = falSrvc.cntFallower(mVO);
			ArrayList<PostsVO> postList = mpSrvc.getPostList(mVO, "");
			ArrayList<PostsVO> likeList = mpSrvc.getPostList(mVO, "YES");
			try {
				alarmList = alSrvc.getAlarmList(mVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			if(!sid.equals(id)) {
				ckFal = falSrvc.checkFal(mVO, sid);
				mv.addObject("CKFAL", ckFal);
			}
			
			if(id == null || id.equals(sid)) {
				mVO.setId(sid);
			} else {
				mVO.setId(id);
			}
			mv.addObject("INFO", mVO);
			mv.addObject("CNTPOST", cnt);
			mv.addObject("CNTFALLOW", cntFallow);
			mv.addObject("CNTFALLOWER", cntFallower);
			mv.addObject("LIKE", likeList);
			mv.addObject("POST", postList);
			mv.addObject("ALARM", alarmList);
			mv.setViewName(view);
			return mv;
		} else {
			return mv;
		}
	}
	
	@RequestMapping("/fal.cls")
	@ResponseBody
	public String chageFalState(HttpServletRequest req, String pid, String ckfal) {
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		MemberVO mVO = new MemberVO();
		
		mVO.setId(pid);
		mVO = mpSrvc.getInfo(mVO);
		
		falSrvc.fallowingState(mVO, sid, ckfal);
		mVO.setId(pid);
		mVO = mpSrvc.getInfo(mVO);
		ckfal = falSrvc.checkFal(mVO, sid);
		return ckfal;
	}
}