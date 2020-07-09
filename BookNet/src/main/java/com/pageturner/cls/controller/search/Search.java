package com.pageturner.cls.controller.search;
import java.util.List;

/**
 * 검색결과뷰로 이동시켜줄 컨트롤러다.
 * @author 서동혁
 * @since 2020-06-29
 * @version v.1.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pageturner.cls.service.SearchService;
import com.pageturner.cls.vo.SearchVO;

@Controller
@RequestMapping("/search")
public class Search {
	
	@Autowired
	SearchService sSrvc;
	
	// 검색한 결과 보여주기(ALL)
	@RequestMapping("/searchAll.cls")
	public ModelAndView searchAll(HttpServletRequest req, ModelAndView mv,HttpSession session) {
			// 뷰 지정
			String view = "search/searchAll";
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("searchinput");
			// DB에서 가져올 때 사용할 searchinput 변수
			String key = "%" + keyword + "%";
//			List<SearchVO> list = sSrvc.searchAll(key);
			List<SearchVO> book = sSrvc.searchBook(key);
			List<SearchVO> memb = sSrvc.searchMemb(key);
			List<SearchVO> hash = sSrvc.searchHash(key);
			String sid = (String) session.getAttribute("SID");
			if(sid != null) {
			// 검색결과 콘솔
			System.out.println("검색 키워드 :"+ keyword);
			System.out.println("____________________________");
			// 검색된 값 세션에 담기
			mv.addObject("KEYWORD", keyword);
			// 화면에 보여줄 오브젝트
//			mv.addObject("LIST", list);
			mv.addObject("BOOK", book);
			mv.addObject("MEMB", memb);
			mv.addObject("HASH", hash);
			mv.setViewName(view);
			} else {
				RedirectView rv = new RedirectView("/cls/main/main.cls");
				mv.setView(rv);
			}
			return mv;

	}
	// 검색한 결과 보여주기(book)
	@RequestMapping("/searchBook.cls")
	public ModelAndView searchBook(HttpServletRequest req, ModelAndView mv,HttpSession session) {
		String view = "search/searchBook";
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("bookKey");
			System.out.println("book.keyword:"+keyword);
			String key = "%" + keyword + "%";
			List<SearchVO> list = sSrvc.searchBook(key);
			String sid = (String) session.getAttribute("SID");
			if(sid != null) {
			// 검색결과 콘솔
			System.out.println("책 검색 키워드 :"+ keyword);
			System.out.println("____________________________");
			// 검색된 값 세션에 담기
			mv.addObject("KEYWORD", keyword);
			// 화면에 보여줄 오브젝트
			mv.addObject("LIST", list);
			mv.setViewName(view);
			} else {
				RedirectView rv = new RedirectView("/cls/main/main.cls");
				mv.setView(rv);
			}
			return mv;
	}
	// 검색한 결과 보여주기(Hash)
	@RequestMapping("/searchHash.cls")
	public ModelAndView searchHash(HttpServletRequest req, ModelAndView mv,HttpSession session) {
		String view = "search/searchHash";
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("hashKey");
			String key = "%" + keyword + "%";
			List<SearchVO> list = sSrvc.searchHash(key);
			String sid = (String)session.getAttribute("SID");
			if(sid != null) {
			// 검색결과 콘솔
			System.out.println("해쉬태그 검색 키워드 :"+ keyword);
			System.out.println("____________________________");
			// 검색된 값 세션에 담기
			mv.addObject("KEYWORD", keyword);
			// 화면에 보여줄 오브젝트
			mv.addObject("LIST", list);
			mv.setViewName(view);
			} else {
				RedirectView rv = new RedirectView("/cls/main/main.cls");
				mv.setView(rv);
			}
			return mv;
	}
	// 검색한 결과 보여주기(Member)
	@RequestMapping("/searchMember.cls")
	public ModelAndView searchMember(HttpServletRequest req, ModelAndView mv,HttpSession session) {
		String view = "search/searchMember";
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("membKey");
			String key = "%" + keyword + "%";
			List<SearchVO> list = sSrvc.searchMemb(key);
			String sid = (String)session.getAttribute("SID");
			if(sid != null) {
			//검색결과 콘솔
			System.out.println("아이디검색 키워드 :"+ keyword);
			System.out.println("____________________________");
			// 검색된 값 세션에 담기
			mv.addObject("KEYWORD", keyword);
			// 화면에 보여줄 오브젝트
			mv.addObject("LIST",list);
			mv.setViewName(view);
			} else {
				RedirectView rv = new RedirectView("/cls/main/main.cls");
				mv.setView(rv);
			}
			return mv;
	}
	// 검색한 결과 보여주기(Member)
	@RequestMapping("/searchError.cls")
	public ModelAndView searchError(HttpServletRequest req, ModelAndView mv) {
		String view = "search/searchError";
		mv.setViewName(view);
		return mv;
	}
	
	// 도서관 검색
	@RequestMapping("/LibraryMap.cls")
	public ModelAndView libMap(HttpServletRequest req, ModelAndView mv) {
		String view = "search/LibraryMap";
		mv.setViewName(view);
		return mv;
	}
}
