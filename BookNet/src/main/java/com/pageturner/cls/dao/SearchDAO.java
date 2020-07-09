package com.pageturner.cls.dao;
/**
 * 이 클래스는 검색화면과 관련한 요청에 대한 sql을 처리해주기 위한 클래스입니다.
 * @author 서동혁
 * @since 2020-06-24
 *
 */

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pageturner.cls.vo.SearchVO;


@Repository
public class SearchDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 검색한 결과 모든 게시글
	public List<SearchVO> searchAll(String keyword) {
		System.out.println("####  DAO keyword : " + keyword);
		return sqlSession.selectList("sSQL.searchAll", keyword);	
	}
	// 검색한 결과 책 게시글
	public List<SearchVO> searchBook(String keyword) {
		System.out.println("####  DAO keyword : " + keyword);
		return sqlSession.selectList("sSQL.searchBook", keyword);	
	}
	// 검색한 결과 해쉬태그 게시글
	public List<SearchVO> searchHash(String keyword) {
		System.out.println("####  DAO keyword : " + keyword);
		return sqlSession.selectList("sSQL.searchHash", keyword);	
	}
	// 검색한 결과 멤버 게시글
	public List<SearchVO> searchMemb(String keyword) {
		System.out.println("####  DAO keyword : " + keyword);
		return sqlSession.selectList("sSQL.searchMemb", keyword);	
	}
	
}
