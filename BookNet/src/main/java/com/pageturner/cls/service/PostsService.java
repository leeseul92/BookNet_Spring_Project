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
	
	//게시글 작성시 도서장르선택부분 처리
	public List<PostsVO> genresList() {
		List<PostsVO> list = pDAO.listGenres();
		return list;
	}
	
	//댓글 작성 처리
	public PostsVO wrtCmt(HttpSession session, PostsVO pVO) {
		int cnt = pDAO.wrtCmt(pVO); //insert 되었는지 확인용 (1 또는 0)
		pVO.setCnt(cnt);
		return pVO;
	}
	
	//댓글 삭제 처리 
	public int delCmt(int cno) {
		int rst = pDAO.delCmt(cno);
		return rst;
	}
}
