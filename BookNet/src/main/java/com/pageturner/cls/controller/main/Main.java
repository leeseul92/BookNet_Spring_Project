package com.pageturner.cls.controller.main;
/**
 * 이 클래스는 메인화면페이지와 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 6th Jun 2020
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
@RequestMapping("/main")
public class Main {
	@Autowired
	MainDAO mainDAO;
	
	@RequestMapping("/main.cls")
	public ModelAndView showMain(String id, HttpSession session, ModelAndView mv) {
		id = (String) session.getAttribute("SID");
		String view = "main/mem_main";
		
		if(id == null) {
			System.out.println("**********");
			//로그인이 풀렸으므로 로그인폼으로 보내준다.
			RedirectView rv = new RedirectView("/cls/member/login.cls");
			mv.setView(rv);
		} else {
			//게시글 부분 
			List<MainVO> list = mainDAO.showMemMain(id);
			
			//우측상단 자주 작성된 도서 5선
			List<MainVO> olist = mainDAO.oftenList();
			
			mv.addObject("LIST", list); //게시글을 뷰로 넘기기
			mv.addObject("OLIST", olist);
			mv.setViewName(view);
		}
		
		
		return mv;
	}
}
