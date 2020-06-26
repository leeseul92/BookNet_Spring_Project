package com.pageturner.cls.service;

/**
 * 이 클래스는 게시글과 관련된 요청에 대한 dao 처리를 해주기 위한 서비스클래스입니다.
 * @author leeseulkim
 * @since 19th Jun 2020
 * @version v.1.0
 *
 */
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageturner.cls.dao.PostsDAO;
import com.pageturner.cls.vo.PostsVO;

@Service
public class PostsService {
	@Autowired
	PostsDAO pDAO;
	
	//게시글 상세보기 내 댓글 리스트
	public List<PostsVO> showCmtList(PostsVO pVO){
		return pDAO.showCmtList(pVO);
	}
	
	//댓글 작성 처리
	public PostsVO wrtCmt(PostsVO pVO) {
		int cnt = pDAO.wrtCmt(pVO); //insert 되었는지 확인용 (1 또는 0)
		pVO.setCnt(cnt);
		System.out.println("작성된 댓글번호 : " + pVO.getCno()); //selectKey로부터 값이 제대로 입력되었는지 확인 
		return pVO;
	}
	
	//댓글 삭제 처리 
	public int delCmt(int cno) {
		int rst = pDAO.delCmt(cno);
		return rst;
	}
	
	//게시글 작성시 도서장르선택부분 처리
	public List<PostsVO> genresList() {
		List<PostsVO> list = pDAO.listGenres();
		return list;
	}
	
	//게시글 작성시 도서검색 처리
 	public List<PostsVO> searchBook(String word) {
		return pDAO.searchBook(word);
	}
}
