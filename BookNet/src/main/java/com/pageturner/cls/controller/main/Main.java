package com.pageturner.cls.controller.main;
/**
 * 이 클래스는 메인화면페이지와 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 6th Jun 2020
 *
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pageturner.cls.service.MainService;
import com.pageturner.cls.service.PostsService;
import com.pageturner.cls.vo.PostsVO;

@Controller
@RequestMapping("/main")
public class Main {
	@Autowired
	MainService mainSrvc;
	
	@Autowired
	PostsService postsSrvc;
	
	//비로그인 회원 메인화면
	@RequestMapping("/non.cls")
	public ModelAndView showMainNon(HttpServletRequest req, ModelAndView mv) {
		String view = "main/none_main";
		
		List<PostsVO> list = mainSrvc.nonMain();
		
		mv.addObject("LIST", list);
		
		mv.setViewName(view);
		
		return mv;
	}
	
	//로그인한 회원 메인화면
	@RequestMapping("/main.cls")
	public ModelAndView showMain(HttpServletRequest req, ModelAndView mv, HttpSession session) {
		String view = "main/mem_main";

		//서비스클래스 불러오기
		List<PostsVO> list = mainSrvc.membMain(session);
		/*
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		*/
		List<PostsVO> mList = mainSrvc.mostRefRank();
		List<PostsVO> genre = postsSrvc.genresList();

		if(list == null) { //재로그인 시키기 
			RedirectView rv = new RedirectView("/cls/member/login.cls");
			mv.setView(rv);
		} else {
			System.out.println("*****회원용 메인게시글 불러오기 완료*****");
			mv.addObject("LIST", list); //게시글을 뷰로 넘기기
			mv.addObject("OLIST", mList); //**이후에 회원용 리스트로 꼭 변경하기!**
			session.setAttribute("GENRE", genre);//도서장르 선택할 수 있게 목록넘기기
			mv.setViewName(view);
		}
		
		return mv;
	}
	
}
