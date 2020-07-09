package com.pageturner.cls.controller.posts;
/**
 * 이 클래스는 게시글과 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 13th Jun 2020
 *
 */

import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.*;

import com.pageturner.cls.dao.*;
import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/posts")
public class Posts {
	@Autowired
	PostsService postsSrvc;
	
	@Autowired
	InterParkService ipSrvc;
	
	//게시물 상세보기 내 댓글리스트 비동기 통신
	@RequestMapping("/showCmtList.cls")
	@ResponseBody
	public List<PostsVO> showCmtList(int pno, PostsVO pVO, HttpSession session) {
		pVO.setSid((String)session.getAttribute("SID")); //세션에 담긴 id 값 VO 클래스에 담기 
		pVO.setPno(pno);
		List<PostsVO> list = postsSrvc.showCmtList(pVO);
		System.out.println("###### pVO의 sid : " + pVO.getSid());
		System.out.println("###### pVO의 mention : " + pVO.getMention());
		return list;
	}
	
	//게시물 상세보기 내 댓글작성 비동기 통신
	@RequestMapping("/wrtCmt.cls")
	@ResponseBody
	public PostsVO wrtCmt(int pno, String cbody, HttpSession session, PostsVO pVO) {
		//현재시간 받기
		Date date = new Date();
		
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		String cdate = form1.format(date) + " " + form2.format(date);
		
		pVO.setId((String)session.getAttribute("SID")); //로그인 되어있는 id값 vo 클래스에 담기
		pVO.setCdate(cdate); //댓글작성시간 vo 클래스에 담기
		
		//service 호출 
		pVO = postsSrvc.wrtCmt(pVO);
		
		return pVO;
	}
	
	//댓글 삭제 비동기 통신 
	@RequestMapping("/delCmt.cls")
	@ResponseBody
	public int delCmt(int cno) {
		int rst = postsSrvc.delCmt(cno);
		System.out.println(rst);
		return rst;
	}
	
	//게시글 작성시 도서검색 결과 비동기통신 처리 
	@RequestMapping("/searchBook.cls")
	@ResponseBody
	public List<PostsVO> searchBook(String searchword, int genre, PostsVO pVO){
		System.out.println(searchword);
		String keyword = "%" + searchword + "%";
		pVO.setKeyword(keyword); //vo 변수에 데이터 저장 
		//InterParkAPI를 통해 검색된 결과가 db 에 저장될 수 있게하는 서비스클래스 호출 
		ipSrvc.interparkAPI(genre, keyword);
		//검색된 결과가 저장된 db로부터 결과값을 가지고 오게 할 서비스클래스 호출 
		List<PostsVO> list = postsSrvc.searchBook(pVO);
		System.out.println(list.size());
		return list;
	}
	
	//게시글 등록처리
	@RequestMapping("/addPost.cls")
	public ModelAndView addPost(ModelAndView mv, HttpSession session, PostsVO pVO) {
		pVO.setSid((String)session.getAttribute("SID"));

		RedirectView rv = new RedirectView(pVO.getDomain());
		mv.setView(rv);

		//서비스클래스 호출
		int rst = postsSrvc.addPost(pVO);
		if(rst != 1) {
			//게시글 등록 실패 
			JOptionPane.showMessageDialog(null, "게시글 업로드에 실패하였습니다.");
		}
		
		return mv;
	}
	
	//게시글 삭제처리
	@RequestMapping("/delPost.cls")
	@ResponseBody
	public int delPost(int pno) {
		return postsSrvc.delPost(pno);
	}
	
	//게시글 좋아요처리
	@RequestMapping("/likePosts.cls")
	@ResponseBody
	public String likePosts(PostsVO pVO) {
		System.out.println("Controller : " + pVO.getIscheck() + " " + pVO.getPno() + " " + pVO.getId());
		String ischeck = postsSrvc.likeProc(pVO);
		return ischeck;
	}
	
	//게시글 수정처리
	@RequestMapping("/editPost.cls")
	@ResponseBody
	public int editPost(PostsVO pVO) {
		System.out.println(pVO.getEno());
		return postsSrvc.editPostProc(pVO);
	}
}
