package com.pageturner.cls.service;


/**
 * 이 클래스는 MyPage와 관련된 작업을 처리할 서비스적인 기능을 전담할 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class MyPageService {
	@Autowired
	MyPageDAO mpDAO;
	
	// 세션에 입력된 ID값을 통해 mno를 조회하여 mVO와 pVO에 입력하는 서비스처리 함수
	public void getMno(MemberVO mVO, PostsVO pVO) {
		mVO = mpDAO.getMno(mVO);
		pVO.setMno(mVO.getMno());
	}
	
	// 마이페이지에 보여줄 회원정보를 mVO에 입력하는 서비스처리 함수 
	public void getMembInfo(MemberVO mVO, String id) {
		mVO.setId(id);
		mVO = mpDAO.membInfo(mVO);
	}
	
	// 회원이 작성한 게시글의 갯수를 조회하는 서비스처리 함수
	public int countPosts(MemberVO mVO) {
		return mpDAO.cntPost(mVO);
	}
	
	// 회원이 작성한 게시글이나 회원이 좋아요를 누른 게시글 목록을 조회하는 서비스처리 함수
	public ArrayList<PostsVO> getPostList(PostsVO pVO, String likepost){
		pVO.setLikepost(likepost);
		ArrayList<PostsVO> list = (ArrayList<PostsVO>)mpDAO.getPost(pVO);
		return list;
	}
}
