package com.pageturner.cls.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.pageturner.cls.vo.LikeVO;

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
	public int addLike(LikeVO lVO) {
		return sqlSession.insert("lSQL.add_like", lVO);
	}
	
	// 좋아요 취소
	public int cancelLike(LikeVO lVO) {
		return sqlSession.insert("lSQL.cancel_like", lVO);
	}
	
	// 취소했던 글에 다시 좋아요
	public int reLike(LikeVO lVO) {
		return sqlSession.insert("lSQL.re_like", lVO);
	}
	
	// 좋아요 기록여부 조회
	public int selLike(LikeVO lVO) {
		return sqlSession.insert("lSQL.sel_like", lVO);
	}
	
	// 좋아요 상태여부 조회
	public int selIscheck(LikeVO lVO) {
		return sqlSession.insert("lSQL.sel_ischeck", lVO);
	}
	
}
