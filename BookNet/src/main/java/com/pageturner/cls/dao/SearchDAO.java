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
	
	//검색한 결과를 회원에게 보여질 게시글
	public List<SearchVO> searchAll(String keyword) {
		System.out.println("####  DAO keyword : " + keyword);
		return sqlSession.selectList("sSQL.searchAll", keyword);	
	}
	
	
}
