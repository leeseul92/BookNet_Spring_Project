package com.pageturner.cls.dao;
/**
 * 이 클래스는 메인화면과 관련한 요청에 대한 sql을 처리해주기 위한 클래스입니다.
 * @author leeseulkim
 * @since 10th Jun 2020
 *
 */

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pageturner.cls.vo.*;

@Repository
public class MainDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//비로그인 회원에게 보여질 메인 게시글
	public List<PostsVO> showNonMain() {
		return sqlSession.selectList("mainSQL.nonMain");
	}
	
	//로그인한 회원에게 보여질 메인 게시글 
	public List<PostsVO> showMemMain(String id) {
		return sqlSession.selectList("mainSQL.MemMain", id);
	}
	
	//본문 우측부분에 들어갈 자주 작성된 도서 5선 
	public List<PostsVO> oftenList() {
		return sqlSession.selectList("mainSQL.OftenBook");
	}
	
}
