package com.pageturner.cls.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.pageturner.cls.vo.PostsVO;

/**
 * 좋아요 관련 sql 처리 클래스
 * @author	이명환
 * @since	20.07.03
 *
 */

public class LikeDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 좋아요 등록
	public int addLike(PostsVO pVO) {
		return sqlSession.insert("lSQL.add_like", pVO);
	}
	
	// 좋아요 취소
	public int cancelLike(PostsVO pVO) {
		return sqlSession.update("lSQL.cancel_like", pVO);
	}
	
	// 취소했던 글에 다시 좋아요
	public int reLike(PostsVO pVO) {
		return sqlSession.update("lSQL.re_like", pVO);
	}
	
	// 좋아요 기록여부 조회
	public int selLike(PostsVO pVO) {
		return sqlSession.selectOne("lSQL.sel_like", pVO);
	}
	
	// 좋아요 상태여부 조회
	public int selIscheck(PostsVO pVO) {
		return sqlSession.selectOne("lSQL.sel_ischeck", pVO);
	}
	
}
