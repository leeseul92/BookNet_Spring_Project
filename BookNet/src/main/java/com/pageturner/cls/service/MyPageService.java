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
	
	// 세션에 입력된 ID값을 통해 mno를 조회하여 mVO에 입력,
	// 회원정보를 조회하는 서비스처리 함수
	public MemberVO getInfo(MemberVO mVO) {
		mVO.setMno(mpDAO.getMno(mVO));
		return mpDAO.membInfo(mVO);
	}
	
	// 회원이 작성한 게시글의 갯수를 조회하는 서비스처리 함수
	public int countPosts(MemberVO mVO) {
		return mpDAO.cntPost(mVO);
	}
	
	// 회원이 작성한 게시글이나 회원이 좋아요를 누른 게시글 목록을 조회하는 서비스처리 함수
	public ArrayList<PostsVO> getPostList(MemberVO mVO, String likepost){
		PostsVO pVO = new PostsVO();
		pVO.setMno(mVO.getMno());
		pVO.setLikepost(likepost);
		ArrayList<PostsVO> list = (ArrayList<PostsVO>)mpDAO.getPost(pVO);
		return list;
	}
}
